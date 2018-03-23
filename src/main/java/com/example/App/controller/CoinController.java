package com.example.App.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.App.domain.Coin;
import com.example.App.service.CoinService;

@RestController
@RequestMapping("/tranapi")
public class CoinController {
	
	@Autowired
	CoinService coinservice;

	//================Curds Operations==========================
	
	//save all data
    @RequestMapping(value="/coin",method=RequestMethod.POST)
	public Coin savecoin(@Valid @RequestBody Coin coin) {
    	return coinservice.createcoin(coin);
    }
    
    //get single data by id
  	@RequestMapping(value="/coin/{id}",method=RequestMethod.POST)
  	public Coin getById(@PathVariable(value="id") Long id) {
  	return coinservice.getDataById(id);
  	}
  	
  	
    //final all data 
    @RequestMapping(value="/coin",method=RequestMethod.GET)
    public List<Coin> getAllCoin(){
    	return coinservice.getAllCoins();
    }
    
    //update coin
    @RequestMapping(value="/coin/{id}",method=RequestMethod.PUT)
    public Coin updatecoin(@PathVariable(value = "id") Long coinId,
            @Valid @RequestBody Coin coin) {
 	   return coinservice.updatecoin(coinId,coin);
 	   
    }
    
    //delete coin
    @RequestMapping(value="/coin/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteCoin(@PathVariable(value = "id") Long coinId) {
	  
    	return coinservice.deletecoin(coinId);
    }
  //================Curds Operations==========================

}
