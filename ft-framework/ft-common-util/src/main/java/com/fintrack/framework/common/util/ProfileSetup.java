package com.fintrack.framework.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import java.util.Properties;

public class ProfileSetup {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileSetup.class);

    public static void setupProfile(SpringApplication application, String[] args) {
        Properties properties = getProperties();
        application.setDefaultProperties(properties);
        application.run(args);
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        String profiles = System.getProperty("spring.profiles.active", "default");
        LOGGER.info("Current Active profiles : {}", profiles);
        if (profiles.contains("default") || profiles.contains("local") || profiles.contains("dev") || profiles.contains("qa") || profiles.contains("prod")) {
            properties.put("eureka.client.enabled", "true");
            properties.put("spring.cloud.config.discovery.enabled", "true");
        } else {
            String configUrl = System.getProperty("config.server.url", "http://config-service:9001");
            properties.put("server.port", System.getProperty("server.port", "9001"));
            properties.put("spring.cloud.config.discovery.enabled", false);
            properties.put("eureka.client.enabled", false);
            if (!System.getProperty("service.name").equals("config")) {
                properties.put("spring.config.import", "optional:configserver:" + configUrl);
            }
        }
        return properties;
    }
}
