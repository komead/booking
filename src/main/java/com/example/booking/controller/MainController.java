package com.example.booking.controller;

import com.example.booking.entity.BookingHistory;
import com.example.booking.entity.User;
import com.example.booking.service.BookingHistoryService;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private BookingHistoryService bookingHistoryService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/login";
    }

    @GetMapping("/account")
    public String account(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        List<BookingHistory> history = bookingHistoryService.getBookingHistoryByUser(userDetails.getUsername());

        model.addAttribute("user", userService.getUserByUsername(userDetails.getUsername()));
        model.addAttribute("history", history);

        return "account";
    }
}
