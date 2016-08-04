package pl.vavatech.auction.service;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;

import pl.vavatech.auction.AbstractIntegrationTest;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.service.AuctionService;

public class AuctionServiceTest extends AbstractIntegrationTest {
	@Inject
	AuctionService service;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void shouldAddAuction() throws Exception {
		// given
		Long auctionCount = count(Auction.class);

		Auction auction = new Auction("Laptop");

		// when
		service.insert(auction);

		// then
		assertThat(count(Auction.class)).isGreaterThan(auctionCount);
	}

	@Test
	public void shouldUpdateAuction() throws Exception {
		// given
		Long auctionCount = count(Auction.class);
		Long auctionId = service.insert(new Auction("Laptop"));

		// when
		Auction auction = service.find(auctionId);
		auction.setTitle("new title");
		service.update(auction);

		// then
		assertThat(count(Auction.class)).isGreaterThan(auctionCount);
	}
}
