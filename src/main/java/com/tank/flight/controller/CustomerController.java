package com.tank.flight.controller;

import com.tank.flight.entity.Flight;
import com.tank.flight.entity.SelectedTicket;
import com.tank.flight.enums.MessageStatus;
import com.tank.flight.model.BookingDto;
import com.tank.flight.model.CityDto;
import com.tank.flight.model.ServiceMessage;
import com.tank.flight.repository.SelectedTicketRepository;
import com.tank.flight.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
@CrossOrigin(origins = {"http://localhost:3000"})
public class CustomerController {
  @Autowired private AirportService airportService;
  @Autowired private FlightService flightService;
  @Autowired private SelectedTicketService selectedTicketService;
  @Autowired private CreditCardService creditCardService;
  @Autowired private BookingService bookingService;

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
    return ResponseEntity.ok(flightService.searchFlightsFromCustomer(departureTime, originId, destinationId));
  }

  @GetMapping("/flights/{flightId}")
  public ResponseEntity<Flight> getFlightDetails(@PathVariable long flightId) {
    return ResponseEntity.ok(flightService.getFlightByFlightId((flightId)));
  }

  @GetMapping("/flights/selected-tickets")
  public ResponseEntity<List<SelectedTicket>> getSelectedTickets(@RequestParam(name = "flightId") long flightId) {
    return ResponseEntity.ok(selectedTicketService.getSelectedTicketsByFlightId(flightId));
  }

  @PostMapping("/payment")
  public ResponseEntity<String> paymentAndSaveBooking(@RequestBody BookingDto bookingDto) {
    ServiceMessage serviceMessage = bookingService.paymentBooking(bookingDto);
    if (serviceMessage.getStatus() == MessageStatus.FAIL) return ResponseEntity.badRequest().body(serviceMessage.getMessage());
    else return ResponseEntity.ok(serviceMessage.getMessage());
  }
}
