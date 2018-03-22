package com.example.demo.repoINterface;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.userModel.CoinManagementModel;

public interface CoinManagementRepository extends JpaRepository<CoinManagementModel, Long>{

	public CoinManagementModel findByIdAndCoinName(Long id,String coinName);
	public CoinManagementModel findByCoinName(String coinName);
	}
