package com.ticketsystem.model;

import java.io.Serializable;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager == null ? null : isManager.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Short getIsVip() {
        return isVip;
    }

    public void setIsVip(Short isVip) {
        this.isVip = isVip;
    }
}