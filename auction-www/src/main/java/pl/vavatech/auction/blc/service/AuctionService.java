package pl.vavatech.auction.blc.service;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepository;

@Service
public class AuctionService {
	@Inject
	private AuctionRepository repo;
	@Value("${db.username}")
	private String dbUserName;

	public Long save(Auction auction) {
		Random r = new Random();
		auction.setNumber(r.nextInt(1000) + 1);
		repo.save(auction);
		return auction.getId();
	}

	public void update(Auction auction) {
		repo.save(auction);
	}

	public List<Auction> findAll() {
		return repo.findAll();
	}

	public void delete(Long id) {
		repo.delete(id);
	}

	public Auction find(Long auctionId) {
		return repo.findOne(auctionId);
	}

}
