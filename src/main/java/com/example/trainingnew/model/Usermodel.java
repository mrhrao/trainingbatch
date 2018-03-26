package com.example.trainingnew.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdOn",}, 
allowGetters = true)
public class Usermodel{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String username;
	private String email;
	private String status;
	private String country;
	private String password;
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	private int phoneNo;
	
	@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
	 @JoinTable(name = "users_roles",
     joinColumns = { @JoinColumn(name = "users_id") },
     inverseJoinColumns = { @JoinColumn(name = "roles_id") })
	@JsonIgnore
    private List<Rolemodel> roles = new ArrayList<>();
	
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="usermodel")
	@JsonIgnore
	private List<Walletmodel> wallets=new ArrayList<>(); 
	
	
	public Usermodel() {
		
	}
	
	public Usermodel(Usermodel model) {
		this.status=model.getStatus();
		this.email=model.getEmail();
		this.roles=model.getRoles();
		this.username=model.getUsername();
		this.phoneNo=model.getPhoneNo();
		this.country=model.getCountry();
		this.id=model.getId();
		this.createdOn=model.getCreatedOn();
		
	}
	

	public List<Walletmodel> getWallets() {
		return wallets;
	}

	public void setWallets(List<Walletmodel> wallets) {
		this.wallets = wallets;
	}


	public List<Rolemodel> getRoles() {
		return roles;
	}

	public void setRoles(List<Rolemodel> roles) {
		this.roles = roles;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(@NotEmpty(message="Name Can't be empty")String username) {
		
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(@Email(message="Email must be well formed")String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	
	
	
	
}
