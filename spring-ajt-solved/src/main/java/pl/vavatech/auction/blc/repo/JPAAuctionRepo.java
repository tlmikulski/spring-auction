package pl.vavatech.auction.blc.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Auction;

@Repository
public class JPAAuctionRepo implements AuctionRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	public Auction find(Long id) {
		return em.find(Auction.class, id);
	}

	@Override
	public List<Auction> findAll() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Auction> cq = qb.createQuery(Auction.class);
		cq.select(cq.from(Auction.class));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public Long insert(Auction auction) {
		em.persist(auction);
		return auction.getId();
	}

	@Override
	public void update(Auction auction) {
		em.persist(auction);
	}

	@Override
	public void delete(Long id) {
		em.remove(em.find(Auction.class, id));
	}

}
