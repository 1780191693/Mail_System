package com.Message.Service.Impl;

import com.Message.Bean.Mails;
import com.Message.Bean.POP_Config;
import com.Message.Bean.SMTP_Config;
import com.Message.Service.EmailService;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(Mails mails) throws Exception {
        Properties properties = new Properties();

        //debug调试模式
//        properties.setProperty("mail.debug","true");
        //身份验证
        properties.setProperty("mail.smtp.auth","true");
        //邮件服务器主机名
        properties.setProperty("mail.host", SMTP_Config.HOST);
        //发送邮件协议
        properties.setProperty("mail.transport.protocol", SMTP_Config.PROTOCOL);

        //ssl认证
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);

        //会话开始
        Session session = Session.getInstance(properties);
        Message msg = new MimeMessage(session);
        msg.setSubject(mails.getTitle());  //邮件主题
        StringBuilder builder = new StringBuilder();
        builder.append("\n"+mails.getContent());
        msg.setText(builder.toString()); //邮件文本
        msg.setFrom(new InternetAddress("1780191693@qq.com"));  //邮件来源
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "1780191693@qq.com", "setshurxbkhahhch"); //发送消息

        //可能有多个地址  产生群发
//        transport.sendMessage(msg, mails.getAddress());
        transport.sendMessage(msg,new Address[] { new InternetAddress(mails.getAddress()) });
        transport.close();

        return true;
    }

    @Override
    public Message receiveEmail() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", POP_Config.PROTOCOL);
        properties.setProperty("mail.smtp.host",POP_Config.HOST);

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        properties.put("mail.pop.ssl.enable", "true");
        properties.put("mail.pop.ssl.socketFactory", sf);
        //开始会话
        Session session = Session.getInstance(properties);
        session.setDebug(false);

        Store store = session.getStore(POP_Config.PROTOCOL);
        store.connect(POP_Config.HOST,"1780191693@qq.com","setshurxbkhahhch");

        Folder folder = store.getFolder("INBOX");  //只能指定为INBOX ，暂时没搞懂为什么
        folder.open(Folder.READ_WRITE);  //设置读写权限

        Message [] messages = folder.getMessages(); //获取所有邮件
        ArrayList<Mails> mails = new ArrayList<>();

        Mails mail = new Mails();
        //封装所有邮件
        for (Message message : messages){
            mail.setTitle(message.getSubject());
            mail.setAddress(message.getFrom().toString());
            mail.setContent(message.getContent().toString());
            System.out.println(mail);
            mails.add(mail);
        }
        //关闭邮件夹对象
        folder.close(false);
        store.close();
        return null;
    }
}
