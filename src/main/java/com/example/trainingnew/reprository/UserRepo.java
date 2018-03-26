package com.example.trainingnew.reprository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.trainingnew.model.Usermodel;

public interface UserRepo extends JpaRepository<Usermodel ,Long>{

	Usermodel findOneById(long id);

	Usermodel findOneByEmail(String email);

	Usermodel findByUsername(String username);

	Usermodel findAllByEmail(String email);



}
