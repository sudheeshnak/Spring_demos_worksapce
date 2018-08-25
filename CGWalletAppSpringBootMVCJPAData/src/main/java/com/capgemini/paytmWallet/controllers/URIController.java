package com.capgemini.paytmWallet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.paytmWallet.beans.Customer;

@Controller
public class URIController {
	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "indexpage";
	}
	
	@RequestMapping(value="/LoginPage")
	public String getLoginPage() {
		return "LoginPage";
	}
	@RequestMapping(value="/RegistrationPage")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}
	
	@RequestMapping(value="/registrationSuccessPage")
	public String getRegistrationSuccessPage() {
		return "registrationSuccessPage";
	}
	
	@ModelAttribute("customer")
	public Customer getCustomer() {
		return new Customer();
	}

	@RequestMapping(value="/showBalance")
	public String getshowBalance() {
		return "showBalance";
	}
	
	@RequestMapping(value="/withdrawAmount")
	public String getwithdrawnamount() {
		return "withdrawAmount";
	}
	
	@RequestMapping(value="/depositAmount")
	public String getdepositamount() {
		return "depositAmount";
	}
	
	@RequestMapping(value="/fundsTransfer")
	public String funds_Trnasfer() {
		return "fundsTransfer";
	}
}
