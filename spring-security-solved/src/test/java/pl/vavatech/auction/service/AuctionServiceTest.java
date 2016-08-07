package pl.vavatech.auction.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.vavatech.auction.AbstractIntegrationTest;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.service.AuctionService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuctionServiceTest extends AbstractIntegrationTest {
	@Inject
	AuctionService service;

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private WebApplicationContext wac;
	@Autowired
	ObjectMapper ob;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void getAccount() throws Exception {
		Auction auction = new Auction("Laptop");

		// when
		service.insert(auction);

		String contentAsString = this.mockMvc
				.perform(
						get("/rest/auctions")
								.accept(MediaType
										.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(
						content().contentTypeCompatibleWith("application/json"))
				.andReturn().getResponse().getContentAsString();

		List value = ob.readValue(contentAsString, List.class);

		assertThat(value).hasSize(2);

	}

	@Test
	public void shouldAddAuction() throws Exception {
		// given
		Long auctionCount = count(Auction.class);

		Auction auction = new Auction("Laptop");

		// when
		service.insert(auction);

		// then
		assertThat(count(Auction.class)).isGreaterThan(auctionCount);
	}

	@Test
	public void shouldUpdateAuction() throws Exception {
		// given
		Long auctionCount = count(Auction.class);
		Long auctionId = service.insert(new Auction("Laptop"));

		// when
		Auction auction = service.find(auctionId);
		auction.setTitle("new title");
		service.update(auction);

		// then
		assertThat(count(Auction.class)).isGreaterThan(auctionCount);
	}
}
