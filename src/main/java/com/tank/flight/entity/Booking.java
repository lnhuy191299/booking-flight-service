package com.tank.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Booking {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column private LocalDateTime bookingTime;
  @Column private String contactPhoneNumber;
  @Column private String contactEmail;
  @Column private long userId;
}
