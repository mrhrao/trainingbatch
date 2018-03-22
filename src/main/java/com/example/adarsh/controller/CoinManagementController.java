package com.example.adarsh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.adarsh.domain.CoinManagement;
import com.example.adarsh.service.CoinManagementService;

@RestController
public class CoinManagementController {

	@Autowired
	private CoinManagementService coinManagementService;

	@RequestMapping(value = "/AddCoin", method = RequestMethod.POST)
	public CoinManagement addCoin(@RequestBody CoinManagement coinManagement) {
		return coinManagementService.addCoin(coinManagement);

	}

	@RequestMapping(value = "/deleteCoin", method = RequestMethod.GET)
	private void deleteCoin(@RequestParam("id") Long id) {
		coinManagementService.deleteCoinById(id);
	}

	@RequestMapping("/AllCoinDetails")
	/* @RequestMapping(value = "/AllCoinDetails", method = RequestMethod.GET) */
	private List<CoinManagement> coinDetails() {
		return coinManagementService.coinDetails();
	}

	@RequestMapping(value = "/updateCoin", method = RequestMethod.POST)
	private CoinManagement updateCoin(@RequestBody CoinManagement coinManagement) {
		return coinManagementService.updataCoin(coinManagement);

	}

}
