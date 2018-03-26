package com.example.demo.repoINterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.VerifyModel;

public interface VerifyRepository extends JpaRepository<VerifyModel, Long>  {

	public VerifyModel findOneByUserNameAndTokenOtp(String username,int tokenOtp);
}

