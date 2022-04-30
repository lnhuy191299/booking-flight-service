package com.tank.flight.model;

import com.tank.flight.enums.MessageStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceMessage {
  private MessageStatus status;
  private String message;
}
