package com.abcjob.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.abcjob.bean.User;
import com.abcjob.service.UserService;
import com.abcjob.service.CommentService;
import com.abcjob.service.ThreadService;
import com.abcjob.bean.Comment;
import com.abcjob.bean.Thread;

@Controller
public class CommentController {
	@Autowired
	UserService userService;
	
	@Autowired
	ThreadService threadService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping("/addComment/{id}")
	public ModelAndView addComment(@PathVariable("id")Long threadId,
									@RequestParam("content")String content,
									HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/addThread");
		Comment comment = new Comment();
		User user = (User) session.getAttribute("user");
		Thread thread = threadService.get(threadId);
		Set<Comment> comments = new HashSet<Comment>();
		if(user != null) {
			comment.setThread(thread);
			comment.setUser(user);
			comment.setContent(content);
			comments.add(comment);
			thread.setComment(comments);
			threadService.save(thread);
			commentService.save(comment);
			mav.setViewName("redirect:/thread");
		}else {
			mav.setViewName("redirect:/login");
		}
		return mav;
	}
}
