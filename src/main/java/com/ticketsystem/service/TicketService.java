package com.ticketsystem.service;

import com.ticketsystem.dao.FlightMapper;
import com.ticketsystem.dao.OrderFormMapper;
import com.ticketsystem.dao.TicketMapper;
import com.ticketsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private OrderFormMapper orderFormMapper;

    @Autowired
    private FlightMapper flightMapper;

    public List<Ticket> getAllTicket(){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria();
        return ticketMapper.selectByExample(ticketExample);
    }

    public List<Ticket> getTicketByFormId(int id){
        TicketExample ticketExample = new TicketExample();
        ticketExample.createCriteria().andOrderFormIdEqualTo(id);
        return ticketMapper.selectByExample(ticketExample);
    }

    public Ticket getTicketById(int ticketId){
        return ticketMapper.selectByPrimaryKey(ticketId);
    }

    public void altTicket(int ticketId, int flightId, String passengerName, float price){
        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setFlightId(flightId);
        ticket.setPassengerName(passengerName);
        ticket.setTicketId(ticketId);
        ticketMapper.updateByPrimaryKeySelective(ticket);
    }

    public void deleteById(int ticketId){
        Ticket ticket = ticketMapper.selectByPrimaryKey(ticketId);
        ticketMapper.deleteByPrimaryKey(ticketId);
        OrderForm orderForm = orderFormMapper.selectByPrimaryKey(ticket.getOrderFormId());
        orderForm.setTicketNumber(orderForm.getTicketNumber() - 1);
        if(orderForm.getTicketNumber() == 0){
            orderFormMapper.deleteByPrimaryKey(orderForm.getOrderFormId());
        }
        else {
            orderForm.setTotalPrice(orderForm.getTotalPrice() - ticket.getPrice() * ticket.getDiscount());
            orderFormMapper.updateByPrimaryKeySelective(orderForm);
        }
        Flight flight = flightMapper.selectByPrimaryKey(ticket.getFlightId());
        flight.setLeftTicket(flight.getLeftTicket() + 1);
        flightMapper.updateByPrimaryKey(flight);
        ticketMapper.deleteByPrimaryKey(ticketId);
    }

}
