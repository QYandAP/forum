package com.apefactory.forum.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringMVCTest {
	@RequestMapping("springmvctest")
	public String helloWeb(){
		return "helloweb";
	}
}
