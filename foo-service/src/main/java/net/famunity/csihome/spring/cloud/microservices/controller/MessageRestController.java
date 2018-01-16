package net.famunity.csihome.spring.cloud.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RefreshScope
@RestController
class MessageRestController {

	@Value("${foo.service.message:Hello default - foo}")
	private String message;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/foo")
	String getMessage() {
		ResponseEntity responseEntity = restTemplate.exchange(
				"http://bar-service/bar",
				HttpMethod.GET,
				HttpEntity.EMPTY,
				ParameterizedTypeReference.forType(String.class),
				"");

		return this.message + "<br/><br/>And also bar-service response from " + serviceUrl() + ": <br/><br/>" + responseEntity.toString();
	}

	private String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("bar-service");
		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri().toString();
		}
		return null;
	}
}
