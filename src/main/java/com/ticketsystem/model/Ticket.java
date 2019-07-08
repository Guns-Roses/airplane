package com.ticketsystem.model;

import lombok.Data;

@Data
public class Ticket {
    private Integer ticketId;

    private Integer flightId;

    private Integer orderFormId;

    private Float price;

    private Float discount;

    private String passengerName;


}