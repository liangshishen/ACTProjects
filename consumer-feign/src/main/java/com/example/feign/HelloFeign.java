package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 调用服务提供者
@FeignClient("provider-user")
public interface HelloFeign {

	// 注意：@PathVariable("name") 中的"name"不能省略
	@RequestMapping("/hello/{name}")
	String hello(@PathVariable("name") String name);

}
