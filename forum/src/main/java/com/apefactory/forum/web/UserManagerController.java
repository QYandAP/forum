package com.apefactory.forum.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.apefactory.forum.entity.User;
import com.apefactory.forum.service.UserService;

@Controller
public class UserManagerController extends BaseController {

	@Resource
	private UserService userService;
	
	@RequestMapping("usersmanager")
	public ModelAndView listAllUsers() {
		ModelAndView view = new ModelAndView();
		List<User> users = userService.getAllUser();
		view.addObject("users", users);
		view.setViewName("listAllUsers");
		return view;
	}
	
	@RequestMapping(value = "usersmanager/deleteusers", method = RequestMethod.GET)
	public String deleteUsers(@RequestParam("userIds") String userIds){
		String[] arrIds=userIds.split(",");
		for(int i=0;i<arrIds.length;i++){
			System.out.println(arrIds[i]);
			userService.deleteByUserId(Integer.parseInt(arrIds[i]));
		}
		return "redirect:/usersmanager";
	}
	
	@RequestMapping("usersmanager/updateform")
	public ModelAndView  updateUser(@RequestParam("userId") Integer userId){
		
		ModelAndView view = new ModelAndView();
		view.addObject("user", userService.getByUserId(userId));
		view.setViewName("updateUserForm");
		return view;
	}
	
	@RequestMapping("usersmanager/updateuser")
	public String updateUser(HttpServletRequest request,User user){
		userService.updateUser(user);
		return "redirect:/usersmanager";
	}
	
	@RequestMapping("usersmanager/addform")
	public String addForm(){
		return "addUserForm";
	}
	
	@RequestMapping("usersmanager/saveuser")
	public String saveUser(HttpServletRequest request,User user){
		userService.saveUser(user);
		return "redirect:/usersmanager";
	}
}
