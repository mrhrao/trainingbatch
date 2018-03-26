package com.example.trainingnew.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class CustomUserDetails extends Usermodel implements UserDetails{



		public CustomUserDetails(final Usermodel model) {
		super(model);
	}
//	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		List<SimpleGrantedAuthority> list  =getRoles()
			.stream()
			.map(role-> new SimpleGrantedAuthority(role.getRole()))
			.collect(Collectors.toList());
		
		System.out.println("Chalo dekhte hai kya aata hai isme"+getRoles());
		
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
