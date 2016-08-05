package pl.vavatech.auction.www.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class Client {
	public static void main(String[] args) {
		HttpEntity<String> request = setUserPassowrd();
		RestTemplate restTemplate = new RestTemplate();

		setTimeout(restTemplate);

		List result = restTemplate.exchange(
				"http://localhost:8080/auction-security-solved/rest/auctions", HttpMethod.GET,
				request, List.class).getBody();

		System.out.println(result);
	}

	private static HttpEntity<String> setUserPassowrd() {
		String plainCreds = "remote:password";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		return request;
	}

	private static void setTimeout(RestTemplate restTemplate) {
		SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
				.getRequestFactory();
		rf.setReadTimeout(1 * 1000);
		rf.setConnectTimeout(1 * 1000);
	}
}
