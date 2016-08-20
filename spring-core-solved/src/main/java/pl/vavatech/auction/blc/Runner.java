package pl.vavatech.auction.blc;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.vavatech.auction.blc.component.BackDoor;
import pl.vavatech.auction.blc.repo.AuctionRepo;
import pl.vavatech.auction.blc.service.AuctionService;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BusinessConfig.class);

		System.out.println(context.getBean(BackDoor.class).execute("@inMemoryAuctionRepo.find(1L)"));

		AuctionService auctionServcie = context.getBean(AuctionService.class);
		Arrays.asList(context.getBeanDefinitionCount()).forEach(name -> System.out.println(name));

		System.out.println(context.getBean(AuctionRepo.class));

	}
}
