package pl.vavatech.auction.www.controller.offer;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.vavatech.auction.blc.service.OfferService;

@RestController
@RequestMapping("/rest/offers")
public class OfferRestController {
	@Inject
	OfferService offerService;

	@RequestMapping
	private ResponseEntity<Long> add(@RequestBody @Valid OfferDto offer) {
		Long insert = offerService.insert(offer);
		return ResponseEntity.status(HttpStatus.CREATED).body(insert);
	}
}
