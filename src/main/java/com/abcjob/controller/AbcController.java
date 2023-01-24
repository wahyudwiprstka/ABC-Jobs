package com.abcjob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;
import com.abcjob.service.UserRepository;

@Controller
public class AbcController {
	@Autowired
	UserService abcService;
	
	@GetMapping("/")
	public ModelAndView home(HttpSession session) {
		ModelAndView mav = new ModelAndView("home");
		User user = (User) session.getAttribute("user");
		mav.addObject("u", user);
		return mav;
	}
	
	@GetMapping("/profile")
	public ModelAndView profile(HttpSession session) {
		ModelAndView mav = new ModelAndView("profile");
		if(session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			mav.addObject("u", user);
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
