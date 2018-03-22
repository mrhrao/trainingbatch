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
	public void addCurrancy(@RequestBody CoinManagement  coinManagement){
		coinManagementService.addCurruncy(coinManagement);
	}
	
	@RequestMapping("/getAll-currency")
	public List<CoinManagement> getAllCurrency() {
		return coinManagementService.getAllCurrency();
	}
	@RequestMapping("/update-currency")
	public void updateCurrency(@RequestParam Integer currency_id) {
		coinManagementService.updateCurrency(currency_id);
	}
	@RequestMapping("/delete-currency")
	public void deleteCurrency(@RequestParam Integer currency_id) {
		coinManagementService.deleteCurrency(currency_id);
	}

}
