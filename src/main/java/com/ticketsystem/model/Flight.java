package com.ticketsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class Flight {
    private Integer flightId;

    private Date startTime;

    private String startCity;

    private String endCity;

    private Integer peopleNumber;

    private Integer leftTicket;

    private Float ticketPrice;


}