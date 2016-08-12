package pl.altkom.spring.operator;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class OperatorService {
	@Inject
	OperatorRepo repo;

	public String getName(String login) {
		Operator operator = repo.findByLogin(login);
		return operator.getFirstName() + operator.getLastName();
	}
}
