package com.ikeguang.monitor.mysql.service;

/**
 * @ Author: keguang
 * @ Date: 2019/7/8 10:07
 * @ version: v1.0.0
 * @ description:
 */
public interface MailService {

    public void sendMail(String to, String subject, String content);

    public void sendHtmlMail(String to, String subject, String content);

    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
