package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class UserAccountEntity {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "user_name")
    private String userName;

    public UserAccountEntity() {
    }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPass() { return userPass; }
    public void setUserPass(String userPass) { this.userPass = userPass; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}