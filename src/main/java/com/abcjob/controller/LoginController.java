package com.abcjob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService abcService;
	
	@GetMapping("/login")
	public ModelAndView login(HttpSession session) {
		ModelAndView mav = new ModelAndView("login");
		if(session.getAttribute("user") == null) {
			mav.setViewName("login");
		}else{
			mav.setViewName("redirect:/profile");
		}
		return mav;
	}
	
	@PostMapping("/loginProcess")
	public ModelAndView loginProcess(HttpSession session, @RequestParam("email") String email,
			@RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("login");
		User user = abcService.getUserByEmail(email);
			if(user != null) {
				if(password.equals(user.getPassword())) {
					session.setAttribute("user", user);
					session.setMaxInactiveInterval(3600);
					mav.setViewName("redirect:/profile");
				}else {
					mav.setViewName("login");
					mav.addObject("msg", "You enterred wrong password!");
				}
			}else {
				mav.setViewName("login");
				mav.addObject("msg", "You enterred wrong email!");
			}
		return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/login");
		session.invalidate();
		return mav;
	}

}
