package com.abcjob.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.Job;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;
import com.abcjob.service.CommentService;
import com.abcjob.service.JobService;
import com.abcjob.service.ThreadService;
import com.abcjob.service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	ThreadService threadService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/admin")
	public ModelAndView admin(HttpSession session) {
		ModelAndView mav = new ModelAndView("admin");
		User user = (User) session.getAttribute("user");
		if(user != null) {
			if(user.getAdmin() == 1) {
				List<User> listUser = userService.listAll();
				mav.addObject("listUser", listUser);
				mav.setViewName("admin");
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
//	Edit
	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam("id") Long id, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/");
		User user = (User) session.getAttribute("user");
		if(user != null) {
			if(user.getAdmin() == 1) {
				User u = userService.get(id);
				mav.addObject("u", u);
				mav.setViewName("edit-admin");
				session.setAttribute("editid", id);
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@PostMapping("/editProcess")
	public ModelAndView editProcess(@ModelAttribute("edit") User user, HttpSession session) {
		Long id = (Long) session.getAttribute("editid");
		ModelAndView mav = new ModelAndView("redirect:/admin");
		
		user.setId(id);
		
		userService.save(user);
		return mav;
	}
	
//	Delete
	@GetMapping("/delete-user")
	public ModelAndView delete(@RequestParam("id")Long id) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		User user = userService.get(id);
		threadService.deleteByUserFK(user);
		commentService.deleteByUserFK(user);
		userService.delete(id);
		return mav;
	}
	
//	Add
	@GetMapping("/add")
	public ModelAndView add(HttpSession session) {
		ModelAndView mav = new ModelAndView("add-user");
		if(session.getAttribute("user")!=null) {	
			mav.setViewName("add-user");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	@PostMapping("/addProcess")
	public ModelAndView addProcess(@ModelAttribute("add") User user) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		String email = user.getEmail();
		if(userService.getUserByEmail(email) == null) {
			userService.save(user);
		}else {
			mav.setViewName("add-user");
			mav.addObject("msg", "Email already registered!");
		}
		return mav;
	}
	
//	Add Job Controller
	@GetMapping("/addjob")
	public ModelAndView addjob(HttpSession session) {
		ModelAndView mav = new ModelAndView("add-job");
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			if(user.getAdmin()==1) {
				mav.setViewName("add-job");
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
//	Add Job Process Controller
	@PostMapping("/addjobProcess")
	public ModelAndView addjobProcess(@ModelAttribute("addjob") Job job) {
		ModelAndView mav = new ModelAndView("redirect:/admin");
		jobService.save(job);
		return mav;
	}
	
//	Apply Job List
	@GetMapping("/applyjobList")
	public ModelAndView applyjobList(HttpSession session) {
		ModelAndView mav = new ModelAndView("applyjob-list");
		User user = (User) session.getAttribute("user");
		if(user!=null) {
			if(user.getAdmin()==1) {
				List<User> userApplyList = userService.listApplyJob();
				mav.addObject("UserApplyList", userApplyList);
				mav.setViewName("applyjob-list");
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
//	Approve/Reject Apply Job
	@GetMapping("/applyjobResponse")
	public ModelAndView applyjobResponse(@RequestParam("id")Long id, @RequestParam("jobid")Long jobid, @RequestParam("response")int resp, HttpSession session) {
		ModelAndView mav = new ModelAndView("applyjob-list");
		User user = (User) session.getAttribute("user");
		User uApply = userService.get(id);
		Job job = jobService.get(jobid);
		if(user!=null) {
			if(user.getAdmin()==1) {
				if(resp == 1) {
					uApply.setApplystatus(1);
					uApply.setApplyJob(null);
					uApply.setJob(job);
					userService.save(uApply);
				}else {
					uApply.setApplystatus(0);
					uApply.setApplyJob(null);
					userService.save(uApply);
				}
				mav.setViewName("redirect:/applyjobList");
			}else {
				mav.setViewName("redirect:/");
			}
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
	
	
}
