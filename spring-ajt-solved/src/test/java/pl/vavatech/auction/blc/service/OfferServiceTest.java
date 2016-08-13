package pl.vavatech.auction.blc.service;

import static com.googlecode.catchexception.apis.BDDCatchException.caughtException;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;

import pl.vavatech.auction.blc.AbstractIntegrationTest;
import pl.vavatech.auction.blc.dto.OfferDto;
import pl.vavatech.auction.blc.model.Auction;

public class OfferServiceTest extends AbstractIntegrationTest {
	@Inject
	AuctionService auctionService;
	@Inject
	OfferService offerService;

	@Test
	public void shouldAddOfferToAuction() throws Exception {
		// given
		Auction auction = new Auction("Laptop");
		auctionService.insert(auction);

		// when
		OfferDto offerDto = new OfferDto();
		offerDto.setAuctionNumber(auction.getNumber());
		offerDto.setBid(BigDecimal.TEN);
		offerService.insert(offerDto);

		// then
		assertThat(auctionService.find(auction.getId()).getCurrentPrice()).isEqualTo(offerDto.getBid());
	}

	@Test
	public void shouldThrowExceptionWhenBidIsTooLow() throws Exception {
		// given
		Auction auction = new Auction("Laptop");
		auctionService.insert(auction);

		OfferDto highOffer = new OfferDto();
		highOffer.setAuctionNumber(auction.getNumber());
		highOffer.setBid(BigDecimal.TEN);
		offerService.insert(highOffer);

		// when
		OfferDto lowOffer = new OfferDto();
		lowOffer.setAuctionNumber(auction.getNumber());
		lowOffer.setBid(BigDecimal.ONE);

		when(() -> offerService.insert(lowOffer));

		// then
		assertThat(caughtException()).isInstanceOf(IllegalArgumentException.class);
	}
}
