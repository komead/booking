package com.example.booking.service.impl;

import com.example.booking.entity.BookingHistory;
import com.example.booking.entity.User;
import com.example.booking.repository.BookingHistoryRepository;
import com.example.booking.repository.FlightRepository;
import com.example.booking.repository.UserRepository;
import com.example.booking.service.BookingHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingHistoryServiceImpl implements BookingHistoryService {
    private BookingHistoryRepository bookingHistoryRepository;
    private UserRepository userRepository;
    private FlightRepository flightRepository;

    @Override
    public void addBookingHistory(int userId, int flightId) {
        BookingHistory bookingHistory = new BookingHistory();
        bookingHistory.setUser(userRepository.findById(userId));
        bookingHistory.setFlight(flightRepository.findById(flightId).orElse(null));
        bookingHistory.setBookingDate(new Date());

        bookingHistoryRepository.save(bookingHistory);
    }

    @Override
    public List<BookingHistory> getBookingHistoryByUser(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null)
            throw new RuntimeException("No such user with username: " + username);

        return bookingHistoryRepository.findAllByUser(user);
    }
}
