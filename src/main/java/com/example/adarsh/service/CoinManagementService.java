package com.example.adarsh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.adarsh.domain.CoinManagement;
import com.example.adarsh.repository.CoinManagementRepository;

@Service

public class CoinManagementService {

	@Autowired
	CoinManagementRepository coinManagementRepository;

	public CoinManagement addCoin(CoinManagement coinManagement) {

		// save coin in database
		return coinManagementRepository.save(coinManagement);
	}

	// delete coin in database
	public void deleteCoinById(Long id) {
		coinManagementRepository.delete(id);

	}

	public List<CoinManagement> coinDetails() {

		return coinManagementRepository.findAll();
	}

	public CoinManagement updataCoin(CoinManagement coinManagement) {

		CoinManagement coinManagement1 = coinManagementRepository.findByIdAndCoinName(coinManagement.getId(),
				coinManagement.getCoinName());
		coinManagement1.setPrice(coinManagement.getPrice());
		return coinManagementRepository.save(coinManagement1);

	}

}
