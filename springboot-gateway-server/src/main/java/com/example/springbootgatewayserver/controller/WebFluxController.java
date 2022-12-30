package com.example.springbootgatewayserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/29 1:53 下午
 */
@RestController
@RequestMapping(value = "/flux")
public class WebFluxController {

    @RequestMapping(value = "/demo")
    public Mono<String> hellowordld() {
        return Mono.just("hello world");
    }
}
