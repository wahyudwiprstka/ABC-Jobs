package com.abcjob.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abcjob.bean.Job;

@Repository
public interface JobRepository extends CrudRepository<Job, Long> {
	Job findByJobname(String jobname);
}
