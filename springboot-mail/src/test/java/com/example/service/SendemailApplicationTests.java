package com.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 王江超
 * @Date 2019/12/26 17:50
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendemailApplicationTests {

    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private IMailService mailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        mailService.sendSimpleMail("wangjc2008@qq.com","主题：你好普通邮件","内容：第一封邮件");
    }

    @Test
    public void sendmailHtml(){
        mailService.sendHtmlMail("wangjc2008@qq.com","主题：你好html邮件","<h1>内容：第一封html邮件</h1>");
    }
}
