package com.ticketsystem.model;

import java.util.Date;

public class OrderForm {
    private Integer orderFormId;

    private Integer userId;

    private Integer ticketNumber;

    private Float totalPrice;

    private Date orderTime;

    public Integer getOrderFormId() {
        return orderFormId;
    }

    public void setOrderFormId(Integer orderFormId) {
        this.orderFormId = orderFormId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}