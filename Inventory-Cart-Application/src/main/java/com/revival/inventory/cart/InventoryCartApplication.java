package com.revival.inventory.cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class InventoryCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryCartApplication.class, args);
	}

}
