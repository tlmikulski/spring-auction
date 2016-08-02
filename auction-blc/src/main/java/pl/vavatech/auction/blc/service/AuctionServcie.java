package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.repo.AuctionRepo;

@Service
public class AuctionServcie {
	@Value("${maxShippingPrice}")
	private BigDecimal maxShippingPrice;

	@Inject
	private AuctionRepo repo;
}
