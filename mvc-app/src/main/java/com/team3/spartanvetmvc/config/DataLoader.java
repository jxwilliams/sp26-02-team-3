package com.team3.spartanvetmvc.config;

import com.team3.spartanvetmvc.entity.Booking;
import com.team3.spartanvetmvc.entity.Review;
import com.team3.spartanvetmvc.entity.Vet;
import com.team3.spartanvetmvc.service.BookingService;
import com.team3.spartanvetmvc.service.ReviewService;
import com.team3.spartanvetmvc.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadDemoData(VetService vetService, BookingService bookingService, ReviewService reviewService) {
        return args -> {
            // This just gives us one provider account for the class demo.
            if (!vetService.usernameExists("provider1")) {
                Vet demoVet = new Vet();
                demoVet.setName("Dr. Taylor");
                demoVet.setSpecialty("General Care");
                demoVet.setUsername("provider1");
                demoVet.setPassword("vet123");
                vetService.saveVet(demoVet);
            }

            if (!vetService.usernameExists("provider2")) {
                Vet demoVet = new Vet();
                demoVet.setName("Dr. Morgan");
                demoVet.setSpecialty("Vaccination");
                demoVet.setUsername("provider2");
                demoVet.setPassword("vet123");
                vetService.saveVet(demoVet);
            }

            if (!vetService.usernameExists("provider3")) {
                Vet demoVet = new Vet();
                demoVet.setName("Dr. Lee");
                demoVet.setSpecialty("Dental Cleaning");
                demoVet.setUsername("provider3");
                demoVet.setPassword("vet123");
                vetService.saveVet(demoVet);
            }

            if (bookingService.getAllBookings().isEmpty()) {
                Booking booking1 = new Booking();
                booking1.setPetName("Buddy");
                booking1.setServiceType("Checkup");
                booking1.setAppointmentDate("2026-04-25");
                bookingService.saveBooking(booking1);

                Booking booking2 = new Booking();
                booking2.setPetName("Luna");
                booking2.setServiceType("Vaccination");
                booking2.setAppointmentDate("2026-04-26");
                bookingService.saveBooking(booking2);

                Booking booking3 = new Booking();
                booking3.setPetName("Max");
                booking3.setServiceType("Dental Cleaning");
                booking3.setAppointmentDate("2026-04-27");
                bookingService.saveBooking(booking3);
            }

            if (reviewService.getAllReviews().isEmpty()) {
                Review review1 = new Review();
                review1.setCustomerName("Jordan Smith");
                review1.setRating(5);
                review1.setComment("The provider was kind and explained everything clearly.");
                review1.setReviewDate("2026-04-20");
                reviewService.saveReview(review1);

                Review review2 = new Review();
                review2.setCustomerName("Mia Johnson");
                review2.setRating(4);
                review2.setComment("Good visit and quick follow-up after the appointment.");
                review2.setReviewDate("2026-04-18");
                reviewService.saveReview(review2);
            }
        };
    }
}
