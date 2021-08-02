package com.xu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.internet.MimeMessage;

@SpringBootTest
class Sprintboot09TestApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //发送简单的邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("你好啊妙妙");
        simpleMailMessage.setText("哈哈");
        simpleMailMessage.setTo("2819991349@qq.com");
        simpleMailMessage.setFrom("983724494@qq.com");

        mailSender.send(simpleMailMessage);
    }

    @Test
    void contextLoads2() {
        //发送复杂的邮件

        MimeMessage mimeMessage = new MimeMessage();

        mailSender.send(mimeMessage);
    }

}
