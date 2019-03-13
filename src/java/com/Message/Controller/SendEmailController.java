package com.Message.Controller;

import com.Message.Bean.Mails;
import com.Message.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sendemail")
public class SendEmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping("index")
    public String toIndex(){
        return "index";
    }

    @RequestMapping("sendEmail")
    public String toSendMail(Mails mails){
        return "sendEmail";
    }

    @RequestMapping(value = ("receive"), method = RequestMethod.POST)
    public String receive(Mails mails, Model model) throws Exception {
        System.out.println(mails);
        emailService.sendEmail(mails);
        model.addAttribute("msg","1");
        return "success";
    }
}
