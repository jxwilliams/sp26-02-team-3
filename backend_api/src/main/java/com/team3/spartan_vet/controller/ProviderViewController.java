package com.team3.spartan_vet.controller;

import com.team3.spartan_vet.entity.Booking;
import com.team3.spartan_vet.service.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProviderViewController {

    private final BookingService bookingService;

    public ProviderViewController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/provider/login")
    public String handleProviderLogin(@RequestParam String username,
                                      @RequestParam String password,
                                      Model model) {

        //demo login
        if ("provider".equals(username) && "pass".equals(password)) {
            return "redirect:/provider/dashboard";
        }

        model.addAttribute("error", "Invalid provider login.");
        return "login";
    }

    @GetMapping("/provider/dashboard")
    public String showProviderDashboard(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "provider-dashboard";
    }

    @PostMapping("/provider/bookings/{id}/status")
    public String updateBookingStatus(@PathVariable Long id,
                                      @RequestParam String status) {
        bookingService.updateBookingStatus(id, status);
        return "redirect:/provider/dashboard";
    }
}