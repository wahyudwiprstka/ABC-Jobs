package com.abcjob.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;

@Controller
public class UpdateController {
	@Autowired
	UserService abcService;
	
	@GetMapping("/update-profile")
	public ModelAndView update(HttpSession session) {
		ModelAndView mav = new ModelAndView("update-profile");
		User user = (User) session.getAttribute("user");
		mav.addObject("u", user);
		return mav;
	}
	
	@PostMapping("/updateProcess")
	public ModelAndView updateProcess(HttpSession session, @ModelAttribute("update") User user) {
		User u = (User) session.getAttribute("user");
		u.setFirstname(user.getFirstname());
		u.setLastname(user.getLastname());
		u.setAddress(user.getAddress());
		u.setPhonenumber(user.getPhonenumber());
		u.setCompany(user.getCompany());
		u.setBirth(user.getBirth());
		abcService.save(u);
		session.setAttribute("user", u);
		ModelAndView mav = new ModelAndView("redirect:/profile");
		return mav;
	}
}
