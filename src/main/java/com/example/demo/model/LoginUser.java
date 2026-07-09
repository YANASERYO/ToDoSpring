package com.example.demo.model;

public class LoginUser {
	private Long userId;
	private String staffName;

	
	public LoginUser(Long userId,String staffName,String role) {
		this.userId = userId;
		this.staffName = staffName;

	}

	public Long getUserId() {return userId;}
	public String getStaffName() {return staffName;}

}