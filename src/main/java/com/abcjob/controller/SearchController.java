package com.abcjob.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;

@Controller
public class SearchController {
	@Autowired
	UserService abcService;
	
	@GetMapping("/search")
	public ModelAndView search(HttpSession session) {
		ModelAndView mav = new ModelAndView("search");
		User user = (User) session.getAttribute("user");
		if(session.getAttribute("user") != null) {
			mav.setViewName("search");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@GetMapping("/result")
	public ModelAndView searchResult(HttpSession session, @RequestParam("searchVal") String searchVal) {
		ModelAndView mav = new ModelAndView("search-result");
		if(session.getAttribute("user") != null) {
			mav.addObject("searchVal", searchVal);
			List<User> listUser = abcService.search(searchVal);
			mav.addObject("listUser", listUser);
			mav.setViewName("search-result");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@GetMapping("/search-profile")
	public ModelAndView searchProfile(HttpSession session, @RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("profile-search");
		if(session.getAttribute("user") != null) {
			User user = abcService.get(id);
			mav.addObject("u", user);
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
