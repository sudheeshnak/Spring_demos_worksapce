package com.capgemini.paytmWallet.repo;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.paytmWallet.beans.Customer;

@Component(value="repo")
public class WalletRepoImpl implements WalletRepo{
	
	@Autowired(required=true)
	private EntityManagerFactory entityManagerFactory;
	

	public WalletRepoImpl() {
	//entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public boolean save(Customer customer) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(customer);
			entityManager.flush();
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			return false;
		}
		return false;
	}


	@Override
	public Customer findOne(String mobileNo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.getTransaction().commit();
		return entityManager.find(Customer.class, mobileNo);
		
	}

	
}
