package com.quinbay.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		System.out.println("hello world");
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
