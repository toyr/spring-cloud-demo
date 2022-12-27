package com.example.springbootgatewayserver.route;

import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiegaobing
 * @description: 路由模型类
 * @date 2022/12/27 6:24 下午
 */
public class MyRouteDefinition {

    private String id;

    private List<MyFilterDefinition> filters = new ArrayList<>();

    private List<MyPredicateDefinition> predicates = new ArrayList<>();

    private String uri;

    private int order = 0;

    public RouteDefinition getRouteDefinition() {
        RouteDefinition definition = new RouteDefinition();
        definition.setId(this.getId());
        definition.setOrder(this.getOrder());

        // 设置断言
        List<PredicateDefinition> pdList = new ArrayList<>();
        List<MyPredicateDefinition> myPredicateDefinitionList = this.getPredicates();
        myPredicateDefinitionList.forEach(p -> {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setName(p.getName());
            predicate.setArgs(p.getArgs());
            pdList.add(predicate);
        });
        definition.setPredicates(pdList);

        // 设置过滤器
        List<FilterDefinition> filterDefinitionList = new ArrayList<>();
        List<MyFilterDefinition> myFilterDefinitionList = this.getFilters();
        myFilterDefinitionList.forEach(f -> {
            FilterDefinition filter = new FilterDefinition();
            filter.setName(f.getName());
            filter.setArgs(f.getArgs());
            filterDefinitionList.add(filter);
        });
        definition.setFilters(filterDefinitionList);

        URI uri = null;
        if (this.getUri().startsWith("http")) {
            uri = UriComponentsBuilder.fromHttpUrl(this.getUri()).build().toUri();
        } else {
            uri = URI.create(this.getUri());
        }
        definition.setUri(uri);

        return definition;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MyFilterDefinition> getFilters() {
        return filters;
    }

    public void setFilters(List<MyFilterDefinition> filters) {
        this.filters = filters;
    }

    public List<MyPredicateDefinition> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<MyPredicateDefinition> predicates) {
        this.predicates = predicates;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
