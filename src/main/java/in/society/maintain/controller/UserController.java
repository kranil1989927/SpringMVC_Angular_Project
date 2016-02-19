package in.society.maintain.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.service.UserDetailService;
import in.society.maintain.service.UserDetailsVO;
import in.society.maintain.service.SocUserDetailsVO;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserControllerHelper userControllerHelper;

	@Autowired
	private UserDetailService userDetailService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("socUserFormBean") SocUserFormBean socUserFormBean) {
		String userName = null;
		System.out.println(socUserFormBean.getStartDate());
		System.out.println(socUserFormBean.getEndDate());
		System.out.println(socUserFormBean.getIsOwner());
		System.out.println(socUserFormBean.getFirstName());
		System.out.println(socUserFormBean.getLastName());
		try {
			SocUserDetailsVO socUserVO = userControllerHelper.populateUsersDetailsVO(socUserFormBean);
			userName = userDetailService.addSocUser(socUserVO);
			System.out.println("User ADDED Sucessfuly : " + userName);
		} catch (SocietyMaintenanceException e) {
			System.out.println("User ADDED Sucessfuly" + e.getMessage());
		}
		return "home";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUsers(@ModelAttribute("socUserFormBean") SocUserFormBean socUserFormBean) {
		// model.addAttribute(new UserDetailsFormBean());
		return "adduser";
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String editUsers(Model model) {
		return "editUser";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateUser(Model model) {

		return null;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public String getUser(Model model) {
		return null;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteUser(Model model) {
		return null;
	}

	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public String getAllUsers(ModelMap model) {
		try {
			List<UserDetailsVO> userDetailVOList = userDetailService.getAllUsers();
			List<UserDetailsFormBean> userDetailFormBeanList = userControllerHelper.populateUserDetailsFormBeanVOList(userDetailVOList);
			model.addAttribute("userDetailList", userDetailFormBeanList);

		} catch (SocietyMaintenanceException ex) {
			LOGGER.error("Exception of getting all the users due to {}", ex.getMessage());
		} catch (Exception ex) {
			LOGGER.error("Exception of getting all the users due to {}", ex.getMessage());
		}
		return "viewallusers";
	}
}
