package pl.vavatech.auction.www;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
@Transactional(readOnly = false)
@Rollback
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class AbstractWebIntegrationTest {
	@PersistenceContext
	private EntityManager em;

	protected ObjectMapper ob = new ObjectMapper();

	protected Long count(Class entity) {
		CriteriaBuilder qb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = qb.createQuery(Long.class);
		cq.select(qb.count(cq.from(entity)));
		return em.createQuery(cq).getSingleResult();
	}

	@Before
	public void setUp() throws Exception {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("admin",
				"password");
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
