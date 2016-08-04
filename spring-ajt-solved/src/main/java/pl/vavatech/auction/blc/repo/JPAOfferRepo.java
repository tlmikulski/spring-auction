package pl.vavatech.auction.blc.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Offer;

@Repository
public class JPAOfferRepo implements OfferRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	public Offer find(Long id) {
		return em.find(Offer.class, id);
	}

	@Override
	public List<Offer> findAll() {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Offer> cq = qb.createQuery(Offer.class);
		cq.select(cq.from(Offer.class));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public Long insert(Offer auction) {
		em.persist(auction);
		return auction.getId();
	}

	@Override
	public void update(Offer auction) {
		em.merge(auction);
	}

	@Override
	public void delete(Long id) {
		em.remove(em.find(Offer.class, id));
	}

}
