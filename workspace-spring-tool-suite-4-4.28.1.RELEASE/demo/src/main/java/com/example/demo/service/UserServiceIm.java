package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.Userlist;

public interface UserServiceIm {
	
	public int insertUserList(Userlist userlist);
	
	public Userlist selectUser(String user_Id);

}
