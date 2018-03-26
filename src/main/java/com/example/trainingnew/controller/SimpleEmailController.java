package com.example.trainingnew.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.trainingnew.model.MailModel;

@RestController
public class SimpleEmailController {

	@Autowired
	EmailServices service;

	
	@RequestMapping(value="/sendmail", method=RequestMethod.POST)
	public String sendSimpleMail(@RequestBody MailModel mail) {
			return service.sendSimpleMessage(mail);
	}

}
