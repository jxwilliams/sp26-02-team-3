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
            Vet provider1 = vetService.getVetByUsername("provider1");
            if (!vetService.usernameExists("provider1")) {
                provider1 = new Vet();
                provider1.setName("Dr. Taylor");
                provider1.setSpecialty("General Care");
                provider1.setUsername("provider1");
                provider1.setPassword("vet123");
                vetService.saveVet(provider1);
            }

            Vet provider2 = vetService.getVetByUsername("provider2");
            if (!vetService.usernameExists("provider2")) {
                provider2 = new Vet();
                provider2.setName("Dr. Morgan");
                provider2.setSpecialty("Vaccination");
                provider2.setUsername("provider2");
                provider2.setPassword("vet123");
                vetService.saveVet(provider2);
            }

            Vet provider3 = vetService.getVetByUsername("provider3");
            if (!vetService.usernameExists("provider3")) {
                provider3 = new Vet();
                provider3.setName("Dr. Lee");
                provider3.setSpecialty("Dental Cleaning");
                provider3.setUsername("provider3");
                provider3.setPassword("vet123");
                vetService.saveVet(provider3);
            }

            if (bookingService.getAllBookings().isEmpty()) {
                Booking booking1 = new Booking();
                booking1.setCustomerName("Jordan Smith");
                booking1.setPetName("Buddy");
                booking1.setProviderId(provider1.getId());
                booking1.setProviderName(provider1.getName());
                booking1.setServiceType("Checkup");
                booking1.setAppointmentDate("2026-04-25");
                bookingService.saveBooking(booking1);

                Booking booking2 = new Booking();
                booking2.setCustomerName("Mia Johnson");
                booking2.setPetName("Luna");
                booking2.setProviderId(provider2.getId());
                booking2.setProviderName(provider2.getName());
                booking2.setServiceType("Vaccination");
                booking2.setAppointmentDate("2026-04-26");
                bookingService.saveBooking(booking2);

                Booking booking3 = new Booking();
                booking3.setCustomerName("Avery Brown");
                booking3.setPetName("Max");
                booking3.setProviderId(provider3.getId());
                booking3.setProviderName(provider3.getName());
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
