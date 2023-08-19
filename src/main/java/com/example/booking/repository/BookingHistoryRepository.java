package com.example.booking.repository;

import com.example.booking.entity.BookingHistory;
import org.springframework.data.repository.CrudRepository;

public interface BookingHistoryRepository extends CrudRepository<BookingHistory, Integer> {
}
