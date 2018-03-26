package com.crud.demo.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.crud.demo.model.Email;

@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmailToGmail(Email email) {
		System.out.println("hitting to service");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setFrom(email.getFrom());
		message.setSubject(email.getSubject());
		message.setText(email.getMessage());
		javaMailSender.send(message);
		return "Mail sent successfully";
		
	}

}
