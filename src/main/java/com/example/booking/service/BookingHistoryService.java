package com.example.booking.service;

import com.example.booking.entity.BookingHistory;

import java.util.List;

public interface BookingHistoryService {
    void addBookingHistory(int userId, int flightId);
    List<BookingHistory> getBookingHistoryByUser(String username);
}
