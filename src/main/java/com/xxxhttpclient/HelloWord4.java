package com.xxxhttpclient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HelloWord4 {
	public static void main(String[] args) throws ClientProtocolException,
			IOException {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556902048853&di=6de782cd5224abc855b78a59ecc8406f&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F0338cbe93580d5e6b0e89f25531541d455f66fda4a6a5-eVWQaf_fw658");
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");

		CloseableHttpResponse response = null;
		response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out.println(entity.getContentType().getValue());
			InputStream content = entity.getContent();
			FileUtils.copyToFile(content, new File("D://mienv.jpg"));

		}

		response.close();
		httpClient.close();

	}
}
