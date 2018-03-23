package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CoinModel;
import com.example.demo.service.CoinService;

@RestController
@RequestMapping("/coin")
public class CoinController {

	@Autowired
	private CoinService coinService;
	 
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void add(@RequestBody CoinModel coinModel) {
		coinService.addCoin(coinModel);
	}
	
	@RequestMapping(value = "/getAllDetail", method = RequestMethod.GET)
	public List<CoinModel> getAllDetail(){
		return coinService.getAllCoinDetail();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST) 
	public List<CoinModel> update(@PathVariable(value = "id") Integer coinId,
            @RequestBody CoinModel coinDetails) {
		return coinService.updateCoin(coinId,coinDetails);
		
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST) 
	public List<CoinModel> delete(@PathVariable(value = "id") Integer coinId,
            @RequestBody CoinModel coinDetails) {
		return coinService.deleteCoin(coinId);
		
	}
}
