package pl.vavatech.auction.blc;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.vavatech.auction.blc.service.AuctionServcie;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				BusinessConfig.class);

		AuctionServcie auctionServcie = context.getBean(AuctionServcie.class);
		System.out.println(Arrays.asList(context.getBeanDefinitionCount()));

	}
}
