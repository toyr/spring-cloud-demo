package com.example.springbootthirdpartemail.controller;

import com.example.springbootthirdpartemail.utils.SendMailModel;
import com.example.springbootthirdpartemail.utils.SendMailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

/**
 * @author xiegaobing
 * @description:
 * @date 2023/1/9 3:59 下午
 */
@RestController
public class TestController {

    @Autowired
    private SendMailUtil sendMailUtil;

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody SendMailModel model) throws MessagingException {
        sendMailUtil.sendMail(model);
        return "success";
    }
}
