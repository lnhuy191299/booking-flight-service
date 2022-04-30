package com.tank.flight.repository;

import com.tank.flight.entity.Flight;
import com.tank.flight.entity.SelectedTicket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectedTicketRepository extends CrudRepository<SelectedTicket, Long> {
  List<SelectedTicket> findByFlightId(long flightId);
}
