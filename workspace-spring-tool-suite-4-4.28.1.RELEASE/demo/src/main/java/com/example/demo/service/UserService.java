package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.Userlist;

@Service
public class UserService implements UserServiceIm{
	
	 @Autowired
	    private UserDAO userdao;

	    @Override
	    public int insertUserList(Userlist userlist) {
	        return userdao.insertUserList(userlist);
	    }

	    @Override
	    public Userlist selectUser(String user_Id) {
	        return userdao.selectUser(user_Id); 
	    }
	}