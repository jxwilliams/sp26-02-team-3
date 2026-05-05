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

    // I use this to show all appointment requests on the provider side
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // I use this when I need to find one booking by its id
    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.orElse(null);
    }

    // I create a new appointment request and make it Pending by default
    public Booking createBooking(Booking booking) {
        if (booking.getStatus() == null || booking.getStatus().isBlank()) {
            booking.setStatus("Pending");
        }
        return bookingRepository.save(booking);
    }

    // I update the main booking fields if the booking exists
    public Booking updateBooking(Long id, Booking updatedBooking) {
        Booking existing = getBookingById(id);

        if (existing != null) {
            // I copy the new values onto the existing database row
            existing.setPetName(updatedBooking.getPetName());
            existing.setServiceType(updatedBooking.getServiceType());
            existing.setAppointmentDate(updatedBooking.getAppointmentDate());
            existing.setStatus(updatedBooking.getStatus());
            return bookingRepository.save(existing);
        }

        return null;
    }

    // I use this for the provider Accept and Deny buttons
    public Booking updateBookingStatus(Long id, String status) {
        Booking existing = getBookingById(id);

        if (existing != null) {
            // this saves the providers decision back to the database
            existing.setStatus(status);
            return bookingRepository.save(existing);
        }

        return null;
    }

    // I delete a booking by id when it is no longer needed.
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
