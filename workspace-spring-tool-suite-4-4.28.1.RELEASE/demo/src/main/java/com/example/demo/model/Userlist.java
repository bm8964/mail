package com.example.demo.model;

import lombok.Data;

@Data
public class Userlist {
	private String user_Id;
    private String user_Password;
    private String user_Name;
    
	public String getUserId() {
		return user_Id;
	}
	public void setUserId(String userId) {
		this.user_Id = userId;
	}
	public String getUserPassword() {
		return user_Password;
	}
	public void setUserPassword(String userPassword) {
		this.user_Password = userPassword;
	}
	public String getUserName() {
		return user_Name;
	}
	public void setUserName(String userName) {
		this.user_Name = userName;
	}
}
