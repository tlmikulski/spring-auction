package pl.altkom.spring.operator;

import static org.fest.assertions.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.altkom.spring.BaseIntegrationTest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebAppConfiguration
@IntegrationTest("server.port=0")
public class OperatorResourceTest extends
		BaseIntegrationTest {
	@Inject
	OperatorRepo repo;
	@Inject
	OperatorRestWebService rest;
	@Inject
	ObjectMapper mapper;

	private MockMvc resourceMockMvc;

	@Before
	public void setup() {
		this.resourceMockMvc = MockMvcBuilders
				.standaloneSetup(rest).alwaysDo(print())
				.build();
	}

	@Value("${local.server.port}")
	int port;

	@Test
	public void shouldRetrunOperatorsEmptyList()
			throws Exception {
		// when
		MvcResult result = resourceMockMvc
				.perform(get("/operators"))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.contentTypeCompatibleWith(
										MediaType.APPLICATION_JSON))
				.andReturn();

		// then
		List<Operator> operators = toOperatorList(result);
		assertThat(operators).isEmpty();
	}

	@Test
	public void shouldRetrunOperators() throws Exception {
		// given
		Operator operator = new Operator();
		operator.setLogin("j");
		repo.save(operator);

		// when
		MvcResult result = resourceMockMvc
				.perform(get("/operators"))
				.andExpect(status().isOk())
				.andExpect(
						content()
								.contentTypeCompatibleWith(
										MediaType.APPLICATION_JSON))
				.andReturn();

		// then
		List<Operator> operators = toOperatorList(result);
		assertThat(operators).isNotEmpty();
	}

	private List<Operator> toOperatorList(MvcResult result)
			throws IOException, JsonParseException,
			JsonMappingException,
			UnsupportedEncodingException {
		return mapper.readValue(result.getResponse()
				.getContentAsString(),
				new TypeReference<List<Operator>>() {
				});
	}
}
