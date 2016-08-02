package pl.vavatech.auction.www.controller.auction;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.AuctionType;
import pl.vavatech.auction.blc.model.Offer;
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

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	private String edit(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		model.put("auctionTypes", AuctionType.values());
		return "auction/form";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	private String save(@Valid @ModelAttribute("auction") Auction auction,
			BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "auction/form";
		}
		if (auction.getId() == null) {
			auctionService.save(auction);
		} else {
			auctionService.update(auction);
		}
		System.out.println(auction);
		return "redirect:/auctions";
	}

	@RequestMapping("/{id}/show")
	private String show(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		model.put("offer", new Offer());
		return "auction/show";
	}
}
