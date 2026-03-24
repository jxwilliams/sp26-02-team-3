package com.team3.spartan_vet.service;

import com.team3.spartan_vet.entity.Review;
import com.team3.spartan_vet.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.orElse(null);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Review existingReview = getReviewById(id);

        if (existingReview != null) {
            existingReview.setCustomerName(updatedReview.getCustomerName());
            existingReview.setComment(updatedReview.getComment());
            existingReview.setRating(updatedReview.getRating());
            return reviewRepository.save(existingReview);
        }

        return null;
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}