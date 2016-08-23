package pl.vavatech.auction.blc.model;

import java.util.List;

import pl.vavatech.auction.blc.model.Auction;

public interface AuctionRepo {
	Auction find(Long id);

	List<Auction> findAll();

	void update(Auction entity);

	Long insert(Auction entity);

	void delete(Long id);
}
