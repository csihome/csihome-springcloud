package net.famunity.csihome.spring.cloud.microservices.foo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAutoConfiguration
public class FooServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FooServiceApplication.class, args);
	}
}

@RefreshScope
@RestController
class MessageRestController {

	@Value("${foo.service.message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}

