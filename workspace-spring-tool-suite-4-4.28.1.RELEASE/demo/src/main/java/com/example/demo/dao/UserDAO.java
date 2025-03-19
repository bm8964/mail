package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Userlist;

@Mapper

public interface UserDAO {
	
	public int insertUserList(Userlist userlist);
	
	public Userlist selectUser(@Param("user_Id") String user_Id); 

}
