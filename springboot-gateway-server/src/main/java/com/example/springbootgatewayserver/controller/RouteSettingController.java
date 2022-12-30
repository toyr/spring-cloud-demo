package com.example.springbootgatewayserver.controller;

import com.example.springbootgatewayserver.route.DynamicRouteServiceImpl;
import com.example.springbootgatewayserver.route.MyRouteDefinition;
import com.example.springbootgatewayserver.route.RedisRefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author xiegaobing
 * @description: 动态路由
 * @date 2022/12/27 7:19 下午
 */
@RestController
@RequestMapping("/api")
public class RouteSettingController {

    @Resource
    private DynamicRouteServiceImpl dynamicRouteService;

    @PostMapping("/add")
    public String add(@RequestBody MyRouteDefinition myRouteDefinition) {
        try {
            dynamicRouteService.add(myRouteDefinition);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping("/update")
    public String update(@RequestBody MyRouteDefinition myRouteDefinition) {
        try {
            dynamicRouteService.update(myRouteDefinition);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        try{
            dynamicRouteService.delete(id);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Autowired
    private RedisRefreshRouteService redisRefreshRouteService;


    @PostMapping("/redis/add")
    public Mono<ResponseEntity<String>> redisCreate(@RequestBody RouteDefinition entity) {
        redisRefreshRouteService.add(entity);
        return Mono.just(new ResponseEntity<>("save success", HttpStatus.OK));
    }


    @PostMapping("/redis/update")
    public Mono<ResponseEntity<String>> redisUpdate(@RequestBody RouteDefinition entity) {
        redisRefreshRouteService.update(entity);
        return Mono.just(new ResponseEntity<>("update success", HttpStatus.OK));
    }


    @PostMapping("/redis/delete/{id}")
    public Mono<ResponseEntity<String>> redisDelete(@PathVariable String id) {
        redisRefreshRouteService.delete(id);
        return Mono.just(new ResponseEntity<>("delete success", HttpStatus.OK));
    }

}
