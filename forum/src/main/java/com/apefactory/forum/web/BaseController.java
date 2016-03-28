package com.apefactory.forum.web;

import javax.servlet.http.HttpServletRequest;

import com.apefactory.forum.cons.CommonConstant;
import com.apefactory.forum.entity.User;


public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";
	
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}
	
	protected void setSessionUser(HttpServletRequest request,User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT,
				user);
	}
   
}
