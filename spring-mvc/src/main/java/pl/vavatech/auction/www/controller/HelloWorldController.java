package pl.vavatech.auction.www.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.vavatech.auction.blc.model.Auction;

@Controller
public class HelloWorldController {
	@RequestMapping("/helloWorld")
	public String hello(Map model) {
		model.put("message", "hello1");

		return "helloWorld";
	}

	@RequestMapping("/helloWorld/{month}/{type}")
	public String helloParams(Map model, @PathVariable("month") Integer month, @PathVariable("type") String type,
			@RequestParam(value = "page", required = true) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) throws Exception {
		model.put("month", month);
		model.put("type", type);
		model.put("page", page);
		model.put("pageSize", pageSize);

		throw new Exception("Aaab");
		// return "helloWorld";
	}

	@RequestMapping("/helloWorld/add")
	public String helloAdd(Map model, @Valid Auction auction, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Bad auction type");
		}
		model.put("auction", auction);
		return "auction/show";
	}
}
