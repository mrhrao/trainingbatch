package com.example.demo.services.deleteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userModel.RoleModel;
import com.example.demo.model.userModel.UserModel;
import com.example.demo.model.userModel.WalletModel;
import com.example.demo.repoINterface.RoleRepository;
import com.example.demo.repoINterface.UserRepository;
import com.example.demo.repoINterface.WalletRepostiory;

@Service
public class DeleteService {

	@Autowired
	UserRepository userData;
	
	@Autowired 
	WalletRepostiory walletData; 
	
	@Autowired
	RoleRepository roalData;
	public String deleteById(Long id)
	{
		UserModel findWallet=userData.findOne(id);
		if(findWallet==null)
			return "error";
		List<WalletModel> findWalletType=findWallet.getWalletModel();
	for(WalletModel wallet:findWalletType)
		{
			walletData.delete(wallet.getId());
		}
//		List<RoleModel> findRoal=findWallet.getRole();
//		for(RoleModel role:findRoal)
//		{
//			System.out.println(role.getUserRole());
//		findWallet.getRole().remove(role.getUserRole());
//		role.getUser().remove(role.getId());
//		}
		
		//userData.delete(id);
		return "success";
		
		}

}
