package com.example.demo.dao;

import com.example.demo.model.Email_table;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface EmailDAO {
    // 메일 삽입
    int insertEmail(Email_table email_table);
    
    void saveEmail(Email_table email);  // 이메일 저장 메서드
    
    List<Email_table> getEmailsByAccountId(int accountId);
    // 메일 목록 조회
    List<Email_table> selectEmails(@Param("account_Id") int account_Id);
}
