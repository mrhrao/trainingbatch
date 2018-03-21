package com.example.demo.controller.userController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.userModel.CoinManagementModel;
import com.example.demo.services.CoinManagementServices;

@RestController
public class CoinmanagementController {

@Autowired
CoinManagementServices coinData;


	@RequestMapping(value="/addCoin",method=RequestMethod.POST)
	private CoinManagementModel addCoin(@RequestBody CoinManagementModel data)
	{
		return coinData.addAllCoinData(data);
		
	}
	@RequestMapping(value="/updateCoin",method=RequestMethod.POST)
	private CoinManagementModel updateCoin(@RequestBody CoinManagementModel data)
	{
		return coinData.updataCoinData(data);
		
	}
	@RequestMapping(value="/deleteCoin",method=RequestMethod.GET)
	private void deleteCoin(@RequestParam("id") Long id)
	{
		coinData.deleteCoinById(id);
		
	}
	@RequestMapping(value="/getAllCoin",method=RequestMethod.POST)
	private List<CoinManagementModel> getAllCoin(@RequestBody CoinManagementModel data)
	{
		return coinData.findAllCoin();
		
	}
}
