package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity  // JPA 엔티티 클래스를 나타내는 어노테이션
public class Email_table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동 증가 필드 설정
    private int email_Id;
    private int account_Id;
    private String sender;
    private String receiver;
    private String subject;
    private String email_content;
    private Date email_date;
	public int getAccount_Id() {
		return account_Id;
	}
	public void setAccount_Id(int account_Id) {
		this.account_Id = account_Id;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail_content() {
		return email_content;
	}
	public void setEmail_content(String email_content) {
		this.email_content = email_content;
	}
	public Date getEmail_date() {
		return email_date;
	}
	public void setEmail_date(Date email_date) {
		this.email_date = email_date;
	}
}
