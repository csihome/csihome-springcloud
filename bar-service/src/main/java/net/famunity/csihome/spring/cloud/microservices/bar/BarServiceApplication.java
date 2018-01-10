package net.famunity.csihome.spring.cloud.microservices.bar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarServiceApplication.class, args);
	}
}
