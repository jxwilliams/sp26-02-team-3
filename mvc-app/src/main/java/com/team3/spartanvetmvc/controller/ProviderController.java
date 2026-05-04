package com.team3.spartanvetmvc.controller;

import com.team3.spartanvetmvc.entity.Vet;
import com.team3.spartanvetmvc.service.BookingService;
import com.team3.spartanvetmvc.service.ReviewService;
import com.team3.spartanvetmvc.service.VetService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/provider")
public class ProviderController {

    private final VetService vetService;
    private final BookingService bookingService;
    private final ReviewService reviewService;

    public ProviderController(VetService vetService, BookingService bookingService, ReviewService reviewService) {
        this.vetService = vetService;
        this.bookingService = bookingService;
        this.reviewService = reviewService;
    }

    // I show the provider login page first unless the provider is already logged in.
    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        if (session.getAttribute("providerId") != null) {
            return "redirect:/provider/dashboard";
        }

        return "provider-login";
    }

    // I check the provider login and save their id in the session for the demo.
    @PostMapping("/login")
    public String loginProvider(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Vet provider = vetService.validateProvider(username, password);

        if (provider == null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
            return "provider-login";
        }

        // I use the session so the provider can stay logged in while moving pages.
        session.setAttribute("providerId", provider.getId());
        return "redirect:/provider/dashboard";
    }

    // I load the dashboard with appointment requests and customer reviews.
    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        Long providerId = (Long) session.getAttribute("providerId");

        if (providerId == null) {
            return "redirect:/provider/login";
        }

        Vet provider = vetService.getVetById(providerId);
        if (provider == null) {
            session.invalidate();
            return "redirect:/provider/login";
        }

        model.addAttribute("provider", provider);
        model.addAttribute("bookings", bookingService.getBookingsForProvider(provider));
        model.addAttribute("reviews", reviewService.getAllReviews());
        return "provider-dashboard";
    }

    // I update one appointment when the provider clicks Accept or Deny.
    @PostMapping("/bookings/{id}/status")
    public String updateBookingStatus(@PathVariable Long id,
                                      @RequestParam String status,
                                      HttpSession session,
                                      RedirectAttributes redirectAttributes) {

        Long providerId = (Long) session.getAttribute("providerId");

        if (providerId == null) {
            return "redirect:/provider/login";
        }

        Vet provider = vetService.getVetById(providerId);
        if (provider == null) {
            session.invalidate();
            return "redirect:/provider/login";
        }

        // I only allow the two button choices from the dashboard.
        if ("Accepted".equals(status) || "Denied".equals(status)) {
            boolean updated = bookingService.updateBookingStatusForProvider(id, status, provider);

            if (updated) {
                redirectAttributes.addFlashAttribute("successMessage", "Booking status updated.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Booking was not found for this provider.");
            }
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid booking status.");
        }

        return "redirect:/provider/dashboard";
    }

    // I clear the session when the provider logs out.
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/provider/login";
    }
}
