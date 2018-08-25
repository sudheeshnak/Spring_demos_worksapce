package com.capgemini.paytm.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication(scanBasePackages= {"com.capgemini.paytmWallet"})
@EntityScan(basePackages = "com.capgemini.paytmWallet.beans")
@EnableJpaRepositories(basePackages="com.capgemini.paytmWallet.repo")
@EnableWebMvc

public class WalletAppMain  extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(WalletAppMain.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WalletAppMain.class);
	}

}
