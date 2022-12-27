package com.example.springbootgatewayserver.controller;

import com.example.springbootgatewayserver.route.DynamicRouteServiceImpl;
import com.example.springbootgatewayserver.route.MyRouteDefinition;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xiegaobing
 * @description:
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

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        try{
            dynamicRouteService.delete(id);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }


}
