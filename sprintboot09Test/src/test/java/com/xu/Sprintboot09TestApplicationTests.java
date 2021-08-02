package com.xu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
    void contextLoads2() throws MessagingException {
        //发送复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

        mimeMessageHelper.setSubject("喵喵喵！");
        mimeMessageHelper.setText("<p style='color: red'>这里是猪妙</p>",true);
        //附件
        mimeMessageHelper.addAttachment("01.jpg",new File("src/main/resources/static/jpg/01.jpg"));

        mimeMessageHelper.setTo("2819991349@qq.com");
        mimeMessageHelper.setFrom("983724494@qq.com");
        mailSender.send(mimeMessage);
    }

    /**
     * 封装个自己的方法
     * @param html: 支持可选文本的多部分消息
     * @param Subject: 邮件标题
     * @param Text: 邮件正文内容
     * @param htmlControl: 标签转义
     * @param To: 收件人邮箱
     * @param From: 发件人邮箱
     * @throws MessagingException
     * @Autor muhuzhongxun 2021/8/2 23:46:00
     */
    public void sendMail(boolean html,String Subject,String Text,boolean htmlControl,String To,String From) throws MessagingException {
        //发送复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        //组装
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,html);

        mimeMessageHelper.setSubject(Subject);
        mimeMessageHelper.setText(Text,htmlControl);
        //附件
        mimeMessageHelper.addAttachment("01.jpg",new File("src/main/resources/static/jpg/01.jpg"));

        mimeMessageHelper.setTo(To);
        mimeMessageHelper.setFrom(From);
        mailSender.send(mimeMessage);
    }

}
