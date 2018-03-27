package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.constant.RoleEnum;
import com.example.demo.constant.WalletEnum;
import com.example.demo.controller.OTPController;
import com.example.demo.controller.SendingEmailController;
import com.example.demo.model.AuthToken;
import com.example.demo.model.RoleModel;
import com.example.demo.model.UserModel;
import com.example.demo.model.WalletModel;
import com.example.demo.repository.AuthRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.WalletRepository;
import com.example.demo.utils.SendEmail;
import com.example.demo.utils.Utility;

@Service
public class UserService  {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private WalletRepository walletRepo;

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private AuthTokenService authService;
	
	@Autowired
	private AuthRepository authRepo;
	
	@Autowired
	private  JavaMailSender sender1;

	
	// Add Default Wallet For A New User
	public void addWallet(UserModel userModel) {
		WalletModel walletModel = new WalletModel();
		walletModel.setUserIdW(userModel.getUserId());
		walletModel.setUserModel(userModel);
		walletModel.setWalletHash(Utility.generateId(100));
		walletRepo.save(walletModel);
	}

	// Add New User
	public void addUser(UserModel userModel) throws Exception {
		
		userModel.setCreatedOn(new Date());
		Set<RoleModel> roleModel = addDefaultRole();
		userModel.setRoles(roleModel);
		userRepo.save(userModel);
		addWallet(userModel);
		Integer otpNum = Utility.generateId(1000);
		authService.addAuthToken(userModel.getUserName(),otpNum);
	    System.out.println("-----------------"+sender1.createMimeMessage());
		SendEmail.sendEmail(userModel.getEmail(), otpNum, userModel.getUserName(),sender1);
		OTPController.sendSMS(userModel.getMobile().toString(),otpNum.toString());
	}
	
	//verify user
	public String verifyUser(UserModel userModel,Integer otp) {
		Optional<UserModel> userOp = userRepo.findById(userModel.getUserId());
		if(userOp.get()!= null) {
			AuthToken authToken = authRepo.findByOtp(otp);
			if(authToken != null) {
				userOp.get().setStatus(true);
				userRepo.save(userOp.get());
				return "Success";
			}
			else {
				//re-send the One time password
				return "not a valid otp";
			}
		}
		else {
			//sign up first
			return "user does not exist";
		}
	
			
		
	}
	
	//Re-send the One time Password
	public void resendOtp(UserModel userModel) throws Exception{
		Integer otp =  Utility.generateId(100);
		SendEmail.sendEmail(userModel.getEmail(),otp, userModel.getUserName(),sender1);
		OTPController.sendSMS(userModel.getMobile().toString(),otp.toString());
	}

	// Add Default Role For A New User
	public Set<RoleModel> addDefaultRole() {
		RoleModel role = new RoleModel();
		Set<RoleModel> roleModel = new HashSet<RoleModel>();
		role.setRole(RoleEnum.User.toString());
		roleModel.add(role);
		return roleModel;
	}

	// Check Role is Valid or Not.
	public Boolean isRoleTypeValid(String roleType) {
		int flag = 0;
		for (RoleEnum type : RoleEnum.values()) {
			if (roleType.equalsIgnoreCase(type.toString())) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}

	public String addRole(UserModel userModel, String roleType) {
		Boolean check = isRoleTypeValid(roleType);
		if (check) {

			int flag = 0;
			RoleModel roleOp = roleRepo.findAllByRole(roleType);

			if (roleOp != null) {
				Set<RoleModel> role = userModel.getRoles();

				for (RoleModel type : role) {
					UserModel user = userRepo.findByUserIdAndRoles(userModel.getUserId(), type.getRole());
					if (user != null) {
						flag = 1;
						break;
					}
				}
			}

			if (flag == 0) {
				userModel.setCreatedOn(new Date());
				userRepo.save(userModel);
				addWallet(userModel);
				return "success";
			} else {
				return "role exists";
			}

		}

		else {
			return "not a valid type";
		}

	}

	// Check WalletType is Valid or Not.
	public Boolean isWalletTypeValid(String walletType) {
		int flag = 0;
		for (WalletEnum type : WalletEnum.values()) {
			if (walletType.equalsIgnoreCase(type.toString())) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			return true;
		} else {
			return false;
		}

	}

	// Add Another For a Existing User wallet
	public void addAnotherWallet(UserModel userModel, String walletType) {
		Boolean check = isWalletTypeValid(walletType);
		if (check) {

			int flag = 0;
			List<WalletModel> walletOp = walletRepo.findAllByUserIdW(userModel.getUserId());
			for (WalletModel type : walletOp) {
				if (type.getWalletType().equalsIgnoreCase(walletType)) {
					System.out.println(type.getWalletType());
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				WalletModel walletModel = new WalletModel();
				walletModel.setUserIdW(userModel.getUserId());
				walletModel.setUserModel(userModel);
				walletModel.setWalletHash(Utility.generateId(100));
				walletModel.setWalletType(walletType);
				walletRepo.save(walletModel);
			}

		}

	}

	public void addAmountIntoWallet(UserModel userModel, Float amount, String walletType) {
		WalletModel walletModel = walletRepo.findByWalletTypeAndUserIdW(walletType, userModel.getUserId());
		walletModel.setBalance(walletModel.getBalance() + amount);
		walletModel.setShadowBalance(walletModel.getBalance() + amount);
		walletRepo.save(walletModel);
	}

	public void withdrawAmountFromWallet(UserModel userModel, Float amount, String walletType) {
		WalletModel walletModel = walletRepo.findByWalletTypeAndUserIdW(walletType, userModel.getUserId());
		if (amount < walletModel.getBalance()) {
			walletModel.setBalance(walletModel.getBalance() - amount);
			walletModel.setShadowBalance(walletModel.getBalance() - amount);
			walletRepo.save(walletModel);
		}
	}

	public List<UserModel> getAllDetails() {
		List<UserModel> userDetails = new ArrayList<UserModel>();
		userRepo.findAll().forEach(userDetails::add);
		return userDetails;
	}

	public void deleteUser(int id) {
		userRepo.deleteById(id);
	}

	public List<UserModel> updateUser(int userId, UserModel u) {

		Optional<UserModel> userOp = userRepo.findById(userId);
		System.out.println(userOp + "---------------------------------------");
		userOp.get().setUserName(u.getUserName());
		userOp.get().setCountry(u.getCountry());
		userOp.get().setEmail(u.getEmail());
		userOp.get().setMobile(u.getMobile());
		userOp.get().setPasswd(u.getPasswd());

		userRepo.save(userOp.get());
		List<UserModel> userDetails = new ArrayList<UserModel>();
		userRepo.findAll().forEach(userDetails::add);
		return userDetails;
	}

	public UserModel getUser(int userId, UserModel u) {

		Optional<UserModel> userOp = userRepo.findById(userId);
		return userOp.get();
	}

	public Iterable<UserModel> getAll() {
		return userRepo.findAll();
	}

	public void saveUserWallet(UserModel user) {
		user.setCreatedOn(new Date());
		userRepo.save(user);

	}

}
