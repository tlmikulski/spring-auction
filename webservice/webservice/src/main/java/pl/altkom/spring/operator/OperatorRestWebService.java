package pl.altkom.spring.operator;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Api(value = "Servics operatoroe")
@RestController
@RequestMapping("/operators")
public class OperatorRestWebService {
	@Inject
	OperatorRepo repo;

	@ApiOperation("Pobierz wszystki")
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Operator> findAll() {
		return repo.findAll();
	}

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void add(@Valid @RequestBody Operator operator) {
		System.out.println(operator);
	}
}
