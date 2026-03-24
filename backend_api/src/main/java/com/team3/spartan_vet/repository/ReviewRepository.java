package com.team3.spartan_vet.repository;

import com.team3.spartan_vet.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}