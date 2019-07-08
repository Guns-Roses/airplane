package com.ticketsystem.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    private Integer userId;

    private String isManager;

    private String userName;

    private String userPassword;

    private Short isVip;

    public User() {
    }

    public User(String username, String password) {
        this.userName = username;
        this.userPassword = password;
    }

    public User(Integer id, String username, String password) {
        this.userId = id;
        this.userName = username;
        this.userPassword = password;
    }


}