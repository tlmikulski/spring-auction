package pl.altkom.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.altkom.spring.operator.Operator;

@Controller
@RequestMapping("/add")
public class AddController {
	@RequestMapping(method = RequestMethod.GET)
	public String prepare(Long id) {
		return "add";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String process(Operator operator,
			RedirectAttributes redirect) {
		redirect.addFlashAttribute("info",
				"Dodalem operatora ");
		return "redirect:home";
	}
}
