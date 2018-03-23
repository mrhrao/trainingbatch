package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CoinModel;
import com.example.demo.repository.CoinRepository;

@Service
public class CoinService {
	
	@Autowired
	private CoinRepository coinRepo;
	
	public void addCoin(CoinModel coinModel) {
		coinRepo.save(coinModel);
	}
	
	public List<CoinModel> getAllCoinDetail(){
		List<CoinModel> coinDetails = new ArrayList<CoinModel>();
		coinRepo.findAll().forEach(coinDetails::add);
		return coinDetails;
	}
	
	public List<CoinModel> updateCoin(int coinId,CoinModel coinModel)  {

		Optional<CoinModel> coinOptionalObject = coinRepo.findById(coinId);
		coinOptionalObject.get().setCoinName(coinModel.getCoinName());
		coinOptionalObject.get().setCoinSymbol(coinModel.getCoinSymbol());
		coinOptionalObject.get().setInitialCoinSupply(coinModel.getInitialCoinSupply());
		coinOptionalObject.get().setCoinPrice(coinModel.getCoinPrice());

		coinRepo.save(coinOptionalObject.get());
		List<CoinModel> coinDetails = new ArrayList<CoinModel>();
		coinRepo.findAll().forEach(coinDetails::add);
	    return coinDetails;
	}
	public List<CoinModel> deleteCoin(Integer coinId)  {

		coinRepo.deleteById(coinId);
		List<CoinModel> coinDetails = new ArrayList<CoinModel>();
		coinRepo.findAll().forEach(coinDetails::add);
	    return coinDetails;
	}
	
	

}
