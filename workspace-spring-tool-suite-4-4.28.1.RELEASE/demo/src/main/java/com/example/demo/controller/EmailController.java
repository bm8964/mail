//package com.example.demo.controller;
//
//import com.example.demo.model.email_table;
//import com.example.demo.service.EmailService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class EmailController {
//
//    private final EmailService emailService;
//
//    public EmailController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    // 이메일 목록을 가져와 Thymeleaf에 전달
//    @GetMapping("/emails")
//    public String showEmails(Model model) {
//        List<email_table> emailList = emailService.fetchEmails();
//        model.addAttribute("emails", emailList);
//        return "mailbox"; // Thymeleaf 템플릿 이름
//    }
//}
