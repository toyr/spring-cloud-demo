package com.example.springbootadminclient.indicator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author xiegaobing
 * @description:
 * @date 2022/12/13 2:10 下午
 */
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // perform some specific health check
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().
                    withDetail("msg", "error service").
                    withDetail("code", 500).
                    build();
        }
        return Health.up().build();
    }

    private int check() {
        return 0;
    }
}