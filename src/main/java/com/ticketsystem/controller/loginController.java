package com.ticketsystem.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ticketsystem.model.User;
import com.ticketsystem.service.CheckService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Api(value = "登录注册功能实现", tags = "登录注册接口")
@RestController
@MapperScan("com.ticketsystem.dao")
public class loginController {

    @Autowired
    private CheckService checkService;

    @ApiOperation(value = "登录功能", notes = "登录逻辑实现的接口")
    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody Map<String, String> param) {
        String username = param.get("username");
        String password = param.get("password");
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        return checkService.login(user);
    }
    /*public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String tname = checkService.login(username,password);
        session.setAttribute("tname",tname);
        if(tname == null){
            return "/";
        }
        else
            return "index";
    }*/

    @ApiOperation(value = "注册功能", notes = "注册逻辑实现的接口")
    @RequestMapping("/registered")
    @ResponseBody
    public User register(@RequestBody Map<String, String> param) {
        String username = param.get("username");
        String password = param.get("password");
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(password);
        return checkService.registered(user);
    }

}
