
package com.example.App.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.App.domain.Coin;
@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {



}
