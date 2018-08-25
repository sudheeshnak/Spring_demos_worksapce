package com.capgemini.paytmWallet.controllers;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.paytmWallet.beans.Customer;
import com.capgemini.paytmWallet.repo.WalletRepo;
import com.capgemini.paytmWallet.service.WalletService;

@Controller
public class CustomerActionController {

	@Autowired
	WalletService walletservice;

	@Autowired
	WalletRepo repo;

	@RequestMapping(value="/registerCustomer")
	public ModelAndView registerCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {

		if(result.hasErrors()) return new ModelAndView("RegistrationPage");
		customer = walletservice.createAccount(customer);
		return new ModelAndView("registrationSuccessPage", "customer", customer);

	}

	@RequestMapping(value="/loginCustomer")
	public ModelAndView loginCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {

		if(result.hasErrors()) return new ModelAndView("LoginPage");
		customer = repo.findOne(customer.getMobileNo());
		return new ModelAndView("loginSuccessPage", "customer", customer);

	}

	@RequestMapping(value="/showCustomerBalance")
	public ModelAndView showBalance(@ModelAttribute("customer") Customer customer) {
		
		customer = walletservice.showBalance(customer.getMobileNo());
		return new ModelAndView("showBalanceSuccessPage", "customer", customer);

	}

	@RequestMapping(value="/withdrawCustomerAmount")
	public ModelAndView withdrawAmount(@RequestParam("mobileNo") String mobileNo,@RequestParam("amount") BigDecimal amount, @ModelAttribute("customer") Customer customer) {
		
		customer = walletservice.withdrawAmount(mobileNo, amount);
		return new ModelAndView("withdrawBalanceSuccessPage", "customer", customer);

	}
	@RequestMapping(value="/depositCustomerAmount")
	public ModelAndView depositAmount(@RequestParam("mobileNo") String mobileNo,@RequestParam("amount") BigDecimal amount, @ModelAttribute("customer") Customer customer) {

		customer = walletservice.depositAmount(mobileNo, amount);
		return new ModelAndView("loginSuccessPage", "customer", customer);

	}

	@RequestMapping(value="/CustomerFundsTransfer")
	public ModelAndView fundstransfer( @RequestParam("sourceMobileNo")String sourceMobileNo,@RequestParam("targetMobileNo")String targetMobileNo,@RequestParam("amount") BigDecimal amount,@ModelAttribute("customer") Customer customer) {

		customer = walletservice.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		return new ModelAndView("loginSuccessPage", "customer", customer);

	}

}
