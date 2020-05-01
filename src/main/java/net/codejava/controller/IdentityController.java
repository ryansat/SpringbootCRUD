package net.codejava.controller;

import org.springframework.stereotype.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.model.Identity;
import net.codejava.service.IdentityService;
@Controller
public class IdentityController {
	@Autowired
	private IdentityService service; 
	
	@RequestMapping("/identity")
	public String viewHomePage(Model model) {
		List<Identity> listIdentitys = service.listAll();
		model.addAttribute("listIdentitys", listIdentitys);
		
		return "list_identity";
    }
    
    @RequestMapping("/new_identity")
	public String showNewIdentityPage(Model model) {
		Identity identity = new Identity();
		model.addAttribute("identity", identity);
		
		return "new_identity";
	}
	
	@RequestMapping(value = "/save_identity", method = RequestMethod.POST)
	public String saveIdentity(@ModelAttribute("identity") Identity identity) {
		service.save(identity);
		
		return "redirect:/identity";
	}
	
	@RequestMapping("/edit_identity/{id}")
	public ModelAndView showEditIdentityPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_identity");
		Identity identity = service.get(id);
		mav.addObject("identity", identity);
		
		return mav;
	}
	
	@RequestMapping("/delete_identity/{id}")
	public String deleteIdentity(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/identity";		
	}
}