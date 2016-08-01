package pl.vavatech.auction.blc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.User;

@Service
public class InitializationService {
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void init() {
		em.persist(new User("Jan", "Kowalski"));
		em.persist(new User("Marek", "Nowak"));

		em.persist(new Auction("Dysk SSD"));
		em.persist(new Auction("DDR 3 8GB"));

	}

}
