package com.revival.inventory.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class InventoryDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryDiscoveryServiceApplication.class, args);
	}

}
