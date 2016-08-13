package pl.vavatech.auction.www.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.service.AuctionService;
import pl.vavatech.auction.www.AbstractWebIntegrationTest;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class AuctionRestTest extends AbstractWebIntegrationTest {
	@Inject
	AuctionService service;

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void shouldFindAccounsByRest() throws Exception {
		long count = count(Auction.class);

		Auction auction = new Auction("Laptop");

		// when
		service.insert(auction);

		String contentAsString = this.mockMvc.perform(get("/rest/auctions").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andReturn().getResponse().getContentAsString();

		// then
		List value = ob.readValue(contentAsString, List.class);
		assertThat(value).hasSize((int) (count + 1));

	}

}
