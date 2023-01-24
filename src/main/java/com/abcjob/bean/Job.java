package com.abcjob.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String jobname;
	private String company;
	private String region;
	private String salary;
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "job")
	private User user;
	@OneToOne(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			mappedBy = "applyJob")
	private User userApplyJob;
	
//	Constructor
	public Job() {}
	
	public Job(Long id, String jobname, String company, String region, String salary, String description, User user) {
		super();
		this.id = id;
		this.jobname = jobname;
		this.company = company;
		this.region = region;
		this.salary = salary;
		this.description = description;
		this.user = user;
	}

//	Getter & Setter
	public Long getId() {
		return id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserApplyJob() {
		return userApplyJob;
	}

	public void setUserApplyJob(User userApplyJob) {
		this.userApplyJob = userApplyJob;
	}
	
}
