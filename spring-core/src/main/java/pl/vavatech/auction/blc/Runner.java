package pl.vavatech.auction.blc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.vavatech.auction.blc.component.BackDoor;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepo;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BusinessConfig.class);
		AuctionRepo auctions = context.getBean(AuctionRepo.class);

		// System.out.println(auctions.find(1L).getTitle());

		BackDoor bd = context.getBean(BackDoor.class);
		List<Auction> results = (List<Auction>) bd.evaluate("@auctionService.findAll()");

		System.out.println(results.get(0).getTitle());
	}
}
