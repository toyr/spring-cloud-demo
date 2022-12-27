package com.example.springbootgatewayserver.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author xiegaobing
 * @description: 动态路由实现类
 * @date 2022/12/27 6:58 下午
 */
@Service
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Resource
    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    // 新增路由
    public void add(MyRouteDefinition myRouteDefinition) {
        routeDefinitionWriter.save(Mono.just(myRouteDefinition.getRouteDefinition()));
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
    }

    // 删除路由
    public void delete(String id){
        routeDefinitionWriter.delete(Mono.just(id)).subscribe();
    }
}
