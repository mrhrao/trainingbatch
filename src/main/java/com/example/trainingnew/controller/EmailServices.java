package com.example.trainingnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.trainingnew.model.MailModel;

@Service
public class EmailServices {
	
	@Autowired
	private JavaMailSender mailSender;
	
	 public String sendSimpleMessage(final MailModel mail){
	     
		 	SimpleMailMessage message = new SimpleMailMessage();
	        message.setSubject(mail.getSubject());
	        message.setText(mail.getContent());
	        message.setTo(mail.getTo());
	        message.setFrom(mail.getFrom());
	        
	        mailSender.send(message);
			return "Successfull delivered";
			
			//(225) 263-4931
		//	Your new Phone Number is +12252634931
	    }

}


//curl 'https://api.twilio.com/2010-04-01/Accounts/AC1f7cb11ff4bce6470202ae013267e224/Messages.json' -X POST \
//--data-urlencode 'To=+917500922508' \
//--data-urlencode 'From=+12252634931' \
//-u AC1f7cb11ff4bce6470202ae013267e224:3b39a697a4a308dcfa4e3802e6886243