package pl.vavatech.auction.www;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.vavatech.auction.blc.service.AuctionService;

@Controller
public class IndexController {

	@Inject
	private AuctionService auctionService;

	@RequestMapping("/")
	private String hello(ModelMap model) {
		model.put("auctions", auctionService.findAll());
		return "index";
	}
}
