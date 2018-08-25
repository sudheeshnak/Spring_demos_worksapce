package com.capgemini.paytmWallet.repo;

import com.capgemini.paytmWallet.beans.Customer;

public interface WalletRepo {

public boolean save(Customer customer);
	
	public Customer findOne(String mobileNo);
	
}
