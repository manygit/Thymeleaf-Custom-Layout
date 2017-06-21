package org.kshrd.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {
	
	@RequestMapping({"/","/dashboard",""})
	public String dashboard(ModelMap map){
		map.put("URL", "/admin");
		return "/admin/dashboard";
	}
	
}
