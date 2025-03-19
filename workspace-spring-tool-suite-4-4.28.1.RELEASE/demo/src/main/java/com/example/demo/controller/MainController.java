package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    // 로그인 페이지를 반환하는 메소드
    @GetMapping("/")
    public String LoginPage() {
        return "login";
    }
    
    // 회원가입 페이지를 반환하는 메소드
    @GetMapping("/signup")
    public String signupPage() {       
        return "signup"; 
    }
    
    // 비밀번호 변경 페이지를 반환하는 메소드
    @GetMapping("/changepw")
    public String changepw() {        
        return "changepw"; 
    }
    
    // 기본 헤더를 반환하는 메소드
    @GetMapping("/header")
    public String header() {        
        return "header"; 
    }

    // 기본 메일함을 반환하는 메소드
    @GetMapping("/mailbox")
    public String mailbox() { 
        return "mailbox"; 
    }
    
    // 발신 메일함을 반환하는 메소드
    @GetMapping("/sender")
    public String sender() { 
        return "sender"; 
    }
    
    //  메일상세함을 반환하는 메소드
    @GetMapping("/detail")
    public String detail() { 
        return "detail"; 
    }
    
    //  메일작성을 반환하는 메소드
    @GetMapping("/mail")
    public String mail() { 
        return "mail"; 
    }
    
    //  라벨함을 반환하는 메소드
    @GetMapping("/label")
    public String label() { 
        return "label"; 
    }
}
