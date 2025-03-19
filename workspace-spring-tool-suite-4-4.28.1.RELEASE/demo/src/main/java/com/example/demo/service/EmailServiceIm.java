package com.example.demo.service;

import com.example.demo.model.Email_table;
import java.util.List;

public interface EmailServiceIm {

	  void sendEmail(String to, String subject, String body);
	  
	  void fetchEmailsFromIMAP(String username, String password, int account_Id);
	  
	  List<Email_table> getEmailsByAccountId(int account_Id);
}
