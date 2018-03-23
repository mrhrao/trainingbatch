package com.example.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.App.domain.Coin;
import com.example.App.exception.ResourceNotFoundException;
import com.example.App.repository.CoinRepository;
@Service
public class CoinService {
	
	@Autowired
	CoinRepository coinrepository;
	
	//================Curds Operations==========================
	
	
	public Coin createcoin(Coin coin) {
		return coinrepository.save(coin);
	}


	public List<Coin> getAllCoins() {
		return coinrepository.findAll();
	}


	public Coin updatecoin(Long coinId,Coin coin ) {
		Coin coinref =coinrepository.findById(coinId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", coinId));
		coinref.setCoin_name(coin.getCoin_name());
		coinref.setInit_sup(coin.getInit_sup());
		coinref.setSymbol(coin.getSymbol());
		coinref.setPrice(coin.getPrice());
		return coinrepository.save(coinref);
	}


	public ResponseEntity<?> deletecoin(Long coinId) {
		Coin coin=coinrepository.findById(coinId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", coinId));
		coinrepository.delete(coin);
		return ResponseEntity.ok().build();
	}


	public Coin getDataById(Long coinId) {
		 return coinrepository.findById(coinId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", coinId));
	}
	
	
	//================Curds Operations==========================
	
}
