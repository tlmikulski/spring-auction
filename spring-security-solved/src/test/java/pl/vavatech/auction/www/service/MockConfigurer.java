package pl.vavatech.auction.www.service;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import pl.vavatech.auction.blc.repo.AuctionRepo;

@Configuration
public class MockConfigurer {
	@Bean
	@Primary
	public AuctionRepo repo() {
		return mock(AuctionRepo.class);
	}
}
