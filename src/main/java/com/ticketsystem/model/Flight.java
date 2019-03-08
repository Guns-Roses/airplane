package com.ticketsystem.model;

import java.util.Date;

public class Flight {
    private Integer flightId;

    private Date startTime;

    private String startCity;

    private String endCity;

    private Integer peopleNumber;

    private Integer leftTicket;

    private Float ticketPrice;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity == null ? null : startCity.trim();
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity == null ? null : endCity.trim();
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getLeftTicket() {
        return leftTicket;
    }

    public void setLeftTicket(Integer leftTicket) {
        this.leftTicket = leftTicket;
    }

    public Float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}