package com.example.cloudproject.service;

import com.azure.core.util.BinaryData;
import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.queue.QueueClient;
import com.example.cloudproject.entity.Review;
import com.example.cloudproject.entity.dto.ReviewDTO;
import com.example.cloudproject.repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {

    private static final String BLOB_BASE_URL = "";

    private final ReviewRepository commentRepository;
    private final BlobContainerClient bookBlobContainerClient;
    private final QueueClient queueClient;
    private final ObjectMapper objectMapper;

    @Transactional
    public void addReview(Integer userId, ReviewDTO commentDTO) throws IOException {
        String commentImgKey = "review-img-" + UUID.randomUUID() + ".bytes";
        BlobClient blobClient = bookBlobContainerClient.getBlobClient(commentImgKey);
        blobClient.upload(BinaryData.fromBytes(commentDTO.getFile().getBytes()), true);

        String imageLinkOriginal = BLOB_BASE_URL + commentImgKey;
        Review comment = commentRepository.save(Review.builder()
                .text(commentDTO.getText())
                .imageLinkOriginal(imageLinkOriginal)
                .bookId(commentDTO.getBookId())
                .rating(commentDTO.getRating())
                .build()
        );

        queueClient.sendMessage(objectMapper.writeValueAsString(Map.of(
                "commentId", comment.getReviewId(),
                "commentImgKey", commentImgKey
        )));
    }
}
