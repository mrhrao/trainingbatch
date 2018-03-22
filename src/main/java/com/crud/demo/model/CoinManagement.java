package com.crud.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CoinManagement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer c_id;
	private String name;
	private String symbol;
	private float initialSupply;
	private float price;
	public Integer getC_id() {
		return c_id;
	}
	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public float getInitialSupply() {
		return initialSupply;
	}
	public void setInitialSupply(float initialSupply) {
		this.initialSupply = initialSupply;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

}
