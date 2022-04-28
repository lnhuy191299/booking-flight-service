package com.tank.flight.service;

import com.tank.flight.entity.Flight;
import com.tank.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FlightService {
  @Autowired private FlightRepository flightRepository;

  public List<Flight> searchFlightsFromCustomer(String departureTime, long originId, long departureId) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    LocalDateTime dateTime = LocalDateTime.parse(departureTime, formatter);
    return flightRepository.searchFlightForCustomer(dateTime, originId, departureId);
  }
}
