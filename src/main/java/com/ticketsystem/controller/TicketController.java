package com.ticketsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticketsystem.model.Ticket;
import com.ticketsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @RequestMapping("/all")
    public List<Ticket> getAll(){
        return ticketService.getAllTicket();
    }

    @RequestMapping("/formId")
    public List<Ticket> getByFormId(@RequestBody Map<String,String> map){
        return ticketService.getTicketByFormId(Integer.parseInt(map.get("orderFormId")));
    }

    @RequestMapping("ticketId")
    public Ticket getById(@RequestBody Map<String,String> map){
        int id = Integer.parseInt(map.get("ticketId"));
        return ticketService.getTicketById(id);
    }

    @RequestMapping("altTicket")
    public void alterTicket(@RequestBody Map<String,String> map){
        int flightId = Integer.parseInt(map.get("flightId"));
        String passengerName = map.get("passengerName");
        float price = Float.parseFloat(map.get("price"));
        int ticketId = Integer.parseInt(map.get("ticketId"));
        ticketService.altTicket(ticketId,flightId,passengerName,price);
    }

    @RequestMapping("deleteById")
    public void deleteTicket(@RequestBody JSONObject jsonObject){
        int ticketId = jsonObject.getInteger("ticketId");
        ticketService.deleteById(ticketId);
    }
}
