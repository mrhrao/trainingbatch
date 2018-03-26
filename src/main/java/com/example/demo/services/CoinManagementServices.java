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

public String addAllCoinData(CoinManagementModel data)
{
	CoinManagementModel model=coinDate.findByCoinName(data.getCoinName());
	if(model==null)
	{
	CoinManagementModel result=coinDate.save(data);
	if(result!=null)
		return "sucess";
	}
return "error";
}
public String deleteCoinById(Long id)
{
	CoinManagementModel result=coinDate.findOne(id);
	if(result!=null) {
	coinDate.delete(id);
	return "success";}
	return "error";
	
}

public String updataCoinData(CoinManagementModel data)
{
	CoinManagementModel model=coinDate.findByIdAndCoinName(data.getId(), data.getCoinName());
	model.setPrice(data.getPrice());
	CoinManagementModel result= coinDate.save(model);
	if(result!=null)
		return "sucess";
return "error";
	
}
public List<CoinManagementModel> findAllCoin()
{
	return coinDate.findAll();
}
}
