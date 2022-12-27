package com.example.springbootadminclient.indicator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/13 2:12 下午
 */
@Component
public class AppInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("version", "1.0.RELEASE");
        builder.withDetail("project", "admin-client");
    }
}
