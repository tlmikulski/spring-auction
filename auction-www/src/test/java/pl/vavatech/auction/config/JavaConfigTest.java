package pl.vavatech.auction.config;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import pl.vavatech.auction.AbstractIntegrationTest;
import pl.vavatech.auction.blc.service.AuctionService;

public class JavaConfigTest extends AbstractIntegrationTest {
	@Inject
	ApplicationContext context;

	@Test
	public void shouldReadSpringConfig() throws Exception {
		assertThat(context).isNotNull();
	}

	@Test
	public void shouldContainsAuctionService() throws Exception {
		// when
		AuctionService auctionService = context.getBean(AuctionService.class);

		// then
		assertThat(auctionService).isNotNull();
	}
}
