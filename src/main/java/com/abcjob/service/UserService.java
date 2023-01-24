package com.abcjob.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcjob.bean.User;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository repo;
	
	public User getUserByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public User getUserByToken(String token) {
		return repo.findByToken(token);
	}
	
	public User get(Long id) {
		return repo.findById(id).get();
	}
 
	public void save(User user) {
		repo.save(user);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<User> listAll(){
		return (List<User>) repo.findAll();
	}
	
	public List<User> search(String keyword){
		return repo.search(keyword);
	}
	
	public List<User> listApplyJob(){
		return repo.listUserApplyJob();
	}
}
