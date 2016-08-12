package pl.altkom.spring.operator;

import static org.fest.assertions.Assertions.assertThat;

import javax.inject.Inject;

import org.junit.Test;

import pl.altkom.spring.BaseIntegrationTest;

public class OperatorServiceTest extends BaseIntegrationTest {
	@Inject
	OperatorService service;
	@Inject
	OperatorRepo repo;

	@Test
	public void shouldAddReservedCode() throws Exception {
		// given
		String login = "jan.k";

		Operator operator = new Operator();
		operator.setLogin(login);
		operator.setFirstName("Jan");
		operator.setLastName("Kowalski");
		repo.save(operator);

		// when
		String name = service.getName(login);

		// then
		assertThat(name).isNotEmpty();
	}

}
