package pl.altkom.spring.operator;

import static org.fest.assertions.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import pl.altkom.spring.BaseIntegrationTest;

public class OperatorRepositoryTest extends
		BaseIntegrationTest {
	@Inject
	OperatorRepo repo;

	@Test
	public void shouldAddOperator() throws Exception {
		// given
		Operator operator = new Operator();
		operator.setLogin("j");

		long currentCount = repo.count();

		// when
		repo.save(operator);

		// then
		assertThat(repo.count())
				.isEqualTo(currentCount + 1);
	}

}
