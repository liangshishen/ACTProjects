package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		//String url = "http://localhost:7900/hello/" + name;
		String url = "http://provider-user/hello/" + name;
		return restTemplate.getForObject(url, String.class);
	}

}
