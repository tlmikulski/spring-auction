package pl.vavatech.auction.www.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.vavatech.auction.blc.model.Auction;

@Controller
public class HelloWorldController {
	@RequestMapping("/helloWorld/{month}/{type}")
	public ModelAndView hello(@PathVariable("month") Integer month,
			@PathVariable("type") String type,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "pageSize", required = false) Integer pageSize) {

		ModelAndView modelAndView = new ModelAndView("helloWorld");
		modelAndView.addObject("message", "Hello");
		modelAndView.addObject("month", month);
		modelAndView.addObject("type", type);
		modelAndView.addObject("page", page);
		modelAndView.addObject("pageSize", pageSize);

		return modelAndView;
	}

	@RequestMapping("/helloWorld")
	public ModelAndView hello() {

		ModelAndView modelAndView = new ModelAndView("helloWorld");
		modelAndView.addObject("message", "Hello");

		return modelAndView;
	}

	@RequestMapping("/helloWorld/add")
	public ModelAndView add(@ModelAttribute @Valid Auction auction, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException(bindingResult.toString());
		}

		ModelAndView modelAndView = new ModelAndView("helloWorld");
		modelAndView.addObject("auction", auction);

		return modelAndView;
	}

}
