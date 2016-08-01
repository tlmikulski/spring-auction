package pl.vavatech.auction.www.auction;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.vavatech.auction.blc.service.AuctionService;

@RequestMapping("/auctions")
@Controller
public class AuctionController {

	@Inject
	private AuctionService auctionService;

	@RequestMapping
	private String list(ModelMap model) {
		model.put("auctions", auctionService.findAll());
		return "auction/list";
	}

	@RequestMapping("/{id}/edit")
	private String edit(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		return "auction/form";
	}

	@RequestMapping("/{id}/show")
	private String show(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		return "auction/show";
	}
}
