package com.example.springbootgatewayserver.service;

import org.springframework.cloud.gateway.route.RouteDefinition;

/**
 * @author xiegaobing
 * @description: 路由配置服务
 * @date 2022/12/29 3:41 下午
 */
public interface RouteService {

    /**
     * 更新路由配置
     *
     * @param routeDefinition
     */
    void update(RouteDefinition routeDefinition);

    /**
     * 添加路由配置
     *
     * @param routeDefinition
     */
    void add(RouteDefinition routeDefinition);

    /**
     * 删除路由配置
     *
     * @param routeId
     */
    void delete(String routeId);


}
