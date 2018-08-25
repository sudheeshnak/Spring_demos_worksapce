
package com.capgemini.paytmWallet.service;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.paytmWallet.beans.Customer;
import com.capgemini.paytmWallet.beans.Wallet;
import com.capgemini.paytmWallet.exception.InvalidInputException;
import com.capgemini.paytmWallet.repo.WalletRepo;


@Component(value="walletService")
public class WalletServiceImpl implements WalletService
{
	@Autowired(required=true)
	private WalletRepo repo;
	Customer cust = new Customer();
	@Override
	public Customer createAccount(Customer customer) {
		return repo.save(customer);
	}

	@Override
	public Customer showBalance(String mobileno) {

		Customer customer=repo.findOne(mobileno);


		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no ");

	}

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) {

		if(isValid(sourceMobileNo) == false || isValid(targetMobileNo) == false) 
			throw new InvalidInputException("Invalid Input");
		cust=withdrawAmount(sourceMobileNo,amount);
		depositAmount(targetMobileNo, amount);

		return cust;
	}

	private boolean isValid(String targetMobileNo) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) {

		Customer cust1 = repo.findOne(mobileNo);
		BigDecimal res = cust1.getWallet().getBalance();
		res = res.add(amount);
		Wallet wallet = new Wallet();
		wallet.setBalance(res);
		cust1.setWallet(wallet);

		return cust1;
	}
	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount) {

		Customer cust1 = repo.findOne(mobileNo);
		BigDecimal res = cust1.getWallet().getBalance();
		res = res.subtract(amount);
		Wallet wallet = new Wallet();
		wallet.setBalance(res);
		cust1.setWallet(wallet);

		return cust1;
	}



}