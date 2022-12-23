package com.example.springbootsentinelclient.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiegaobing
 * @description: WebCallbackManager设置统一异常处理和Url清洗
 * @date 2022/12/13 4:51 下午
 */
@Configuration
public class SentinelConfig {

    static {
        //设置自定义的Block异常处理
        WebCallbackManager.setUrlBlockHandler(new WebUrlBlockHandler());
        //设置url清洗
        WebCallbackManager.setUrlCleaner(new WebUrlCleaner());
    }
}
