package org.kshrd.controller;

import org.kshrd.model.RoleModel;
import org.kshrd.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class RoleController {

	private RoleService roleService;
	
	@Autowired
	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}
	
	@RequestMapping("/role-list")
	public String roleList(ModelMap map){
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "/admin/role-list";
	}
	
	@RequestMapping("/role-form")
	public String roleForm(ModelMap map){
		RoleModel roleModel = new RoleModel();
		roleModel.setId(roleService.getNextRoleIdToInsert());
		map.put("ROLE", roleModel);
		map.put("URL","/admin/role-form");
		map.put("ACTION", "/admin/add-role");
		return "/admin/role-cu";
	}
	
	@RequestMapping("/role-update-form")
	public String roleUpdateForm(@RequestParam int id, ModelMap map){
		map.put("ROLE", roleService.findRoleById(id));
		map.put("URL","/admin/role-update-form");
		map.put("ACTION", "/admin/update-role");
		return "/admin/role-cu";
	}
	
	@RequestMapping("/add-role")
	public String addUser(@ModelAttribute RoleModel roleModel, ModelMap map){
		roleService.addRole(roleModel);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
	@RequestMapping("/update-role")
	public String updateRole(@ModelAttribute RoleModel role, ModelMap map){
		roleService.updateRole(role);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
	@RequestMapping("/delete-role")
	public String deleteUser(@RequestParam int id, ModelMap map){
		roleService.deleteRole(id);
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/role-list");
		return "redirect:/admin/role-list";
	}
	
}
