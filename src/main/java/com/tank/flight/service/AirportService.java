package com.tank.flight.service;

import com.tank.flight.entity.Airport;
import com.tank.flight.entity.Flight;
import com.tank.flight.model.CityDto;
import com.tank.flight.repository.AirportRepository;
import com.tank.flight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {
  @Autowired
  private AirportRepository airportRepository;
  @Autowired private FlightRepository flightRepository;

  public List<CityDto> getCityList() {
    List<CityDto> cityList = new ArrayList<>();
    for (Airport airport : airportRepository.findAll()) {
      cityList.add(new CityDto(airport.getId(), airport.getCityName(), airport.getShortCode()));
    }
    return cityList;
  }

  public List<CityDto> getDestinationCityByOriginCity(long originAirportId) {
    List<CityDto> cityList = new ArrayList<>();
    List<Flight> flightList = flightRepository.findByOriginAirportId(originAirportId);
    for (Flight fl : flightList) {
      Airport airport = airportRepository.findById(fl.getDestinationAirportId());
      CityDto destinationCity = new CityDto(airport.getId(), airport.getCityName(), airport.getShortCode());
      if (!cityList.contains(destinationCity)) {
        cityList.add(destinationCity);
      }
    }
    return cityList;
  }
}
