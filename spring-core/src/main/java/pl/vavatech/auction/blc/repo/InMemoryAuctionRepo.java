package pl.vavatech.auction.blc.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Auction;

@Repository
public class InMemoryAuctionRepo implements AuctionRepo {

	Long lastInsertId = 1L;
	Map<Long, Auction> auctions = new HashMap<>();

	@PostConstruct
	public void init() {
		insert(new Auction("SSD"));
		insert(new Auction("HDD"));
	}

	@Override
	public Auction find(Long id) {
		// TODO Auto-generated method stub
		return auctions.get(id);
	}

	@Override
	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Auction>(auctions.values());
	}

	@Override
	public void update(Auction entity) {
		auctions.put(entity.getId(), entity);
	}

	@Override
	public Long insert(Auction entity) {
		// TODO Auto-generated method stub
		entity.setId(lastInsertId++);
		auctions.put(entity.getId(), entity);

		return entity.getId();
	}

	@Override
	public void delete(Long id) {
		auctions.remove(id);
	}

}
