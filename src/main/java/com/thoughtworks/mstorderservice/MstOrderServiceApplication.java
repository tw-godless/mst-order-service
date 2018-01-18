package com.thoughtworks.mstorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MstOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MstOrderServiceApplication.class, args);
	}
}
