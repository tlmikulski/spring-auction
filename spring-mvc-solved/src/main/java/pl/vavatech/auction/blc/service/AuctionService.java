package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepo;

@Service
public class AuctionService {
	@Value("${maxShippingPrice}")
	private BigDecimal maxShippingPrice;

	@Inject
	private AuctionRepo repo;

	public Auction find(Long id) {
		return repo.find(id);
	}

	public List<Auction> findAll() {
		return repo.findAll();
	}

	public Long insert(Auction auction) {
		if (2 > 1) {
			throw new NullPointerException("adsa");
		}
		return repo.insert(auction);
	}

	public void update(Auction auction) {
		repo.update(auction);
	}

	public void delete(Long id) {
		repo.delete(id);
	}

}
