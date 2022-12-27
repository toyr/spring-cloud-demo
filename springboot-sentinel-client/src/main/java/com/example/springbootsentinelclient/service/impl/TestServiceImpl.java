package com.example.springbootsentinelclient.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.springbootsentinelclient.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/14 2:13 下午
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @SentinelResource(value = "sayHello")
    public String sayHello(String name) {
        return "hello" + name;
    }
}
