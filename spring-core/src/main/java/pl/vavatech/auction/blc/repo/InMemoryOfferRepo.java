package pl.vavatech.auction.blc.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Offer;

@Repository
public class InMemoryOfferRepo implements OfferRepo {

	Long lastInsertId = 1L;
	Map<Long, Offer> offers = new HashMap<>();

	@Override
	public Offer find(Long id) {
		// TODO Auto-generated method stub
		return offers.get(id);
	}

	@Override
	public List<Offer> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<Offer>(offers.values());
	}

	@Override
	public void update(Offer entity) {
		offers.put(entity.getId(), entity);
	}

	@Override
	public Long insert(Offer entity) {
		// TODO Auto-generated method stub
		entity.setId(lastInsertId++);
		offers.put(entity.getId(), entity);

		return entity.getId();
	}

	@Override
	public void delete(Long id) {
		offers.remove(id);
	}

}
