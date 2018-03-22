package com.crud.demo.jpaRepositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.demo.model.UserWallet;



public interface UserWalletJpaRepository extends JpaRepository<UserWallet, Integer>{
/* @Query("select u from user_wallet where u.wallet_id=:id and u.wallet_type=:walletType")
UserWallet findByIdAndWalletType(@Param("id") Integer id,@Param("walletType") String walletType);*/
  @Transactional
	@Query("select u from user_wallet where u.wallet_type=:walletType")
	UserWallet findByWallet(@Param("wallet_type") String walletType);
}
