package com.example.springbootgatewayserver.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/29 3:51 下午
 */
@ConfigurationProperties(prefix = "gateway.routes.config")
@Component
@Data
public class GatewayRouteConfigProperties {

    private String dataId;
    private String group;
    private String namespace;
}
