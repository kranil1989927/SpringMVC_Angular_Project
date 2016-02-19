package in.society.maintain.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.model.Module;
import in.society.maintain.service.ModuleService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value = "error", required = false) String error, @RequestParam(value = "msg", required = false) String msg) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
		if(msg != null){
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessdenied(Model model) {
		return "redirect:/login?error=accessfailed";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Locale locale, ModelMap model) {
		try {
			List<Module> modulelist = moduleService.getAllTopModules("ADMIN_ROLE");
			model.addAttribute("modulelist", modulelist);
		} catch (SocietyMaintenanceException e) {
			e.printStackTrace();
		}
		return "home";
	}
}