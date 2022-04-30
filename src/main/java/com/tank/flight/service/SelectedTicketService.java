package com.tank.flight.service;

import com.tank.flight.entity.SelectedTicket;
import com.tank.flight.repository.SelectedTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedTicketService {
  @Autowired private SelectedTicketRepository selectedTicketRepository;

  public List<SelectedTicket> getSelectedTicketsByFlightId(long flightId) {
    return selectedTicketRepository.findByFlightId(flightId);
  }

  public boolean saveAll(List<SelectedTicket> selectedTickets) {
    try {
      selectedTicketRepository.saveAll(selectedTickets);
      return true;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }
}
