package pl.vavatech.auction.blc.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Offer;

@Repository
public class InMemoryOfferRepo implements OfferRepo {
	private Long currentSequence = 1L;
	private Map<Long, Offer> data = new HashMap();

	@Override
	public Offer find(Long id) {
		return data.get(id);
	}

	@Override
	public Long insert(Offer auction) {
		auction.setId(currentSequence++);
		data.put(auction.getId(), auction);
		return auction.getId();
	}

	@Override
	public void update(Offer auction) {
		data.put(auction.getId(), auction);
	}

	@Override
	public void delete(Long id) {
		data.remove(id);
	}

}
