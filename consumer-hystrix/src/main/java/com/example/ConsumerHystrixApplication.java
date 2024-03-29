package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
public class ConsumerHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerHystrixApplication.class, args);
	}

}
