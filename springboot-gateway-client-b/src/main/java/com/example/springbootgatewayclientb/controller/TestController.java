package com.example.springbootgatewayclientb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/27 5:37 下午
 */
@RestController
public class TestController {

    @RequestMapping("/test/1")
    public String test() {
        return "I am client B!!!";
    }
}
