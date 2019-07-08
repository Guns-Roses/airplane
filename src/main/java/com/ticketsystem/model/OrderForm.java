package com.ticketsystem.model;

import lombok.Data;

import java.util.Date;

@Data
public class OrderForm {
    private Integer orderFormId;

    private Integer userId;

    private Integer ticketNumber;

    private Float totalPrice;

    private Date orderTime;


}