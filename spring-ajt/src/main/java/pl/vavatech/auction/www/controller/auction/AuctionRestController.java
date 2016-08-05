package pl.vavatech.auction.www.controller.auction;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.service.AuctionService;

@RestController
@RequestMapping("/rest/auctions")
public class AuctionRestController {

	@Inject
	private AuctionService auctionService;

	@RequestMapping
	private List<Auction> all() {
		return auctionService.findAll();
	}

	@RequestMapping("/insert")
	private ResponseEntity<Long> add(@RequestBody @Valid Auction auction) {
		auctionService.insert(auction);
		return ResponseEntity.status(HttpStatus.CREATED).body(auction.getId());
	}

	@RequestMapping("/update")
	private ResponseEntity<Void> update(@RequestBody Auction auction) {
		auctionService.update(auction);
		return ResponseEntity.ok().build();
	}

	@RequestMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	private void delete(@RequestParam("id") Long id) {
		auctionService.delete(id);
	}
}
