package com.capgemini.paytmWallet.beans;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Wallet {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + walletId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wallet other = (Wallet) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (walletId != other.walletId)
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int walletId;
	
	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public Wallet(int walletId, BigDecimal balance) {
		super();
		this.walletId = walletId;
		this.balance = balance;
	}
private BigDecimal balance;

public Wallet(BigDecimal amount) {
	this.balance=amount;
}

public Wallet() {
	// TODO Auto-generated constructor stub
}

public BigDecimal getBalance() {
	return balance;
}  

public void setBalance(BigDecimal balance) {
	this.balance = balance;
}

@Override
	public String toString() {
	return ", balance="+balance;
}

}

