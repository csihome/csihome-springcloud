package net.famunity.csihome.spring.cloud.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
class MessageRestController {

	@Value("${foo.service.message:Hello default - foo}")
	private String message;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/foo")
	String getMessage() {
		return this.message +"\n"+ serviceUrl();
	}

	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("bar-service");
		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri().toString();
		}
		return null;
	}
}
