package com.example.demo.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.UserModel;
import com.example.demo.repoINterface.UserRepository;
@Service
public class MyAppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userData;
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserModel data=userData.findByUserName(userName);
		GrantedAuthority authority = new SimpleGrantedAuthority("user");
		UserDetails userDetails = (UserDetails)new User(data.getUserName(),
		data.getPassword(),Arrays.asList(authority));
		return userDetails;
		/*UserModel data=userData.findByUserName(userName);
		List<GrantedAuthority> roles = new ArrayList<>();
		 for (RoleModel role : data.getRole()) {
			 roles.add(new SimpleGrantedAuthority(role.getUserRole()));
			 }
		UserDetails userDetails = (UserDetails)new User(data.getUserName(),
		data.getPassword(),roles);*/
	}	
	

}
