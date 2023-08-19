package com.example.booking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String pointOfDeparture;

    @Column(nullable = false)
    private String arrivalPoint;

    @Column(nullable = false)
    private Date departureDate;

    @Column(nullable = false)
    private Date arrivalDate;

    @Column(nullable = false)
    private String price;

    private int totalSeats;

    private boolean completed;

    @OneToMany(mappedBy = "flight")
    private List<BookingHistory> bookingHistory = new ArrayList<>();
}
