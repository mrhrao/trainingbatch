package com.crud.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.crud.demo.jpaRepositories.CoinManagementJpaRepository;
import com.crud.demo.model.CoinManagement;

@Service
public class CoinManagementService {
@Autowired
private CoinManagementJpaRepository coinManagementJpaRepository;



public void addCurruncy(CoinManagement coinManagement) {
	coinManagementJpaRepository.save(coinManagement);	
}

 public List<CoinManagement> getAllCurrency() {
	
	return coinManagementJpaRepository.findAll();
}

public void updateCurrency(Integer currency_id) {
	
	coinManagementJpaRepository.findOne(currency_id);	
}

public void deleteCurrency(Integer currency_id) {
	coinManagementJpaRepository.delete(currency_id);
	
}
}
