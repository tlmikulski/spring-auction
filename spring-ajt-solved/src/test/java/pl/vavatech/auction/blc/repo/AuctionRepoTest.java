package pl.vavatech.auction.blc.repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.inject.Inject;

import org.junit.Test;

import pl.vavatech.auction.blc.AbstractIntegrationTest;
import pl.vavatech.auction.blc.model.Auction;

public class AuctionRepoTest extends AbstractIntegrationTest {
	@Inject
	AutoAuctionRepo repo;

	@Test
	public void shouldFindAuctionByTitle() throws Exception {
		// given
		String title = "Dysk SSD";

		// when
		Optional<Auction> auction = repo.findByTitle(title);

		// then
		assertThat(auction).isPresent();
	}
}
