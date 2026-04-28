package com.team3.spartanvetmvc.controller;

import com.team3.spartanvetmvc.entity.Booking;
import com.team3.spartanvetmvc.entity.Vet;
import com.team3.spartanvetmvc.service.BookingService;
import com.team3.spartanvetmvc.service.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final VetService vetService;
    private final BookingService bookingService;

    public CustomerController(VetService vetService, BookingService bookingService) {
        this.vetService = vetService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public String customerHome() {
        return "customer-home";
    }

    @GetMapping("/providers")
    public String showProviders(Model model) {
        model.addAttribute("providers", vetService.getAllVets());
        return "customer-providers";
    }

    @GetMapping("/book")
    public String showBookingForm(@RequestParam(required = false) Long providerId, Model model) {
        Vet selectedProvider = null;

        if (providerId != null) {
            selectedProvider = vetService.getVetById(providerId);
        }

        model.addAttribute("providers", vetService.getAllVets());
        model.addAttribute("selectedProvider", selectedProvider);
        return "customer-book";
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestParam String customerName,
                                  @RequestParam String petName,
                                  @RequestParam String providerName,
                                  @RequestParam String serviceType,
                                  @RequestParam String appointmentDate,
                                  RedirectAttributes redirectAttributes) {

        Booking booking = new Booking();
        booking.setCustomerName(customerName);
        booking.setPetName(petName);
        booking.setProviderName(providerName);
        booking.setServiceType(serviceType);
        booking.setAppointmentDate(appointmentDate);
        booking.setStatus("Pending");
        bookingService.saveBooking(booking);

        redirectAttributes.addAttribute("customerName", customerName);
        redirectAttributes.addFlashAttribute("successMessage", "Appointment request sent.");
        return "redirect:/customer/status";
    }

    @GetMapping("/status")
    public String showStatus(@RequestParam(required = false) String customerName, Model model) {
        model.addAttribute("customerName", customerName);

        if (customerName != null && !customerName.isBlank()) {
            model.addAttribute("bookings", bookingService.getBookingsForCustomer(customerName));
        }

        return "customer-status";
    }
}
