package com.example.springbootsentinelclient.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author xiegaobing
 * @description: Sentinel的BlockException统一处理
 * @date 2022/12/13 4:49 下午
 */
public class WebUrlBlockHandler implements UrlBlockHandler {

    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException e) throws IOException {
        HashMap<Object, Object> result = new HashMap<>(2);
        String msg = null;
        Integer code = 0;
        if (e instanceof FlowException) {
            msg = "小主慢一点，处理不过来啦！";
            code = 1;
        } else if (e instanceof DegradeException) {
            msg = "当前服务不可用，请稍后重试！";
            code = 2;
        } else if (e instanceof ParamFlowException) {
            msg = "热点参数限流";
            code = 3;
        } else if (e instanceof SystemBlockException) {
            msg = "系统规则（负载/....）不满足要求";
            code = 4;
        } else if (e instanceof AuthorityException) {
            msg = "授权规则不通过";
            code = 5;
        }
        result.put("code", code);
        result.put("msg", msg);
        response.setStatus(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.writeValue(response.getWriter(), result);
    }
}
