package pl.vavatech.auction.blc.repo;

import pl.vavatech.auction.blc.model.Auction;

public interface AuctionRepo {
	Auction find(Long id);

	Long insert(Auction auction);

	void update(Auction auction);

	void delete(Long id);
}
