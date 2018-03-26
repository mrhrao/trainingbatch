package com.crud.demo.model;

import java.util.Date;

public class OTPSMS {
	
	private String email;
	private Date date=new Date();
	private String token;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
