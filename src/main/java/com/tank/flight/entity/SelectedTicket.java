package com.tank.flight.entity;

import com.tank.flight.enums.TicketType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "selected_ticket")
public class SelectedTicket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column private String seatCode;
  @Column private Long flightId;
  @Column private Long bookingId;
  @Column private String prefixOfName;
  @Column private String middleAndFirstName;
  @Column private String familyName;
  @Column private LocalDate dateOfBirth;
  @Column private String gender;
  @Column private TicketType ticketType;
}