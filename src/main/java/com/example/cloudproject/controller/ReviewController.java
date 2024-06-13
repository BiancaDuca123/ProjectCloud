package com.example.cloudproject.controller;
import com.example.cloudproject.entity.dto.ReviewDTO;
import com.example.cloudproject.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import com.example.cloudproject.entity.dto.MenuReviewDTO;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public List<MenuReviewDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @PostMapping
    public void addReview( @ModelAttribute ReviewDTO reviewDTO) throws IOException {
        reviewService.addReview(reviewDTO);
    }
}
