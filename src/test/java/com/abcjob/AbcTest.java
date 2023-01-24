package com.abcjob;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.abcjob.bean.ApplyJob;
import com.abcjob.bean.Job;
import com.abcjob.bean.Thread;
import com.abcjob.bean.User;
import com.abcjob.config.JpaConfig;
import com.abcjob.config.WebMvcConfig;
import com.abcjob.service.ApplyJobService;
import com.abcjob.service.JobService;
import com.abcjob.service.ThreadService;
import com.abcjob.service.UserRepository;
import com.abcjob.service.UserService;

import junit.framework.Assert;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WebMvcConfig.class, JpaConfig.class})
@WebAppConfiguration
public class AbcTest{
	
	@Autowired
	UserService userService;
	
	@Autowired
	JobService jobService;
	
	@Autowired
	ThreadService threadService;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	
	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.build();
	}
	
//	@Test
//	public void testCreateUser() {
//		User user = new User();
//		user.setFirstname("Wahyu");
//		user.setLastname("Dwi Prastika");
//		user.setAddress("Bali, Indonesia");
//		user.setCompany("Lithan");
//		user.setPhonenumber("081234567890");
//		user.setEmail("wahyudwiprstka@gmail.com");
//		user.setPassword("123abc123");
//		userService.save(user);
//		
//		String email = "wahyudwiprstka@gmail.com";
//		User e = userService.getUserByEmail(email);
//		String em = e.getEmail();
//		
//		assertEquals(em, email);
//	}
	
	@Test
	public void testSearchEmail() {
		User user = userService.getUserByEmail("admin@gmail.com");
		String actualEmail = user.getEmail();
		String expectedEmail = "admin@gmail.com";
		
		assertEquals(expectedEmail, actualEmail);
	}
	
	@Test
	public void testSearchToken() {
		User user = userService.getUserByToken("faeaFAEWF3");
		Long actualId = user.getId();
		Long expectedId = (long) 1;
		
		assertEquals(expectedId, actualId);
	}
	
	@Test
	public void testJob() {
		Job job = new Job();
		job.setJobname("Cleaning Service");
		job.setCompany("ABCDE");
		job.setRegion("Indonesia");
		job.setSalary("1700");
		job.setDescription("afoeawjfpoawf");
	}
	
	@Test
	public void testJobAdd() {
		User user = userService.getUserByEmail("admin@gmail.com");
		Job job = jobService.get((long) 1);
		user.setJob(job);
		job.setUser(user);
		
		String jobz = user.getJob().getJobname();
		String userz = job.getUser().getEmail();
		
		userService.save(user);
		
		assertEquals(jobz, "Software Engineer");
	}
	
	@Test
	public void testThread() {
		User user = userService.getUserByEmail("admin@gmail.com");
		Thread thread = new Thread();
		thread.setTitle("ABC");
		thread.setContent("asddfdafasdf asdfasdfasdf fdafaf");
		thread.setUser(user);
		Set<Thread> threads = new HashSet<Thread>();
		threads.add(thread);
		user.setThread(threads);
		threadService.save(thread);
		userService.save(user);
	}
	

}
