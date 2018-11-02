package com.wallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.wallet.dto.Customer;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidPhoneNumber;

public class BankDAOImpl implements BankDAO {

	EntityManager em;

	public BankDAOImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		em = emf.createEntityManager();
	}

	@Override
	public Customer createAccount(Customer c) throws BankException {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		return c;
	}

	@Override
	public Customer getAccount(String mobileno) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Customer cShow = em.find(Customer.class, mobileno);
		em.getTransaction().commit();
		return cShow;
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Customer cShow = em.find(Customer.class, mobileNo);
		cShow.setAmount(amount);
		em.merge(cShow);
		em.getTransaction().commit();
		return true;
	}

	
	
	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws BankException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		List<PrintTransactions> tranList = null;
		em.getTransaction().begin();
		Query query = em.createQuery("from PrintTransactions where mobileNumber = :mobNo");
		query.setParameter("mobNo", mobileNo);
		tranList = query.getResultList();
		if(tranList == null)
			throw new BankException("No transactions are made yet");
		em.getTransaction().commit();
		return tranList;
	}

	@Override
	public void loadTransaction(PrintTransactions pt) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(pt);
		em.getTransaction().commit();
	}

}
