package com.abcjob.controller;

import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
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
import com.abcjob.service.EmailSenderService;
import com.abcjob.service.RandomString;

@Controller
public class ForgetPasswordController {

	@Autowired
	UserService abcService;
	
	@Autowired
	EmailSenderService emailSender;
	
	@GetMapping("/retreive-password")
	public ModelAndView retreive() {
		ModelAndView mav = new ModelAndView("retreive-password");
		return mav;
	}
	
	@PostMapping("/retreive-process")
	public ModelAndView retreiveProcess(@RequestParam("email")String email, HttpServletRequest req) throws MessagingException, UnsupportedEncodingException {
		ModelAndView mav = new ModelAndView("redirect:/");
		User user = abcService.getUserByEmail(email);
		new RandomString();
		String token = RandomString.getAlphaNumericString(10);
		user.setToken(token);
		abcService.save(user);
		String webLink = "http://localhost:8080";
		String link = webLink + req.getContextPath() + "/change-password?token=" + token;
		emailSender.sendEmailRetreivePassword(email, link);
		
		System.out.println(link);
		return mav;
	}
	
	@GetMapping("/change-password")
	public ModelAndView changePassword(@RequestParam("token")String token, HttpSession session) {
		ModelAndView mav = new ModelAndView("change-password");
		session.setAttribute("token", token);
		return mav;
	}
	
	@PostMapping("/changepass-process")
	public String changepassProcess(HttpSession session, @RequestParam("password")String password) {
		String token = (String) session.getAttribute("token");
		User user = abcService.getUserByToken(token);
		
		user.setPassword(password);
		abcService.save(user);
		return "redirect:/login";
	}
	
}
