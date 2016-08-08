package pl.vavatech.auction.blc.repo;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

@Repository
public class AutoAuctionRepoImpl implements CounterRepo {
	@Inject
	EntityManager em;

	@Override
	public Long c() {
		// CriteriaBuilder qb = em.getCriteriaBuilder();
		// CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		// cq.select(qb.count(cq.from(entity)));
		// return em.createQuery(cq).getSingleResult();
		return 0L;
	}

}
