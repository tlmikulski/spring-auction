package pl.vavatech.auction.blc.repo;

import java.util.List;

import pl.vavatech.auction.blc.model.Offer;

public interface OfferRepo {
	Offer find(Long id);

	List<Offer> findAll();

	void update(Offer entity);

	Long insert(Offer entity);

	void delete(Long id);
}
