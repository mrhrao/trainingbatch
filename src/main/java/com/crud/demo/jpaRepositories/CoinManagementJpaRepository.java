package com.crud.demo.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.demo.model.CoinManagement;

public interface CoinManagementJpaRepository  extends JpaRepository<CoinManagement, Integer>{

}
