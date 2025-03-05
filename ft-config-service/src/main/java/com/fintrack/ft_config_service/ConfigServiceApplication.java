package com.fintrack.ft_config_service;

import com.fintrack.framework.common.util.ProfileSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
//@ComponentScan(basePackages = "com.fintrack")
public class ConfigServiceApplication {

	public static void main(String[] args) {
		System.setProperty("service.name", "config");
		ProfileSetup.setupProfile(new SpringApplication(ConfigServiceApplication.class), args);
	}

}
