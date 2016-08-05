package pl.vavatech.auction.www.controller.exhandler;

import org.springframework.stereotype.Component;

@Component
public class StrageMethodSecurityHandler {
	public boolean hasRight(boolean val) {
		return !val;
	}
}
