package com.tank.flight.service;

import com.tank.flight.entity.SelectedTicket;
import com.tank.flight.model.BookingDto;
import com.tank.flight.repository.BookingRepository;
import com.tank.flight.repository.SelectedTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {
  @Autowired private BookingRepository bookingRepository;
  @Autowired private SelectedTicketService selectedTicketService;

  public boolean paymentBooking(BookingDto bookingDetails) {

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
