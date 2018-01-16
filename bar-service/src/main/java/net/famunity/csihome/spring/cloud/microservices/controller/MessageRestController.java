package net.famunity.csihome.spring.cloud.microservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
class MessageRestController {

	@Value("${bar.service.message:Hello default bar}")
	private String message;

	@RequestMapping("/bar")
	String getMessage() {
		return this.message;
	}
}
