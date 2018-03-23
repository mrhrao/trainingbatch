package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class TradingExchangeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradingExchangeApplication.class, args);
		System.out.print("hello");
	}
}
