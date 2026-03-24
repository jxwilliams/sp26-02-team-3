package com.team3.spartan_vet.repository;

import com.team3.spartan_vet.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}