package com.example.cloudproject.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuReviewDTO {
    private String reviewId;
    private String text;
    private Integer bookId;
    private Integer rating;
    private String thumbnailImageLink;
    private String originalImageLink;
}
