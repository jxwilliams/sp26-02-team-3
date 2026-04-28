package com.team3.spartan_vet.service;

import com.team3.spartan_vet.entity.Booking;
import com.team3.spartan_vet.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    public Booking createBooking(Booking booking) {
        if (booking.getStatus() == null || booking.getStatus().isBlank()) {
            booking.setStatus("Pending");
        }
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existing = getBookingById(id);

        if (existing != null) {
            existing.setPetName(updatedBooking.getPetName());
            existing.setServiceType(updatedBooking.getServiceType());
            existing.setAppointmentDate(updatedBooking.getAppointmentDate());
            existing.setStatus(updatedBooking.getStatus());
            return bookingRepository.save(existing);
        }

        return null;
    }

    public Booking updateBookingStatus(Long id, String status) {
        Booking existing = getBookingById(id);

        if (existing != null) {
            existing.setStatus(status);
            return bookingRepository.save(existing);
        }

        return null;
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}