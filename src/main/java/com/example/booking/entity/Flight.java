package com.example.booking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
@NoArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String pointOfDeparture;

    @Column(nullable = false)
    private String arrivalPoint;

    private int totalSeats;

    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private List<BookingHistory> bookingHistory = new ArrayList<>();
}
