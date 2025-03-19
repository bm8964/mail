package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data
public class Send_email {
	 	private int sendId;          
	    private int accountId;       
	    private String sender;       
	    private String receiver;     
	    private String subject;      
	    private String emailContent; 
	    private Date emailDate;     
}
