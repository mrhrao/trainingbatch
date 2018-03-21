package com.example.demo.model.userModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="role")
public class RoleModel {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String userRole;
public String getUserRole() {
	return userRole;
}

public void setUserRole(String userRole) {
	this.userRole = userRole;
}

@ManyToMany(mappedBy="role"	)
private List<UserModel> user=new ArrayList<>();

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public List<UserModel> getUser() {
	return user;
}

public void setUser(List<UserModel> user) {
	this.user = user;
}
}
