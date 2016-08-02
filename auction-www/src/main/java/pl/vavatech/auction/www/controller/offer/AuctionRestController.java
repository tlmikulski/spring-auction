package pl.vavatech.auction.www.controller.offer;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.service.AuctionService;

@RequestMapping("/offers")
@RestController
public class AuctionRestController {
	@Inject
	AuctionService auctionService;

	@RequestMapping
	public List<Auction> findAll() {
		return auctionService.findAll();
	}
}
