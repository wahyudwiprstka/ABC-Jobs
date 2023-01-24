package com.abcjob.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcjob.bean.Job;

@Service
@Transactional
public class JobService {
	@Autowired
	JobRepository repo;
	
	public Job get(Long id) {
		return repo.findById(id).get();
	}
	
	public void save(Job job) {
		repo.save(job);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Job> listAll(){
		return (List<Job>) repo.findAll();
	}
}
