package com.example.demo.model;

import lombok.Data;

@Data
public class email_filter {
	private int filterId;         
    private String userId;        
    private String senderFilter;  
    private String receiverFilter; 
    private String subjectFilter;  
    private String includeFilter;  
    private String excludeFilter;
}
