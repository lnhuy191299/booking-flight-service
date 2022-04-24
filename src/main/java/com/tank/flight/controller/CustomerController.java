package com.tank.flight.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

  @GetMapping("/hello")
  public ResponseEntity<String> greeting() {
    return ResponseEntity.ok("Customer service work!");
  }

}
