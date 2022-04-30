package com.tank.flight.service;

import com.tank.flight.entity.CreditCard;
import com.tank.flight.entity.Flight;
import com.tank.flight.entity.SelectedTicket;
import com.tank.flight.model.BookingDto;
import com.tank.flight.repository.BookingRepository;
import com.tank.flight.repository.CreditCardRepository;
import com.tank.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

  public boolean paymentBooking(BookingDto bookingDetails) {
    Optional<Flight> bookingFlight = flightRepository.findById(bookingDetails.getSelectedTickets().get(0).getFlightId());
    double bookingPrice = 0D;
//    CreditCard creditCard = creditCardRepository.findByCardNumberAndCardCode(bookingDetails.getCardNumber(), bookingDetails.getCardCode());
//    if (creditCard != null) {
//      for (SelectedTicket selectedTicket : bookingDetails.getSelectedTickets()) {
//        bookingPrice += selectedTicket.getTicketType() * bookingFlight.get().getRootPrice();
//      }
//    } else return false;
    long bookingId;
    try {
      bookingId = bookingRepository.save(bookingDetails.getBooking()).getId();
    } catch (Exception e) {
      return false;
    }
    List<SelectedTicket> customSelectedTicket = new ArrayList<>();
    for (SelectedTicket selectedTicket : bookingDetails.getSelectedTickets()) {
      selectedTicket.setBookingId(bookingId);
      customSelectedTicket.add(selectedTicket);
    }
    if (!selectedTicketService.saveAll(customSelectedTicket)) return false;
    return true;
  }
}
