package com.tank.flight.service;

import com.tank.flight.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreditCardService {
  @Autowired public CreditCardRepository creditCardRepository;
  public boolean checkValidCard(String cardNumber) {
    int rightMostIndex = cardNumber.length() - 1;
    int finalSum = 0;
    for (int i = rightMostIndex; i > -1; i-=2) {
      finalSum += Character.getNumericValue(cardNumber.charAt(i));
    }
    for (int i = rightMostIndex - 1; i > -1; i-=2) {
      int digit = Character.getNumericValue(cardNumber.charAt(i));
      int doublingDigitResult = digit*2;
      if (doublingDigitResult > 9) {
        doublingDigitResult = doublingDigitResult % 10 + doublingDigitResult / 10;
      }
      finalSum += doublingDigitResult;
    }
    return (finalSum % 10 == 0);
  }

  public boolean checkExistedCard(String cardNumber) {
    return creditCardRepository.existsByCardNumber(cardNumber);
  }
}
