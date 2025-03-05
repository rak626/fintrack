package com.fintrack.transaction;

import com.fintrack.framework.common.util.ProfileSetup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TransactionManagementApplication {

	public static void main(String[] args) {
//		SpringApplication.run(TransactionManagementApplication.class, args);
		System.setProperty("service.name", "transaction");
		ProfileSetup.setupProfile(new SpringApplication(TransactionManagementApplication.class), args);
	}

}
