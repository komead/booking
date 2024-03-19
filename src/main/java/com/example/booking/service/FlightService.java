package com.example.booking.service;

import com.example.booking.entity.Flight;

import java.util.List;

public interface FlightService {
    void addFlight(Flight flight);
    Flight getFlightById(int id);
    void deleteFlightById(int id);
    void editFlight(int id, Flight flight);
    List<Flight> getAll();
    List<Flight> getAllByPointOfDeparture(String pointOfDeparture);
    List<Flight> getAllByArrivalPoint(String arrivalPoint);
}
