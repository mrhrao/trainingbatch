package com.example.App.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "coin")
@EntityListeners(AuditingEntityListener.class)
public class Coin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	private String coin_name;
	private String symbol;
	private String init_sup;
	private long price;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public String getCoin_name() {
		return coin_name;
	}
	public void setCoin_name(String coin_name) {
		this.coin_name = coin_name;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getInit_sup() {
		return init_sup;
	}
	public void setInit_sup(String init_sup) {
		this.init_sup = init_sup;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	

}
