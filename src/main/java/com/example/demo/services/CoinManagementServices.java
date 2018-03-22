package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.CoinManagementModel;
import com.example.demo.repoINterface.CoinManagementRepository;

@Service
public class CoinManagementServices {

@Autowired
CoinManagementRepository coinDate;

public CoinManagementModel addAllCoinData(CoinManagementModel data)
{
	CoinManagementModel model=coinDate.findByCoinName(data.getCoinName());
	if(model==null)
	coinDate.save(data);
return data;
}
public void deleteCoinById(Long id)
{
	coinDate.delete(id);
}

public CoinManagementModel updataCoinData(CoinManagementModel data)
{
	CoinManagementModel model=coinDate.findByIdAndCoinName(data.getId(), data.getCoinName());
	model.setPrice(data.getPrice());
	return coinDate.save(model);
	
}
public List<CoinManagementModel> findAllCoin()
{
	return coinDate.findAll();
}
}
