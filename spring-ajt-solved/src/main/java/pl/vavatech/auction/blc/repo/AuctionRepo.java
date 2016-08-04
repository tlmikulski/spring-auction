package pl.vavatech.auction.blc.repo;

import java.util.List;

import pl.vavatech.auction.blc.model.Auction;

public interface AuctionRepo {
	Auction find(Long id);

	List<Auction> findAll();

	Long insert(Auction auction);

	void update(Auction auction);

	void delete(Long id);
}
