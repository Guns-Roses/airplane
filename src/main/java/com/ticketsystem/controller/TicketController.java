package com.ticketsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticketsystem.model.Ticket;
import com.ticketsystem.service.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "机票管理", tags = "机票管理接口")
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @ApiOperation(value = "查询所有乘客的订票信息", notes = "无需传参，直接可以查看")
    @RequestMapping("/all")
    public List<Ticket> getAll() {
        return ticketService.getAllTicket();
    }

    @ApiOperation(value = "获取订单号", notes = "")
    @RequestMapping("/formId")
    public List<Ticket> getByFormId(@RequestBody Map<String, String> map) {
        return ticketService.getTicketByFormId(Integer.parseInt(map.get("orderFormId")));
    }

    @ApiOperation(value = "获取航班号", notes = "")
    @RequestMapping("ticketId")
    public Ticket getById(@RequestBody Map<String, String> map) {
        int id = Integer.parseInt(map.get("ticketId"));
        return ticketService.getTicketById(id);
    }

    @ApiOperation(value = "机票改签", notes = "管理员权限接口，管理员权限下的航班改签功能")
    @RequestMapping("altTicket")
    public void alterTicket(@RequestBody Map<String, String> map) {
        int flightId = Integer.parseInt(map.get("flightId"));
        String passengerName = map.get("passengerName");
        float price = Float.parseFloat(map.get("price"));
        int ticketId = Integer.parseInt(map.get("ticketId"));
        ticketService.altTicket(ticketId, flightId, passengerName, price);
    }

    @ApiOperation(value = "退订机票", notes = "管理员权限接口，管理员权限下的机票退订功能")
    @RequestMapping("deleteById")
    public void deleteTicket(@RequestBody JSONObject jsonObject) {
        int ticketId = jsonObject.getInteger("ticketId");
        ticketService.deleteById(ticketId);
    }
}
