package com.team3.spartanvetmvc.controller;

import com.team3.spartanvetmvc.entity.Booking;
import com.team3.spartanvetmvc.entity.Customer;
import com.team3.spartanvetmvc.entity.Vet;
import com.team3.spartanvetmvc.service.BookingService;
import com.team3.spartanvetmvc.service.CustomerService;
import com.team3.spartanvetmvc.service.VetService;
import jakarta.servlet.http.HttpSession;
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
    private final CustomerService customerService;

    public CustomerController(VetService vetService, BookingService bookingService, CustomerService customerService) {
        this.vetService = vetService;
        this.bookingService = bookingService;
        this.customerService = customerService;
    }

    @GetMapping
    public String customerHome(HttpSession session, Model model) {
        Customer customer = getLoggedInCustomer(session);

        if (customer == null) {
            return "redirect:/customer/login";
        }

        model.addAttribute("customerName", customer.getFullName());
        return "customer-home";
    }

    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        if (getLoggedInCustomer(session) != null) {
            return "redirect:/customer";
        }

        return "customer-login";
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestParam String username,
                                @RequestParam String password,
                                HttpSession session,
                                Model model) {

        Customer customer = customerService.validateCustomer(username, password);

        if (customer == null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
            return "customer-login";
        }

        session.setAttribute("customerId", customer.getId());
        session.setAttribute("customerName", customer.getFullName());
        return "redirect:/customer";
    }

    @GetMapping("/register")
    public String showRegisterPage(HttpSession session) {
        if (getLoggedInCustomer(session) != null) {
            return "redirect:/customer";
        }

        return "customer-register";
    }

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String fullName,
                                   @RequestParam String username,
                                   @RequestParam String password,
                                   HttpSession session,
                                   Model model) {

        if (fullName.isBlank() || username.isBlank() || password.isBlank()) {
            model.addAttribute("errorMessage", "Please fill out every field.");
            return "customer-register";
        }

        String cleanUsername = username.trim();

        if (customerService.usernameExists(cleanUsername)) {
            model.addAttribute("errorMessage", "That username is already taken.");
            return "customer-register";
        }

        Customer customer = new Customer();
        customer.setFullName(fullName.trim());
        customer.setUsername(cleanUsername);
        customer.setPassword(password);
        customerService.saveCustomer(customer);

        session.setAttribute("customerId", customer.getId());
        session.setAttribute("customerName", customer.getFullName());
        return "redirect:/customer";
    }

    @GetMapping("/providers")
    public String showProviders(HttpSession session, Model model) {
        Customer customer = getLoggedInCustomer(session);

        if (customer == null) {
            return "redirect:/customer/login";
        }

        model.addAttribute("customerName", customer.getFullName());
        model.addAttribute("providers", vetService.getAllVets());
        return "customer-providers";
    }

    @GetMapping("/book")
    public String showBookingForm(@RequestParam(required = false) Long providerId,
                                  HttpSession session,
                                  Model model) {
        Customer customer = getLoggedInCustomer(session);

        if (customer == null) {
            return "redirect:/customer/login";
        }

        Vet selectedProvider = null;

        if (providerId != null) {
            selectedProvider = vetService.getVetById(providerId);
        }

        model.addAttribute("providers", vetService.getAllVets());
        model.addAttribute("selectedProvider", selectedProvider);
        model.addAttribute("customerName", customer.getFullName());
        return "customer-book";
    }

    @PostMapping("/book")
    public String bookAppointment(@RequestParam String petName,
                                  @RequestParam Long providerId,
                                  @RequestParam String serviceType,
                                  @RequestParam String appointmentDate,
                                  HttpSession session,
                                  RedirectAttributes redirectAttributes) {

        Customer customer = getLoggedInCustomer(session);

        if (customer == null) {
            return "redirect:/customer/login";
        }

        Vet provider = vetService.getVetById(providerId);

        if (provider == null) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose a valid provider.");
            return "redirect:/customer/book";
        }

        Booking booking = new Booking();
        booking.setCustomerId(customer.getId());
        booking.setCustomerName(customer.getFullName());
        booking.setPetName(petName);
        booking.setProviderId(provider.getId());
        booking.setProviderName(provider.getName());
        booking.setServiceType(serviceType);
        booking.setAppointmentDate(appointmentDate);
        booking.setStatus("Pending");
        bookingService.saveBooking(booking);

        redirectAttributes.addFlashAttribute("successMessage", "Appointment request sent.");
        return "redirect:/customer/status";
    }

    @GetMapping("/status")
    public String showStatus(HttpSession session, Model model) {
        Customer customer = getLoggedInCustomer(session);

        if (customer == null) {
            return "redirect:/customer/login";
        }

        model.addAttribute("customerName", customer.getFullName());
        model.addAttribute("bookings", bookingService.getBookingsForCustomer(customer));

        return "customer-status";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("customerId");
        session.removeAttribute("customerName");
        return "redirect:/customer/login";
    }

    private Customer getLoggedInCustomer(HttpSession session) {
        Long customerId = (Long) session.getAttribute("customerId");

        if (customerId == null) {
            return null;
        }

        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            session.removeAttribute("customerId");
            session.removeAttribute("customerName");
        }

        return customer;
    }
}
