package com.ticketsystem.service;

import com.ticketsystem.dao.FlightMapper;
import com.ticketsystem.model.Flight;
import com.ticketsystem.model.FlightExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightMapper flightMapper;

    public List<Flight> getAllFlight(){
        return flightMapper.selectByExample(new FlightExample());
    }

    public Flight getFlightById(int flightId){
        return flightMapper.selectByPrimaryKey(flightId);
    }

    public void altFlight(Flight flight){
        flightMapper.updateByPrimaryKeySelective(flight);
    }

    public void delFlight(int flightId){
        flightMapper.deleteByPrimaryKey(flightId);
    }

    public List<Flight> queryByCity(String startCity, String endCity){
        FlightExample flightExample = new FlightExample();
        FlightExample.Criteria criteria = flightExample.createCriteria();
        if(startCity != "")
            criteria.andStartCityEqualTo(startCity);
        if(endCity != "")
            criteria.andEndCityEqualTo(endCity);
        return flightMapper.selectByExample(flightExample);
    }

    public void addFlight(Flight flight){
        flightMapper.insert(flight);
    }
}
