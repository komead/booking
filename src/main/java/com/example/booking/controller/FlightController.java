package com.example.booking.controller;

import com.example.booking.entity.Flight;
import com.example.booking.entity.User;
import com.example.booking.service.BookingHistoryService;
import com.example.booking.service.FlightService;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flight")
@AllArgsConstructor
public class FlightController {
    private FlightService flightService;
    private UserService userService;
    private BookingHistoryService bookingHistoryService;

    @PostMapping("/new")
    public String create(@ModelAttribute Flight flight) {
        flightService.addFlight(flight);
        return "redirect:/flight";
    }

    @GetMapping("/edit/{id}")
    public String editFlight(@PathVariable(value = "id") int id, Model model) {
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        return "editFlight";
    }

    @PostMapping("/edit/{id}")
    public String updateFlight(@PathVariable(value = "id") int id, @ModelAttribute Flight flight) {
        flightService.editFlight(id, flight);
        return "redirect:/flight";
    }

    @PostMapping("/delete/{id}")
    public String deleteFlight(@PathVariable(value = "id") int id) {
        flightService.deleteFlightById(id);
        return "redirect:/flight";
    }

    @GetMapping("/info/{id}")
    public String moreInfo(@PathVariable(value = "id") int id, Model model) {
        Flight flight = flightService.getFlightById(id);
        model.addAttribute("flight", flight);
        return "flightInfo";
    }

    @PostMapping("/book/{flightId}")
    public String book(@PathVariable(value = "flightId") int flightId, @AuthenticationPrincipal UserDetails userDetails) {
        int userId = userService.getUserByUsername(userDetails.getUsername()).getId();
        bookingHistoryService.addBookingHistory(userId, flightId);
        return "redirect:/flight/info/" + flightId;
    }

    @GetMapping("")
    public String getAll(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Iterable<Flight> flights = flightService.getAll();

        boolean isAdmin = userDetails.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals("ADMIN"));

        model.addAttribute("isAdmin", isAdmin);
        model.addAttribute("flights", flights);
        return "flight";
    }
}