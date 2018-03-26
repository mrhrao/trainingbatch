package com.crud.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer u_id;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String status;
	private String country;
	private Date createdOn;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Set<UserWallet> userWallet; 
	
	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="user_role",joinColumns= {@JoinColumn(name = "user_id")},inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private List<Role> roles;
	
	
	//constructors
	public User()
	{
      super();
	}
	
	//copy Constructor used in spring security CustomUserDetails class
	public User(User user) {
		super();
	}
	
	
	
	
	
	public Integer getId() {
		return u_id;
	}
	public void setId(Integer u_id) {
		this.u_id = u_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Set<UserWallet> getUserWallet() {
		return userWallet;
	}
	public void setUserWallet(Set<UserWallet> userWallet) {
		this.userWallet = userWallet;
	}
	
	

}
