package com.team3.spartanvetmvc.repository;

import com.team3.spartanvetmvc.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByOrderByAppointmentDateAscIdAsc();

    List<Booking> findByCustomerNameIgnoreCaseOrderByAppointmentDateDescIdDesc(String customerName);
}
