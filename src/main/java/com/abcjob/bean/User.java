package com.abcjob.bean;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String address;
	private String company;
	private Date birth;
	private String phonenumber;
	private Integer admin;
	private String email;
	private String password;
	private String token;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_id", nullable = true)
	private Job job;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "applyjob", nullable = true)
	private Job applyJob;
	
	private Integer applystatus;
	
	@OneToMany(mappedBy = "user")
	private Set<Thread> thread;
	
	@OneToMany(mappedBy = "user")
	private Set<Comment> comment;
	
	public User() {}
	public Long getId() {
		return id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public Job getApplyJob() {
		return applyJob;
	}
	public void setApplyJob(Job applyJob) {
		this.applyJob = applyJob;
	}
	public int getApplystatus() {
		return applystatus;
	}
	public void setApplystatus(int applystatus) {
		this.applystatus = applystatus;
	}
	public Set<Thread> getThread() {
		return thread;
	}
	public void setThread(Set<Thread> thread) {
		this.thread = thread;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public void setApplystatus(Integer applystatus) {
		this.applystatus = applystatus;
	}
	public Set<Comment> getComment() {
		return comment;
	}
	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	

}
