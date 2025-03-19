package com.example.demo.service;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.dao.EmailDAO;
import com.example.demo.model.Email_table;

import jakarta.annotation.PostConstruct;

@Service
public class EmailService implements EmailServiceIm {

    @Autowired
    private EmailDAO emailDAO;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.imap.host}")
    private String imapHost;

    @Value("${spring.mail.imap.port}")
    private String imapPort;

    @PostConstruct
    public void init() {
        // 애플리케이션이 시작될 때 자동으로 이메일을 가져오는 메서드 호출
        fetchEmailsFromIMAP(username, password, 1); // 실제 사용자 계정 정보와 account_Id 사용
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        // 이메일 전송 로직 구현
    }
    
    @Override
    public void fetchEmailsFromIMAP(String username, String password, int account_Id) {
        try {
            // IMAP 서버 설정
            Properties properties = new Properties();
            properties.put("mail.imap.host", imapHost);
            properties.put("mail.imap.port", imapPort);
            properties.put("mail.imap.ssl.enable", "true");

            // 이메일 세션 생성
            Session emailSession = Session.getInstance(properties);

            // IMAP 저장소 연결
            Store store = emailSession.getStore("imap");
            store.connect(imapHost, username, password);

            // INBOX 폴더 열기
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY); // 읽기 전용으로 폴더 열기

            // 이메일 메시지 가져오기
            Message[] messages = inbox.getMessages(); // 이메일 메시지 전체 가져오기

            // 각 이메일 메시지 처리
            for (Message message : messages) {
                Email_table emailTable = new Email_table();
                emailTable.setSender(message.getFrom()[0].toString()); // 발신자
                emailTable.setReceiver(message.getAllRecipients()[0].toString()); // 수신자
                emailTable.setSubject(message.getSubject()); // 제목

                // 본문 내용 처리 (텍스트 또는 HTML)
                if (message.isMimeType("text/plain")) {
                    emailTable.setEmail_content(message.getContent().toString()); // 본문 내용
                } else if (message.isMimeType("text/html")) {
                    emailTable.setEmail_content((String) message.getContent()); // HTML 본문
                }

                emailTable.setEmail_date(message.getSentDate()); // 발송일시
                emailTable.setAccount_Id(account_Id); // 계정 아이디 설정

                // 이메일을 데이터베이스에 저장
                emailDAO.saveEmail(emailTable);
            }

            // 폴더와 저장소 닫기
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 출력
        }
    }

    @Override
    public List<Email_table> getEmailsByAccountId(int account_Id) {
        return emailDAO.selectEmails(account_Id);
    }
}
