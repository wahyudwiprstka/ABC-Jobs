package com.abcjob.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;
import com.abcjob.service.CommentService;
import com.abcjob.service.ThreadService;
import com.abcjob.bean.Comment;
import com.abcjob.bean.Thread;

@Controller
public class ThreadController {
	@Autowired
	UserService userService;
	
	@Autowired
	ThreadService threadService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/addThread")
	public ModelAndView addThread(HttpSession session) {
		ModelAndView mav = new ModelAndView("add-thread");
		if(session.getAttribute("user") != null) {
			mav.setViewName("add-thread");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@PostMapping("/addThreadProcess")
	public ModelAndView addThreadProcess(@ModelAttribute("addthread")Thread thread, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/thread");
		if(session.getAttribute("user") != null) {
			Thread t = new Thread();
			Set<Thread> threads = new HashSet<Thread>();
			User u = new User();
			u = (User) session.getAttribute("user");
			t = thread;
			t.setUser(u);
			threads.add(t);
			u.setThread(threads);
			userService.save(u);
			threadService.save(t);
			mav.setViewName("redirect:/thread");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@GetMapping("/thread")
	public ModelAndView thread(HttpSession session) {
		ModelAndView mav = new ModelAndView("add-thread");
		if(session.getAttribute("user") != null) {
			mav.setViewName("thread");
			List<Thread> threads = threadService.listAll();
			List<Comment> comments = commentService.listAll();
			mav.addObject("threads", threads);
			mav.addObject("comments", comments);
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
