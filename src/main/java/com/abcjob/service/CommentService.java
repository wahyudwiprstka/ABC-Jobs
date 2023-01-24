package com.abcjob.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcjob.bean.Comment;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;

@Service
@Transactional
public class CommentService {
	@Autowired
	CommentRepository repo;
	
	public Comment get(Long id) {
		return repo.findById(id).get();
	}
	
	public void save(Comment comment) {
		repo.save(comment);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Comment> listAll(){
		return (List<Comment>) repo.findAll();
	}
	
	public void deleteByUserFK(User keyword) {
		repo.deleteCommentFK(keyword);
	}
}
