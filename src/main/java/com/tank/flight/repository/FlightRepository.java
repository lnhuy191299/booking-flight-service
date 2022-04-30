package com.tank.flight.repository;

import com.tank.flight.entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {
  List<Flight> findByOriginAirportId(long id);
  Flight findById(long id);
  @Query(value = "select *\n" +
          "from flight f \n" +
          "where CAST(f.departure_time  AS DATE) = :departureTime \n" +
          "and f.origin_airport_id = :originId\n" +
          "and f.destination_airport_id = :destinationId\n" +
          "and f.flight_status = 0", nativeQuery = true)
  List<Flight> searchFlightForCustomer(@Param("departureTime") LocalDateTime departureTime,
                                       @Param("originId") long originId,
                                       @Param("destinationId") long destinationId);
}
