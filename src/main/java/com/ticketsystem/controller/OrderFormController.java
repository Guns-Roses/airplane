package com.ticketsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ticketsystem.model.OrderForm;
import com.ticketsystem.model.Ticket;
import com.ticketsystem.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/form")
public class OrderFormController {
    @Autowired
    private FormService formService;

    @RequestMapping("/all")
    public List<OrderForm> getAll(@RequestBody Map<String,String> data) {
        String username = data.get("username");
        return formService.getAll(username);
    }

    @RequestMapping("/price")
    public Map<String,Float> price(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        int flightId = jsonObject.getInteger("flightId");
        int ticketNum = jsonObject.getInteger("ticketNumber");
        float allPrice = formService.getAllPrice(username,ticketNum,flightId);
        return new HashMap<String, Float>(){{
            put("totalPrice",allPrice);
        }
        };
    }

    @RequestMapping("/order")
    @ResponseBody
    public Map<String,Float> order(@RequestBody JSONObject jsonObject){
        /*
        username
        flightId
        ticketNumber
        passengerNames
         */
        String username = jsonObject.getString("username");
        int flightId = jsonObject.getInteger("flightId");
        int ticketNum = jsonObject.getInteger("ticketNumber");
        JSONArray passengerArr = jsonObject.getJSONArray("passengerNames");
        String passStr = passengerArr.toJSONString();
        List<Ticket> tickets = JSONObject.parseArray(passStr,Ticket.class);
        for(Ticket ticket : tickets){
           ticket.setFlightId(flightId);
        }
        Map<String,Float> map1 = new HashMap<>();
        float totalPrice = formService.order(username,ticketNum,tickets);
        map1.put("totalPrice",totalPrice);
        return map1;
    }
}
