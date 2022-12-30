package com.example.springbootgatewayserver.config;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import com.example.springbootgatewayserver.properties.GatewayRouteConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author xiegaobing
 * @description: 将configService交由spring管理
 * @date 2022/12/29 3:53 下午
 */
@Configuration
public class GatewayConfigServiceConfig {

    @Autowired
    private GatewayRouteConfigProperties configProperties;

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    @Bean
    public ConfigService configService() throws NacosException {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, nacosConfigProperties.getServerAddr());
        properties.setProperty(PropertyKeyConst.NAMESPACE, configProperties.getNamespace());
        properties.setProperty(PropertyKeyConst.USERNAME, nacosConfigProperties.getUsername());
        properties.setProperty(PropertyKeyConst.PASSWORD, nacosConfigProperties.getPassword());
        return NacosFactory.createConfigService(properties);
    }
}
