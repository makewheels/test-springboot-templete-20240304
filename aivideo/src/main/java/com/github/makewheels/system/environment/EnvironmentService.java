package com.github.makewheels.system.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 环境，配置
 */
@Service
public class EnvironmentService {
    @Value("${spring.profiles.active}")
    private String environment;

    @Value("${server.port}")
    private Integer serverPort;


    public String getEnvironment() {
        return environment;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    /**
     * 环境判断
     */
    public boolean isDevelopmentEnv() {
        return environment.equals(Environment.DEVELOPMENT);
    }

    public boolean isProductionEnv() {
        return environment.equals(Environment.PRODUCTION);
    }

}
