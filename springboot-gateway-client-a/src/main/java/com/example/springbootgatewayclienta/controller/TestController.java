package com.example.springbootgatewayclienta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/27 11:09 上午
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/1")
    public String test() {
        return "I am client A!!!";
    }
}
