package com.Message.Service;

import com.Message.Bean.Mails;

import javax.mail.Message;

public interface EmailService {

     boolean sendEmail(Mails mails) throws Exception;

     Message receiveEmail() throws Exception;
}
