package com.example.booking.repository;

import com.example.booking.entity.BookingHistory;
import com.example.booking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Integer> {
    List<BookingHistory> findAllByUser(User user);
}
