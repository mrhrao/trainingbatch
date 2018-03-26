package com.crud.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String roleType;
	@ManyToMany(mappedBy="roles",fetch=FetchType.LAZY)
	private List<User> users;
	/*private User user;*/
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
