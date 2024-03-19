package com.example.booking.repository;

import com.example.booking.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    boolean existsFlightByPointOfDepartureAndArrivalPoint(String pointOfDeparture, String arrivalPoint);
    List<Flight> findAllByPointOfDeparture(String pointOfDeparture);
    List<Flight> findAllByArrivalPoint(String arrivalPoint);

}
