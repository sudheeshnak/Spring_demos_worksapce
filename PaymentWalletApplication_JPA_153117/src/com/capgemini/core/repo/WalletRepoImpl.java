package com.capgemini.core.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transaction;

import com.capgemini.core.beans.Customer;
import com.capgemini.core.beans.Transactions;
import com.capgemini.core.exception.InvalidInputException;
import com.capgemini.core.util.JPAUtil;

public class WalletRepoImpl implements WalletRepo{

	private EntityManager entityManager;
	
	public WalletRepoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}
	
	@Override
	public boolean save(Customer customer) {
		try {
			entityManager.persist(customer);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidInputException {
		Customer customer = entityManager.find(Customer.class, mobileNo);
		return customer;
	}

	@Override
	public void startTransaction() {
		
		entityManager.getTransaction().begin();
		
	}

	@Override
	public void commitTransaction() {
		
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void update(Customer customer) {
		
		entityManager.merge(customer);
		
	}

	@Override
	public List<Transactions> getAllTrasactions(String mobileNo) {
		String str =  "select trans from Transactions trans where mobileNo =:mob";
		Query query = entityManager.createQuery(str,Transactions.class);
		query.setParameter("mob", mobileNo);
		return query.getResultList();
	}

	@Override
	public boolean save(Transactions transaction) throws InvalidInputException {
		try {
			entityManager.persist(transaction);
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}

}
