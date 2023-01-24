package com.abcjob.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.Job;
import com.abcjob.bean.User;
import com.abcjob.service.JobService;
import com.abcjob.service.UserService;

@Controller
public class JobController {
	@Autowired
	JobService jobService;
	
	@Autowired
	UserService userService;

	@GetMapping("/job")
	public ModelAndView job(HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		User user = (User) session.getAttribute("user");
		if(user != null) {
			List<Job> jobs = jobService.listAll();
			mav.addObject("jobs", jobs);
			mav.setViewName("job");
		}else {
			mav.setViewName("redirect:/login");
		}
		
		return mav;
	}
	
	@GetMapping("/job/{id}")
	public ModelAndView jobdetail(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		User user = (User) session.getAttribute("user");
		if(user != null) {
			Job job = jobService.get(id);
			
			if(user.getApplyJob()!=null) {
				if(user.getApplyJob().getId() == job.getId()) {
					mav.addObject("status", 1);
				}
			}
			
			mav.addObject("job", job);
			mav.setViewName("jobdetail");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@GetMapping("/job/{id}/apply")
	public ModelAndView applyjob(@PathVariable("id") Long id, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		
		User user = (User) session.getAttribute("user");
		if(user != null) {
			Job job = jobService.get(id);
			user.setApplyJob(job);
			userService.save(user);
			mav.setViewName("redirect:/job/{id}");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
