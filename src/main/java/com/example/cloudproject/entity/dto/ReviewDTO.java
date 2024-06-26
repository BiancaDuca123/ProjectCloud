package com.example.cloudproject.entity.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ReviewDTO {
    private String reviewId;
    private String text;
    private Integer bookId;
    private Integer rating;
    MultipartFile file;
}
