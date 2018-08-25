package com.capgemini.paytmWallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.paytmWallet.beans.Customer;

public interface WalletRepo extends JpaRepository<Customer, String>{

	

}
