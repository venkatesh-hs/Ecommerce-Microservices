package com.revival.inventory.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryBookApplication.class, args);
	}

}
