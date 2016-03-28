package com.apefactory.forum.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.apefactory.forum.entity.User;
import com.apefactory.forum.service.UserService;

@Controller
public class LogInAndOutController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,User user){
		ModelAndView mav=new ModelAndView();
		User dbUser = userService.getByUserName(user.getUserName());
		mav.setViewName("forward:/login.jsp");
		if(dbUser == null){
			mav.addObject("errorMsg", "用户名不存在");
		}else if(!dbUser.getPassword().equals(user.getPassword())){
			mav.addObject("errorMsg", "用户名不存在");
		}else if(dbUser.getLocked()==User.USER_LOCK){
			mav.addObject("errorMsg", "用户已经锁定，不能登录");
		}else{
			setSessionUser(request, dbUser);
			mav.setViewName("redirect:/index.jsp");
		}
		
		
		
		
		return mav;
	}
}
