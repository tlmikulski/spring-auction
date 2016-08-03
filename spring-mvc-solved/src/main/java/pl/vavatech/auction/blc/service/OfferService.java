package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.dto.OfferDto;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.Offer;
import pl.vavatech.auction.blc.repo.AuctionRepo;
import pl.vavatech.auction.blc.repo.OfferRepo;

@Service
public class OfferService {
	@Inject
	private OfferRepo offerRepo;

	@Inject
	private AuctionRepo auctionRepo;

	public Long insert(OfferDto dto) {
		Auction auction = auctionRepo.findAll().stream()
				.filter(arg -> arg.getNumber().equals(dto.getAuctionNumber()))
				.findFirst().orElseThrow(IllegalStateException::new);

		BigDecimal currentPrice = auction.getCurrentPrice();
		if (currentPrice != null && currentPrice.compareTo(dto.getBid()) == 1) {
			throw new IllegalArgumentException("Bid is too small. Minimum "
					+ currentPrice);
		}

		auction.setCurrentPrice(dto.getBid());

		auctionRepo.update(auction);

		Offer offer = new Offer();
		offer.setAuction(auction);
		offer.setBid(dto.getBid());
		offer.setDate(LocalDateTime.now());

		return offerRepo.insert(offer);

	}
}
