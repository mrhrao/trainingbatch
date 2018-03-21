package com.example.demo.dto.roleDTO;

import java.util.List;

import com.example.demo.model.userModel.RoleModel;

public class RoleDTO {

	private long id;
	private String userRole;
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}
