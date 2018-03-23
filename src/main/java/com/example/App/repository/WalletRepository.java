package com.example.App.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.App.domain.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

}