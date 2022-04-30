package com.tank.flight.repository;

import com.tank.flight.entity.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}
