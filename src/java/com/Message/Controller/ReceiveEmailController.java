package com.Message.Controller;

import com.Message.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receive")
public class ReceiveEmailController {

    @Autowired
    EmailService emailService;

    @RequestMapping("getAll")
    public String receiveEmail() throws Exception {
        emailService.receiveEmail();
        return "success";
    }
}
