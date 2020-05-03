package net.codejava.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @Autowired
	
	@RequestMapping("/")
    public String root() {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            boolean hasUserRole = authentication.getAuthorities().stream()
                      .anyMatch(r -> r.getAuthority().equals("ADMIN"));
            if (hasUserRole == true){
                return "list_product";
            }else{
                return "list_identity";
            }
                   
        }
        catch(Exception e){
        }
        return "list_identity";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex(Model model) {
        return "list_identity";
    }
}
