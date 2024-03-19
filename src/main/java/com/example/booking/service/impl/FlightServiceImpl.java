package com.example.booking.service.impl;

import com.example.booking.entity.Flight;
import com.example.booking.repository.FlightRepository;
import com.example.booking.service.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {
    private FlightRepository flightRepository;

    @Override
    public void addFlight(Flight flight) {
        if (flightRepository.existsFlightByPointOfDepartureAndArrivalPoint(flight.getPointOfDeparture(), flight.getArrivalPoint()))
            throw new RuntimeException("Such flight is already exist");

        flightRepository.save(flight);
    }

    @Override
    public Flight getFlightById(int id) {
        Flight flight = flightRepository.findById(id).orElse(null);

        if (flight == null)
            throw new RuntimeException("No such flight with id: " + id);

        return flight;
    }

    @Override
    public void deleteFlightById(int id) {
        Flight flight = flightRepository.findById(id).orElse(null);

         if (flight == null)
             throw new RuntimeException("No such flight with id: " + id);

         flightRepository.delete(flight);
    }

    @Override
    public void editFlight(int id, Flight flight) {
        Flight oldFlight = flightRepository.findById(id).orElse(null);

        if (oldFlight == null)
            throw new RuntimeException("No such flight with id: " + id);

        oldFlight.setArrivalPoint(flight.getArrivalPoint());
        oldFlight.setPointOfDeparture(flight.getPointOfDeparture());
        oldFlight.setTotalSeats(flight.getTotalSeats());

        flightRepository.save(oldFlight);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public List<Flight> getAllByPointOfDeparture(String pointOfDeparture) {
        return flightRepository.findAllByPointOfDeparture(pointOfDeparture);
    }

    @Override
    public List<Flight> getAllByArrivalPoint(String arrivalPoint) {
        return flightRepository.findAllByArrivalPoint(arrivalPoint);
    }
}
