package com.example.controller;

import com.example.feign.HelloFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private HelloFeign helloFeign;

	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod = "fallbackHello")
	public String hello(@PathVariable("name") String name) {
		return helloFeign.hello(name);
	}

	/**
	 * 断路器方法
	 * 1. 返回值要与目标方法一致
	 * 2. 参数要与目标方法一致
	 * > 注意一个BUG，断路器刚启动时，第一次访问就到断路器，不正常。
	 * > 第一次进入断路器不算数。
	 */
	public String fallbackHello(String name) {
		// 当发生异常时，直接返回默认值，这种形式称之为：降级。
		return "fallback";
	}

}
