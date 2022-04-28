package com.tank.flight.controller;

import com.tank.flight.entity.Flight;
import com.tank.flight.model.CityDto;
import com.tank.flight.service.AirportService;
import com.tank.flight.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
  @Autowired private AirportService airportService;
  @Autowired private FlightService flightService;

  @GetMapping("/hello")
  public ResponseEntity<String> greeting() {
    return ResponseEntity.ok("Customer service work!");
  }

  @GetMapping("/cities")
  public ResponseEntity<List<CityDto>> getCityList() {
    return ResponseEntity.ok(airportService.getCityList());
  }

  @GetMapping("/cities/destination")
  public ResponseEntity<List<CityDto>> getDestinationCityList(@RequestParam(name = "originId") long originId) {
    return ResponseEntity.ok(airportService.getDestinationCityByOriginCity(originId));
  }

  @GetMapping("/flights")
  public ResponseEntity<List<Flight>> searchFlightsForCustomer(@RequestParam(name = "departureTime") String departureTime,
                                                               @RequestParam(name = "originId") long originId,
                                                               @RequestParam(name = "destinationId") long destinationId) {
    System.out.println("hello");
    return ResponseEntity.ok(flightService.searchFlightsFromCustomer(departureTime, originId, destinationId));
  }

}
