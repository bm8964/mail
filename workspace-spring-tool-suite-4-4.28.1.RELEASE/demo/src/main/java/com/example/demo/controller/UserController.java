package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Userlist;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@PostMapping("/insert/user")
	public String insertuser (@RequestParam("user_Id") String user_Id, 
							  @RequestParam("user_Password") String user_Password, 
							  @RequestParam("user_Name") String user_Name) {
	    Userlist userlist = new Userlist();
	    userlist.setUserId(user_Id);
	    userlist.setUserPassword(user_Password);
	    userlist.setUserName(user_Name);
	    userservice.insertUserList(userlist);
	    return "redirect:/";
	}

	
	@PostMapping("/mail/box")
	public String selectUser(@RequestParam("user_Id") String user_Id) {
		userservice.selectUser(user_Id);
		return "redirect:/mailbox";
		
	}
	}


