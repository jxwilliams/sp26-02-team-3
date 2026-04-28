package com.team3.spartanvetmvc.service;

import com.team3.spartanvetmvc.entity.Booking;
import com.team3.spartanvetmvc.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // I get every booking so the provider can see all appointment requests.
    public List<Booking> getAllBookings() {
        return bookingRepository.findAllByOrderByAppointmentDateAscIdAsc();
    }

    // Shows one customer's requests on the status page.
    public List<Booking> getBookingsForCustomer(String customerName) {
        return bookingRepository.findByCustomerNameIgnoreCaseOrderByAppointmentDateDescIdDesc(customerName);
    }

    // I save the new status when the provider accepts or denies a request.
    public boolean updateBookingStatus(Long bookingId, String status) {
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);

        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setStatus(status);
            bookingRepository.save(booking);
            return true;
        }

        return false;
    }

    // I make new bookings start as Pending if no status was picked yet.
    public void saveBooking(Booking booking) {
        if (booking.getStatus() == null || booking.getStatus().isBlank()) {
            booking.setStatus("Pending");
        }

        bookingRepository.save(booking);
    }
}
