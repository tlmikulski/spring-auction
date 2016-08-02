package pl.vavatech.auction.blc.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Auction;

@Repository
public class InMemoryAuctionRepo implements AuctionRepo {
	private Long currentSequence = 1L;
	private Map<Long, Auction> data = new HashMap();

	private void init() {
		insert(new Auction("DDR3 8GB"));
		insert(new Auction("SSD 250GB"));
	}

	@Override
	public Auction find(Long id) {
		return data.get(id);
	}

	@Override
	public Long insert(Auction auction) {
		auction.setId(currentSequence++);
		data.put(auction.getId(), auction);
		return auction.getId();
	}

	@Override
	public void update(Auction auction) {
		data.put(auction.getId(), auction);
	}

	@Override
	public void delete(Long id) {
		data.remove(id);
	}

}
