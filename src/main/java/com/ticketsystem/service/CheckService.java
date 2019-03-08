package com.ticketsystem.service;

import com.ticketsystem.dao.UserMapper;
import com.ticketsystem.model.User;
import com.ticketsystem.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckService {

    @Autowired
    private UserMapper userMapper;

    public User getToken(User user){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        if(userMapper.selectByExample(userExample).size() != 0){
            criteria.andUserPasswordEqualTo(user.getUserPassword());
            if(userMapper.selectByExample(userExample).size() != 0){
                user = userMapper.selectByExample(userExample).get(0);
                return user;
            }
            else
                return null;
        }else {
            return null;
        }
    }
}
