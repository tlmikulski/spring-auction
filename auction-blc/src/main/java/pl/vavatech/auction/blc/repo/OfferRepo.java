package pl.vavatech.auction.blc.repo;

import pl.vavatech.auction.blc.model.Offer;

public interface OfferRepo {
	Offer find(Long id);

	Long insert(Offer auction);

	void update(Offer auction);

	void delete(Long id);
}
