package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepo;

@Service
public class AuctionService {
	@Value("${maxShippingPrice}")
	private BigDecimal maxShippingPrice;

	@Inject
	private AuctionRepo auctions;

	public Auction find(Long id) {
		// TODO Auto-generated method stub
		return auctions.find(id);
	}

	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Auction>(auctions.findAll());
	}

	public void update(Auction entity) {
		auctions.update(entity);
	}

	public Long insert(Auction entity) {
		// TODO Auto-generated method stub
		return auctions.insert(entity);
	}

	public void delete(Long id) {
		auctions.delete(id);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
