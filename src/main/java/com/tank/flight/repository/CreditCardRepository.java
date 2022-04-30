package com.tank.flight.repository;

import com.tank.flight.entity.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
  CreditCard findByCardNumberAndCardCode(String cardNumber, String cardCode);
}
