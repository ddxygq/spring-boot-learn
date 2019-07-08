package com.ikeguang.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @ Author: keguang
 * @ Date: 2019/7/8 10:44
 * @ version: v1.0.0
 * @ description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail(){
        mailService.sendMail("hbzegkg@126.com", "test simple mail", "hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h1>hello world ! 这是一封html邮件!</h1>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("hbzegkg@126.com","test html mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="D:\\tmp\\data\\test.txt";
        mailService.sendAttachmentsMail("ikeguang@126.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "ikeguang";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "F:\\我的文件\\图片\\driver.gif";

        mailService.sendInlineResourceMail("ikeguang@126.com", "这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("sitemap", "sitemap.xml");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("ikeguang@126.com","主题：这是模板邮件",emailContent);
    }

}
