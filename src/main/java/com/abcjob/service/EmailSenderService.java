package com.abcjob.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	@Autowired
	JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject, String text) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom("wahyudwiprstka@gmail.com");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);
		mailSender.send(message);
	}
	
	public void sendEmailRetreivePassword(String to, String link) throws MessagingException, UnsupportedEncodingException{
		MimeMessage message = mailSender.createMimeMessage();              
	    MimeMessageHelper helper = new MimeMessageHelper(message);
		
		String text = "<h3>Hello</h3><br>"
				+ "<p>You have requested to retreive your password</p>"
				+ "<p>Click link below to change your password</p>"
				+ "<a href='" + link + "'>Change Password</a><br>"
				+ "<p>Ignore this if you remember your password</p>";
		
		helper.setFrom("wahyudwiprstka@gmail.com");
		helper.setTo(to);
		helper.setSubject("Retreive Password Request");
		helper.setText(text, true);
		mailSender.send(message);
	}
	
}
