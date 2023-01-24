package com.abcjob.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;

@Service
@Transactional
public class ThreadService {
	@Autowired
	ThreadRepository repo;
	
	public Thread get(Long id) {
		return repo.findById(id).get();
	}
	
	public void save(com.abcjob.bean.Thread thread) {
		repo.save(thread);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Thread> listAll(){
		return (List<Thread>) repo.findAll();
	}
	
	public void deleteByUserFK(User keyword) {
		repo.deleteThreadFK(keyword);
	}
}
