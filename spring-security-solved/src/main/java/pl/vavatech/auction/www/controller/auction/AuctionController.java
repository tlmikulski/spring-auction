package pl.vavatech.auction.www.controller.auction;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.model.AuctionType;
import pl.vavatech.auction.blc.model.Offer;
import pl.vavatech.auction.blc.service.AuctionService;
import pl.vavatech.auction.www.component.AuctionValidator;

@Controller
@RequestMapping("/auctions")
public class AuctionController {

	@Inject
	private AuctionService auctionService;
	@Inject
	AuctionValidator auctionValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
	}

	// TODO
	@RequestMapping
	private String list(ModelMap model) {
		model.put("auctions", auctionService.findAll());
		return "auction/list";
	}

	// TODO
	@RequestMapping("/{id}/show")
	private String show(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		model.put("offer", new Offer());
		return "auction/show";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	private String edit(ModelMap model, @PathVariable("id") Long id) {
		model.put("auction", auctionService.find(id));
		model.put("auctionTypes", AuctionType.values());
		return "auction/form";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	private String newAuction(ModelMap model) {
		model.put("auctionTypes", AuctionType.values());
		model.put("auction", new Auction());
		return "auction/form";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private String save(@Valid @ModelAttribute("auction") Auction auction,
			BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		auctionValidator.validate(auction, result);

		if (result.hasErrors()) {
			return "auction/form";
		}

		if (auction.getId() == null) {
			redirectAttributes.addFlashAttribute("msg", "Successfully added..");
			auctionService.insert(auction);
		} else {
			redirectAttributes.addFlashAttribute("msg",
					"Successfully updated..");
			auctionService.update(auction);
		}

		return "redirect:/auctions";
	}

	// TODO
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	private String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		auctionService.delete(id);
		redirectAttributes.addFlashAttribute("msg", "Successfully deleted..");
		return "redirect:/auctions";
	}

}
