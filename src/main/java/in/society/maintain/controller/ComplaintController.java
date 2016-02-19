package in.society.maintain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.society.maintain.common.SocietyMaintenanceException;
import in.society.maintain.service.ComplaintDetailService;
import in.society.maintain.service.ComplaintDetailsVO;
@Controller
@RequestMapping("/complaint")
public class ComplaintController {
	
	@Autowired
	private ComplaintControllerHelper complaintControllerHelper;
	
	@Autowired
	private ComplaintDetailService complaintDetailService;
	
	@RequestMapping(value="/raise", method = RequestMethod.POST)
	public String raiseComplaint(@ModelAttribute("complaintDetailsFormBean") ComplaintDetailsFormBean complaintDetailsFormBean) {
		String userName= null;
		try {
			ComplaintDetailsVO complaintDetailsVO = complaintControllerHelper.populateComplaintDetailsVO(complaintDetailsFormBean);
			System.out.println("in  raiseComplaint Controller");
			userName = complaintDetailService.raiseComplaint(complaintDetailsVO);
			System.out.println("Complaint ADDED Sucessfuly : " + userName);
		} catch (SocietyMaintenanceException e) {
			System.out.println("Complaint ADDED Sucessfuly" +  e.getMessage());
		}
		return "home";
	}
	
	@RequestMapping(value="/raiseComplaint", method = RequestMethod.GET)
	public String addUsers(Model model) {
		model.addAttribute(new ComplaintDetailsFormBean());
		/*HashMap<Integer, String> states = new HashMap<Integer, String>();
		states.put(1, "Alabama");
		states.put(2, "Alaska");
		states.put(3, "Arizona");
		states.put(4, "Arkansas");
		states.put(5, "California");*/
		//model.addAllAttributes((Collection<?>) states);
		return "raisecomplaint";
	}
	@RequestMapping(value="/editUser", method = RequestMethod.GET)
	public String editUsers(Model model) {
		return "editUser";
	}
	

	@RequestMapping(value="/edit",method = RequestMethod.POST)
	public String updateUser(Model model) {
		
		return null;
	}
	@RequestMapping(value="/getUser",method = RequestMethod.GET)
	public String getUser(Model model) {
		return null;
	}
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public String deleteUser(Model model) {
		return null;
	}
	@RequestMapping(value="/getAllComplaints",method = RequestMethod.GET)
	public ModelAndView  getAllComplaints() throws SocietyMaintenanceException {
		List<ComplaintDetailsVO> complaintDetailsVOList=complaintDetailService.getAllComplaints();
		List<ComplaintDetailsFormBean>  complaintDetailsFormBeanList=complaintControllerHelper.populateComplaintDetailsFormBeanList(complaintDetailsVOList);
		ModelAndView model = new ModelAndView("viewallcomplaints");
		model.addObject("complaintDetailsFormBeanList", complaintDetailsFormBeanList);
		return model;
	}
}
