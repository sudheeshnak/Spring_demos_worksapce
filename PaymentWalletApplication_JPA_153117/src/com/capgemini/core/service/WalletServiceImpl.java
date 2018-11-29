package com.capgemini.core.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.capgemini.core.beans.Customer;
import com.capgemini.core.beans.Transactions;
import com.capgemini.core.beans.Wallet;
import com.capgemini.core.exception.InsufficientBalanceException;
import com.capgemini.core.exception.InvalidInputException;
import com.capgemini.core.repo.WalletRepo;
import com.capgemini.core.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService{

	private WalletRepo repo;

	public WalletServiceImpl() {
		repo = new WalletRepoImpl();
	}

	public Customer createAccount(String name, String mobileNo, BigDecimal amount) throws InvalidInputException {
		if(isValid(mobileNo) && isValidName(name) && amount.compareTo(new BigDecimal(0)) > 0) {
			Wallet wallet = new Wallet();
			Customer customer = new Customer();
		
			wallet.setBalance(amount);
			customer.setName(name);
			customer.setMobileNo(mobileNo);
			customer.setWallet(wallet);
			
			repo.startTransaction();
			repo.save(customer);
			repo.commitTransaction();

			return customer;
		}
		else throw new InvalidInputException();

	}

	public Customer showBalance(String mobileNo) throws InvalidInputException {
		
		repo.startTransaction();
		Customer customer=repo.findOne(mobileNo);
		repo.commitTransaction();
		
		if(customer!=null)
			return customer;
		else
			throw new InvalidInputException("Invalid mobile no ");
	}

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException {
		
		if(isValid(sourceMobileNo) == false || isValid(targetMobileNo) == false) 
			throw new InvalidInputException();
		
		Customer customer = withdrawAmount(sourceMobileNo, amount);
		depositAmount(targetMobileNo, amount);
		
		return customer;
	}

	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidInputException 
	{
		if(amount.compareTo(new BigDecimal(0)) <= 0) 
			throw new InvalidInputException("Enter valid amount");
		
		if(isValid(mobileNo)) {
			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();
			
			wallet.setBalance(wallet.getBalance().add(amount));
			Transactions transactions = new Transactions();
			transactions.setAmount(amount);
			transactions.setMobileNo(mobileNo);
			transactions.setTransactionType("deposit");
			transactions.setTransactionStatus("success");
			transactions.setTransactionDate(new Date());
			repo.save(transactions);
			
			repo.startTransaction();
			repo.update(customer);
			repo.commitTransaction();
			
			return customer;
		}
		else throw new InvalidInputException("Enter valid mobile number");
	}

	public boolean isValid(String mobileNo) {
		if(mobileNo.matches("[1-9][0-9]{9}")) 
		{
			return true;
		}		
		else 
			return false;
	}
	
	private boolean isValidName(String name) {
		if( name == null || name.trim().isEmpty() )
			return false;
		return true;
	}

	public Customer withdrawAmount(String mobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException 
	{	
		if(amount.compareTo(new BigDecimal(0)) <= 0) 
			throw new InvalidInputException("Enter valid amount");
		
		if(isValid(mobileNo)) 
		{
			Customer customer = repo.findOne(mobileNo);
			Wallet wallet = customer.getWallet();
			
			if(amount.compareTo(wallet.getBalance()) > 0) 
				throw new InsufficientBalanceException("Amount is not sufficient in your account");
			
			wallet.setBalance(wallet.getBalance().subtract(amount));
			customer.setWallet(wallet);
			
			Transactions transactions = new Transactions();
			transactions.setAmount(amount);
			transactions.setMobileNo(mobileNo);
			transactions.setTransactionType("withdraw");
			transactions.setTransactionStatus("success");
			transactions.setTransactionDate(new Date());
			repo.save(transactions);
			
			repo.startTransaction();
			repo.update(customer);
			repo.commitTransaction();
			
			return customer;
		}
		else throw new InvalidInputException("Enter valid mobile number");
	}

	@Override
	public List<Transactions> getAllTrasactions(String mobileNo) {
		return repo.getAllTrasactions(mobileNo);
		
	}
}
