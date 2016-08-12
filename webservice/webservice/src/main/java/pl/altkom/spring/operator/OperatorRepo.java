package pl.altkom.spring.operator;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepo extends JpaRepository<Operator, Long> {

	Operator findByLogin(String login);

}
