package com.example.demo.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.CoinModel;

@Transactional
public interface CoinRepository extends JpaRepository<CoinModel,Integer>{

}
