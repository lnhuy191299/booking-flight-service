package com.tank.flight.service;

import com.tank.flight.entity.CreditCard;
import com.tank.flight.entity.Flight;
import com.tank.flight.entity.SelectedTicket;
import com.tank.flight.enums.MessageStatus;
import com.tank.flight.model.BookingDto;
import com.tank.flight.model.ServiceMessage;
import com.tank.flight.repository.BookingRepository;
import com.tank.flight.repository.CreditCardRepository;
import com.tank.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
  @Autowired private FlightRepository flightRepository;
  @Autowired private BookingRepository bookingRepository;
  @Autowired private SelectedTicketService selectedTicketService;
  @Autowired private CreditCardRepository creditCardRepository;
  @Autowired private CreditCardService creditCardService;
  @Autowired private FlightService flightService;

  public ServiceMessage paymentBooking(BookingDto bookingDetails) {
    if (!creditCardService.checkValidCard(bookingDetails.getCardNumber())) return new ServiceMessage(MessageStatus.FAIL, "Credit Card is invalid") ;
    if (!creditCardService.checkExistedCard(bookingDetails.getCardNumber())) return new ServiceMessage(MessageStatus.FAIL, "This Credit Card isn't existed");

    Optional<Flight> bookingFlight = flightRepository.findById(bookingDetails.getSelectedTickets().get(0).getFlightId());
    double totalPrice = flightService.calculateTotalPrice(bookingDetails.getSelectedTickets(), bookingFlight.get().getRootPrice());
    long bookingId;
    try {
      bookingId = bookingRepository.save(bookingDetails.getBooking()).getId();
    } catch (Exception e) {
      return new ServiceMessage(MessageStatus.FAIL, "Can't save this booking");
    }
    List<SelectedTicket> customSelectedTicket = new ArrayList<>();
    for (SelectedTicket selectedTicket : bookingDetails.getSelectedTickets()) {
      selectedTicket.setBookingId(bookingId);
      customSelectedTicket.add(selectedTicket);
    }
    if (!selectedTicketService.saveAll(customSelectedTicket)) return new ServiceMessage(MessageStatus.FAIL, "Can't save these selected tickets");
    return new ServiceMessage(MessageStatus.SUCCESS, "Payment successful");
  }
}
