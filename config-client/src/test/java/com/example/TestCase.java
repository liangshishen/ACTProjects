package com.example;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class TestCase {

	// 方便测试
	public static void main(String[] args) throws IOException {
		String url = "http://localhost:7020/actuator/refresh";
		HttpPost httpPost = new HttpPost(url);
		CloseableHttpClient client = HttpClients.createDefault();
		client.execute(httpPost);
	}

}
