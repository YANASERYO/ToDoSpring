package com.example.demo.model;

public class LoginUser {

    private String userId;
    private String userName;

    public LoginUser() {
    }

    public LoginUser(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}