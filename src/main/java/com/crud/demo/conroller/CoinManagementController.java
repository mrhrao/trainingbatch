package com.crud.demo.conroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.demo.model.CoinManagement;
import com.crud.demo.service.CoinManagementService;

@RestController
public class CoinManagementController {
	@Autowired
	private CoinManagementService coinManagementService;
	
	
	@RequestMapping("/add-currancy")
	public String addCurrancy(@RequestBody CoinManagement  coinManagement){
		return coinManagementService.addCurruncy(coinManagement);
	}
	
	@RequestMapping("/getAll-currency")
	public List<CoinManagement> getAllCurrency() {
		return coinManagementService.getAllCurrency();
	}
	@RequestMapping("/update-currency")
	public String updateCurrency(@RequestBody CoinManagement  coinManagement) {
		return coinManagementService.updateCurrency(coinManagement);
	}
	@RequestMapping("/delete-currency")
	public String deleteCurrency(@RequestParam Integer currency_id) {
		return coinManagementService.deleteCurrency(currency_id);
	}

}
