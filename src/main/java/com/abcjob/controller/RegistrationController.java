package com.abcjob.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;
import com.abcjob.service.EmailSenderService;

@Controller
public class RegistrationController {
	@Autowired
	UserService abcService;
	
	@Autowired
	EmailSenderService emailService;
	
	@GetMapping("/registration")
	public ModelAndView registration(HttpSession session) {
		ModelAndView mav = new ModelAndView("registration");
		if(session.getAttribute("user") == null) {
			mav.setViewName("registration");
		}else{
			mav.setViewName("redirect:/profile");
		}
		return mav;
	}
	
	@PostMapping("/registrationProcess")
	public ModelAndView registrationProcess(@ModelAttribute("registration") User user) throws MessagingException, UnsupportedEncodingException, MessagingException {
		ModelAndView mav = new ModelAndView("registration");
		String email = user.getEmail();
		if(abcService.getUserByEmail(email) == null) {
			user.setAdmin(0);
			abcService.save(user);
			mav.setViewName("redirect:/registration-thankyou");
			emailService.sendEmail(email, "Registration", "Registration Completed Successfuly, thankyou for registering in ABC Job Portal");
		}else {
			mav.addObject("regmsg", "Email already registered");
			mav.setViewName("registration");
		}

		return mav;
	}
	
	@GetMapping("/registration-thankyou")
	public ModelAndView registrationThankyou(HttpSession session) {
		ModelAndView mav = new ModelAndView("thankyou");
		return mav;
	}
}
