package by.naxa.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for going to the home page.
 */
@Controller
@Slf4j
public class HomeController {

	/**
	 * Selects the home page and populates the model.
	 */
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String home() {
		log.info("Welcome home!");
		return "redirect:/spring/student/list";
	}

}
