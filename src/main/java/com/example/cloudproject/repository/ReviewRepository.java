package com.example.cloudproject.repository;

import com.example.cloudproject.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByBookId(Integer recipeId);
}
