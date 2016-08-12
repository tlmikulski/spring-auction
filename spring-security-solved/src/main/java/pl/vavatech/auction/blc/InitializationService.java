package pl.vavatech.auction.blc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.AuctionType;
import pl.vavatech.auction.blc.repo.AuctionRepo;

@Service
public class InitializationService {
	@Inject
	AuctionRepo repo;

	@Transactional
	public void init() {
		Auction ssd = new Auction("Dysk SSD");
		ssd.setAuctionType(AuctionType.BIDDING);
		ssd.setCurrentPrice(BigDecimal.TEN.add(BigDecimal.valueOf(0.75)));
		ssd.setShippingPrice(BigDecimal.valueOf(9.99));
		ssd.setExpiryDate(LocalDateTime.now().plusHours(2));
		ssd.setDescription("Super Dysk SSD");
		repo.insert(ssd);

		Auction ddr = new Auction("DDR 3 8GB");
		ddr.setAuctionType(AuctionType.BUY_NOW);
		ddr.setCurrentPrice(BigDecimal.ONE.add(BigDecimal.valueOf(0.75)));
		ddr.setShippingPrice(BigDecimal.valueOf(4.99));
		ddr.setExpiryDate(LocalDateTime.now().plusDays(2));
		ssd.setDescription("Super DDR 3 8GB");
		repo.insert(ddr);

	}
}
