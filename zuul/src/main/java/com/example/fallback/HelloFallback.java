package com.example.fallback;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * zuul 环境中启动它作为一个断路器
 * 注：SpringBoot1.5.x版本实现的是 ZuulFallbackProvider 接口，2.x后改为 FallbackProvider
 */
@Component
public class HelloFallback implements FallbackProvider {

	@Override
	public String getRoute() {
		return "*"; // 路由
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		return new ClientHttpResponse() {

			@Override // 头信息
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}

			@Override // 返回内容
			public InputStream getBody() throws IOException {
				// 可以构造JSON字符串
				String msg = "zuul fallback message.";
				return new ByteArrayInputStream(msg.getBytes());
			}

			@Override // 状态码
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST;
			}

			@Override // 状态码的值
			public int getRawStatusCode() throws IOException {
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override // 状态文字描述
			public String getStatusText() throws IOException {
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override // 关闭
			public void close() {

			}
		};
	}

}
