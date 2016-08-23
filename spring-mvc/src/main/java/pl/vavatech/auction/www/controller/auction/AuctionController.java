package pl.vavatech.auction.www.controller.auction;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.AuctionType;
import pl.vavatech.auction.blc.service.AuctionService;

@RequestMapping("/auctions")
@Controller
public class AuctionController {

	@Inject
	private AuctionService auctionService;

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	private String edit(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		// model.put("auctionTypes", AuctionType.values());
		return "auction/form";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	private String newAuction(ModelMap model) {
		model.put("auctionTypes", AuctionType.values());
		model.put("auction", new Auction());
		return "auction/form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private String save(@Valid @ModelAttribute("auction") Auction auction, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			return "auction/form";
		}

		if (auction.getId() == null) {
			redirectAttributes.addFlashAttribute("msg", "Successfully added..");
			auctionService.insert(auction);
		} else {
			redirectAttributes.addFlashAttribute("msg", "Successfully updated..");
			auctionService.update(auction);
		}

		return "redirect:/auctions";
	}

	@RequestMapping(value = "/{auctionId}/show")
	private String show(Map model, @PathVariable("auctionId") Long auctionId) {
		Auction auction = auctionService.find(auctionId);
		model.put("auction", auction);
		return "auction/show";
	}

	@RequestMapping(value = "/list")
	private String list(Map model) {
		List<Auction> allAuctions = auctionService.findAll();
		model.put("auctions", allAuctions);

		return "auction/list";
	}

	@RequestMapping(value = "/{auctionId}/delete")
	private String delete(Map model, @PathVariable("auctionId") Long auctionId) {
		auctionService.delete(auctionId);

		return "redirect:/auctions/list";
	}
}
