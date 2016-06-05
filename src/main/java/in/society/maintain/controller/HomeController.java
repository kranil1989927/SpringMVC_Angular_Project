package in.society.maintain.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	/** Logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		LOGGER.debug("Successfully login to application, now redirecting to application home page");
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Locale locale, ModelMap model) {
		LOGGER.debug("Accessing to application home page");
		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "msg", required = false) String msg) {
		LOGGER.debug("Trying to login the application");
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if (msg != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdenied(Model model) {
		LOGGER.debug("Login to application is failed due to access control");
		return "redirect:/login?error=accessfailed";
	}

}
