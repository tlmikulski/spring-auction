package pl.vavatech.auction.blc.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public List<Auction> findAll(FindCriteria criteria) {
		// CriteriaBuilder qb = em.getCriteriaBuilder();
		// CriteriaQuery<Auction> cq = qb.createQuery(Auction.class);
		// Root<Auction> from = cq.from(Auction.class);
		//
		// Predicate descriptionRes = qb.like(qb.lower(from.get("description")),
		// "%"
		// + criteria.getQuery().toLowerCase() + "%");
		// Predicate titleRes = qb.like(qb.lower(from.get("title")), "%"
		// + criteria.getQuery().toLowerCase() + "%");
		//
		// cq.where(qb.or(titleRes, descriptionRes));
		//
		// if (criteria.getOrderBy() != null) {
		// Path<Object> path = criteria.getOrderBy() == OrderBy.PRICE ?
		// from.get("currentPrice")
		// : from.get("expiryDate");
		//
		// cq.orderBy(criteria.getOrderDir() == OrderDir.ASC ? qb.asc(path) :
		// qb.desc(path));
		// }
		//
		// TypedQuery<Auction> query = em.createQuery(cq);
		// query.setMaxResults(criteria.getPageSize());
		// query.setFirstResult(criteria.getPage() * criteria.getPageSize());
		// return query.getResultList();
		String orderBy = "";
		if (criteria.getOrderBy() != null) {
			orderBy = criteria.getOrderBy() == OrderBy.PRICE ? "currentPrice " : "expiryDate ";

			orderBy += criteria.getOrderDir();
		}

		Query query = em
				.createQuery("FROM Auction WHERE LOWER(title) LIKE :title OR LOWER(description) LIKE :description ORDER BY "
						+ orderBy);
		query.setParameter("title", "%" + criteria.getQuery().toLowerCase() + "%");
		query.setParameter("description", "%" + criteria.getQuery().toLowerCase() + "%");

		query.setMaxResults(criteria.getPageSize());
		query.setFirstResult(criteria.getPage() * criteria.getPageSize());
		return query.getResultList();

	}

	@Override
	public Long insert(Auction auction) {
		em.persist(auction);
		return auction.getId();
	}

	@Override
	public void update(Auction auction) {
		em.merge(auction);
	}

	@Override
	public void delete(Long id) {
		em.remove(em.find(Auction.class, id));
	}

}
