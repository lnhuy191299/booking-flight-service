package com.tank.flight.model;

import com.tank.flight.entity.Booking;
import com.tank.flight.entity.CreditCard;
import com.tank.flight.entity.SelectedTicket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {
  private String cardNumber;
  private String cardCode;
  private Booking booking;
  private List<SelectedTicket> selectedTickets;
}
