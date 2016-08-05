package pl.vavatech.auction.www.component;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import pl.vavatech.auction.blc.model.Auction;

@Component
public class AuctionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Auction.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Auction auction = (Auction) target;
		if (auction.getExpiryDate() != null
				&& auction.getExpiryDate().isBefore(LocalDateTime.now())) {
			errors.reject("auction.out.of.date");
		}

	}

}
