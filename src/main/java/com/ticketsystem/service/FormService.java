package com.ticketsystem.service;

import com.ticketsystem.dao.FlightMapper;
import com.ticketsystem.dao.OrderFormMapper;
import com.ticketsystem.dao.TicketMapper;
import com.ticketsystem.dao.UserMapper;
import com.ticketsystem.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FormService {

    @Autowired
    private OrderFormMapper orderFormMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private FlightMapper flightMapper;

    public List<OrderForm> getAll(String username){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);
        OrderFormExample orderFormExample = new OrderFormExample();
        OrderFormExample.Criteria criteria = orderFormExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        return orderFormMapper.selectByExample(orderFormExample);
    }

    public float getAllPrice(String username,int ticketNum,int flightId){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(username);
        int isVip = userMapper.selectByExample(userExample).get(0).getIsVip();
        float totalPrice = ticketNum * flightMapper.selectByPrimaryKey(flightId).getTicketPrice();
        if(isVip == 1)
            totalPrice = (float)0.8 * totalPrice;
        return totalPrice;
    }

    public float order(String username,int ticketNum,List<Ticket> tickets){
        float totalPrice = 0;
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        User user = userMapper.selectByExample(userExample).get(0);
        OrderForm orderForm = new OrderForm();
        Date now = new Date();
        orderForm.setOrderTime(now);
        orderForm.setTicketNumber(ticketNum);
        if(user.getIsVip() == 1){
            totalPrice = (float) (flightMapper.selectByPrimaryKey(tickets.get(0).getFlightId()).getTicketPrice() * ticketNum * 0.8);
            orderForm.setTotalPrice(totalPrice);

        }
        orderForm.setUserId(user.getUserId());
        orderFormMapper.insert(orderForm);
        OrderFormExample orderFormExample = new OrderFormExample();
        Date now1 = addSecond(now,5);
        now = addSecond(now,-1);
        OrderFormExample.Criteria orderFormExampleCriteria = orderFormExample.createCriteria();
        orderFormExampleCriteria.andOrderTimeBetween(now,now1);
        orderFormExampleCriteria.andUserIdEqualTo(user.getUserId());
        orderForm.setOrderFormId(orderFormMapper.selectByExample(orderFormExample).get(0).getOrderFormId());

        for(Ticket ticket : tickets){
            ticket.setPrice(flightMapper.selectByPrimaryKey(ticket.getFlightId()).getTicketPrice());
            if(user.getIsVip() == 1)
                ticket.setDiscount((float)0.8);
            else ticket.setDiscount((float)1);
            ticket.setOrderFormId(orderForm.getOrderFormId());
            ticketMapper.insert(ticket);
        }

        Flight flight = flightMapper.selectByPrimaryKey(tickets.get(0).getFlightId());
        flight.setLeftTicket(flight.getLeftTicket() - ticketNum);
        flightMapper.updateByPrimaryKey(flight);
        
        return totalPrice;
    }

    private Date addSecond(Date date,int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }
}
