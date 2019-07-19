package com.example.controller;

import com.example.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private HelloFeign helloFeign;

	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name) {
		return helloFeign.hello(name);
	}

}
