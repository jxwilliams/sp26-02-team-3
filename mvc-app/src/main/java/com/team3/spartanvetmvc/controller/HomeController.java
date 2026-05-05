package com.team3.spartanvetmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Shows the main landing page.
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin")
    public String adminPlaceholder() {
        return "admin-placeholder";
    }
}
