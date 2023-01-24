package com.abcjob.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.abcjob")
@EnableWebMvc
public class MailSenderConfig {
	
	@Bean
	public JavaMailSender getMail() {
		Properties properties = new Properties();
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		mailSender.setJavaMailProperties(properties);
		mailSender.setUsername("wahyudwiprstka@gmail.com");
		mailSender.setPassword("otbrilszkxkvzzyp");
		
		return mailSender;
	}
	
}
