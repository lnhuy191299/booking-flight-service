package com.tank.flight.repository;

import com.tank.flight.entity.Airport;
import com.tank.flight.entity.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {
  Airport findById(long id);
}
