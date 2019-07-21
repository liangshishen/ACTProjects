package com.example.controller;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RefreshScope // 指明此类的@Value注解进行刷新
public class HelloController {

	/**
	 * 从git中获取属性值
	 * > @Value注解比`application.properties`先执行，还没获取到git内容就使用，会报错。
	 * > 解决方法：bootstrap配置文件比application配置文件先执行。
	 */
	@Value("${jtver}")
	private String jtver;

	@RequestMapping("/hello")
	public String hello() {
		return jtver;
	}

}
