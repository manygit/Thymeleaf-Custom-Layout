package org.kshrd.controller;

import java.util.ArrayList;
import java.util.List;

import org.kshrd.model.UserModel;
import org.kshrd.services.RoleService;
import org.kshrd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	private UserService userService;
	private RoleService roleService;
	
	@Autowired
	public UserController(UserService userService, RoleService roleService) {
		this.userService = userService;
		this.roleService = roleService;
	}
	
	@RequestMapping("/user-list")
	public String userList(ModelMap map){
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "/admin/user-list";
	}
	
	@RequestMapping("/user-form")
	public String userForm(ModelMap map){
		UserModel userModel = new UserModel();
		userModel.setId(userService.getNextUserIdToInsert());
		map.put("USER", userModel);
		map.put("URL","/admin/user-form");
		map.put("ROLE", roleService.getAllRole());
		map.put("ACTION", "/admin/add-user");
		return "/admin/user-cu";
	}
	
	@RequestMapping("/user-update-form")
	public String userUpdateForm(@RequestParam int id, ModelMap map){
		map.put("USER", userService.findUserById(id));
		map.put("ROLE", roleService.getAllRole());
		map.put("URL","/admin/user-update-form");
		map.put("ACTION", "/admin/update-user");
		return "/admin/user-cu";
	}
	
	@RequestMapping(value="/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute UserModel userModel, ModelMap map){
		userService.addUser(userModel);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping(value="/update-user" , method = RequestMethod.POST)
	public String updateUser(@ModelAttribute UserModel user, ModelMap map){
		userService.updateUser(user);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, ModelMap map){
		userService.deleteUser(id);
		map.put("USER", userService.getAllUser());
		map.put("URL","/admin/user-list");
		return "redirect:/admin/user-list";
	}
	
	@RequestMapping(value="/search-user")
	public String findUserById(@RequestParam(required=true,defaultValue="0") String idorname, ModelMap map){
		int validId = isId(idorname);
		if(validId > 0){
			List<UserModel> userList = new ArrayList<>();
			userList.add(userService.findUserById(validId));
			map.put("USER", userList);
		}else{
			map.put("USER", userService.findAllUserByName(idorname));
		}
		map.put("URL","/admin/user-list");
		return "/admin/user-list";
	}
	
	
	private int isId(String id){
		try{
			return Integer.parseInt(id);
		}catch(Exception ex){
			return -1;
		}
	}
	
}
