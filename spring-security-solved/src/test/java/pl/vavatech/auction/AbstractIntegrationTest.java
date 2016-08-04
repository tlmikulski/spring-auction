package pl.vavatech.auction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import pl.vavatech.auction.blc.BusinessConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
@ContextConfiguration(classes = BusinessConfig.class)
@TransactionConfiguration(defaultRollback = true)
public class AbstractIntegrationTest {
	@PersistenceContext
	private EntityManager em;

	protected Long count(Class entity) {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(entity)));
		return em.createQuery(cq).getSingleResult();
	}

	@Before
	public void setUp() throws Exception {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("a", "b"));
	}
}
