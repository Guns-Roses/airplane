package com.ticketsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ticketsystem.model.User;
import com.ticketsystem.service.CheckService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@MapperScan("com.ticketsystem.dao")
public class loginController {

    @Autowired
    private CheckService checkService;

    @RequestMapping("/user")
    @ResponseBody
    public User token(@RequestBody Map<String,String> param){
        String username = param.get("username");
        String password = param.get("password");
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        return checkService.getToken(user);
    }

}
