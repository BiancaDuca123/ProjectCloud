package com.example.cloudproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_pk", unique = true, nullable = false, insertable = false, updatable = false)
    private Integer reviewId;

    @Column(name = "text")
    private String text;

    @Column(name = "image_link_thumbnail")
    private String imageLinkThumbnail;

    @Column(name = "image_link_original")
    private String imageLinkOriginal;

    @Column(name = "book_pk")
    private Integer bookId;

    @Column(name = "rating")
    private Integer rating;
}
