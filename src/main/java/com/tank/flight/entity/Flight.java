package com.tank.flight.entity;

import com.tank.flight.enums.FlightStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Flight {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column private LocalDateTime departureTime;
  @Column private LocalDateTime arrivalTime;
  @Column private double rootPrice;
  @Column private FlightStatus flightStatus;
  @Column private long originAirportId;
  @Column private long destinationAirportId;
  @Column private String flightNumber;
}
