package pl.vavatech.auction.blc;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.User;
import pl.vavatech.auction.blc.service.AuctionService;

@Service
public class InitializationService {
	@PersistenceContext
	private EntityManager em;
	@Inject
	AuctionService service;

	@Transactional
	public void init() {
		em.persist(new User("Jan", "Kowalski"));
		em.persist(new User("Marek", "Nowak"));

		service.save(new Auction("Dysk SSD"));
		service.save(new Auction("DDR 3 8GB"));

	}

}
