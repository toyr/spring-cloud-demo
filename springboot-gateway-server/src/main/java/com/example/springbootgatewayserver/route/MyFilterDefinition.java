package com.example.springbootgatewayserver.route;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiegaobing
 * @description: 过滤器模型类
 * @date 2022/12/27 6:03 下午
 */
public class MyFilterDefinition {

    private String name;

    private Map<String, String> args = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getArgs() {
        return args;
    }

    public void setArgs(Map<String, String> args) {
        this.args = args;
    }
}
