package com.ticketsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticketsystem.model.Flight;
import com.ticketsystem.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(value = "航班操作", tags = "航班操作信息接口")
@RestController
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @ApiOperation(value = "获取所有航班", notes = "")
    //@RequestMapping(value = "all", method = RequestMethod.POST)
    @RequestMapping("all")
    public List<Flight> getAllFlight() {
        return flightService.getAllFlight();
    }

    @ApiOperation(value = "获取航班ID", notes = "")
    @RequestMapping("flightId")
    public Flight getFlightById(@RequestBody Map<String, String> map) {
        int flightId = Integer.parseInt(map.get("flightId"));
        return flightService.getFlightById(flightId);
    }

    @ApiOperation(value = "获取城市信息", notes = "可以根据起飞城市或者到达城市的任一条件或者两者同时作为查询条件")
    @RequestMapping("city")
    public List<Flight> getByCity(@RequestBody JSONObject jsonObject) {
        return flightService.queryByCity(jsonObject.getString("startCity"), jsonObject.getString("endCity"));
    }

    @ApiOperation(value = "修改航班信息", notes = "管理员权限接口，管理员权限下的航班信息修改功能")
    @RequestMapping("altFlight")
    public void altFlight(@RequestBody JSONObject jsonObject) {
        Flight flight = JSONObject.parseObject(jsonObject.toJSONString(), Flight.class);
        flightService.altFlight(flight);
    }

    @ApiOperation(value = "删除航班", notes = "管理员权限接口，管理员权限下的航班删除功能，根据航班ID进行删除")
    @RequestMapping("deleteById")
    public void delFlight(@RequestBody JSONObject jsonObject) {
        int id = jsonObject.getInteger("flightId");
        flightService.delFlight(id);
    }

    @ApiOperation(value = "增加航班", notes = "管理员权限接口，管理员权限下的航班增加功能")
    @RequestMapping("add")
    public void addFlight(@RequestBody JSONObject jsonObject) {
        Flight flight = JSONObject.parseObject(jsonObject.toJSONString(), Flight.class);
        flightService.addFlight(flight);
    }
}
