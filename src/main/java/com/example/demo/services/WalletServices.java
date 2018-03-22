package com.example.demo.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.UserModel;
import com.example.demo.model.userModel.WalletModel;
import com.example.demo.repoINterface.UserRepository;
import com.example.demo.repoINterface.WalletRepostiory;

@Service
public class WalletServices {

@Autowired
WalletRepostiory walletData;

@Autowired
UserRepository userData;
public WalletModel addWalletToUser(WalletModel data)
{
	long leftLimit = 1L;
    long rightLimit = 10000000000L;
    boolean check=true;
    long randemId = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
	UserModel userModel=userData.findOne(data.getId());
	WalletModel walletModel=new WalletModel();
	walletModel.setBalance(data.getBalance());
	walletModel.setWalletType(data.getWalletType());
	walletModel.setShadoBalance(data.getBalance());
	walletModel.setUserdata(userModel);
	walletModel.setRandemId(randemId);
	userModel.getWalletModel().add(walletModel);
	List<WalletModel> walletTypeOfuser=userModel.getWalletModel();
	for(WalletModel getwallrttype:walletTypeOfuser)
	{
		String walletType=getwallrttype.getWalletType();
		if(data.getWalletType()==walletType)
			{
			check=false;
		break;
			}
	}
	if(check)
	userData.save(userModel);
	return walletModel;	
}

//---------------------
public WalletModel AddMoneyInWallet(WalletModel data)
{
	WalletModel model=walletData.findOne(data.getId());
	//model.setBalance(data.getBalance());
	int walletBalance=model.getBalance();
	walletBalance=walletBalance+data.getBalance();
	model.setBalance(walletBalance);
	model.setShadoBalance(walletBalance);
	walletData.save(model);
	return model;
}
//---------------------
public WalletModel withdrawMoneyInWallet(WalletModel data)
{
	WalletModel model=walletData.findOne(data.getId());
	//model.setBalance(data.getBalance());
	int walletBalance=model.getBalance();
	walletBalance=walletBalance-data.getBalance();
	model.setBalance(walletBalance);
	model.setShadoBalance(walletBalance);
	//model.setRandemId(walletBalance);
	walletData.save(model);
	return model;
}
}
