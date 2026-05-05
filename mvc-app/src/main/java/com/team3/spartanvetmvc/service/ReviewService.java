package com.team3.spartanvetmvc.service;

import com.team3.spartanvetmvc.entity.Review;
import com.team3.spartanvetmvc.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // Gets all customer reviews for the provider dashboard.
    public List<Review> getAllReviews() {
        return reviewRepository.findAllByOrderByReviewDateDescIdDesc();
    }

    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
