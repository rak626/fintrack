package com.fintrack.finance;

import com.fintrack.framework.common.util.ProfileSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FinanceServiceApplication {

	public static void main(String[] args) {
		System.setProperty("service.name", "finance");
		ProfileSetup.setupProfile(new SpringApplication(FinanceServiceApplication.class), args);
	}

}
