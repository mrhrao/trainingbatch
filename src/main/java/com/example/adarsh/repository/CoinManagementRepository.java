package com.example.adarsh.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.adarsh.domain.CoinManagement;

public interface CoinManagementRepository extends JpaRepository<CoinManagement, Serializable> {

	CoinManagement findByIdAndCoinName(long id, String coinName);

}
