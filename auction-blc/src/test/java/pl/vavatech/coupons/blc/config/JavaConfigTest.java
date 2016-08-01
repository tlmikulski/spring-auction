package pl.vavatech.coupons.blc.config;

import static org.assertj.core.api.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import pl.vavatech.auction.blc.service.AuctionService;
import pl.vavatech.coupons.blc.AbstractIntegrationTest;

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
