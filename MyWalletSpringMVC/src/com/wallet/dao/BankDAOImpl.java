package com.wallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.wallet.dto.Customer;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidPhoneNumber;

@Repository("dao")
public class BankDAOImpl implements BankDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public Customer createAccount(Customer c) throws BankException {
		// TODO Auto-generated method stub
		em.persist(c);
		em.flush();
		return c;
	}

	@Override
	public Customer getAccount(String mobileno) {
		// TODO Auto-generated method stub
		Customer cShow = em.find(Customer.class, mobileno);
		return cShow;
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customer cShow = em.find(Customer.class, mobileNo);
		cShow.setAmount(amount);
		em.merge(cShow);
		return true;
	}

	
	
	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws BankException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		List<PrintTransactions> tranList = null;
		Query query = em.createQuery("from PrintTransactions where mobileNumber = :mobNo");
		query.setParameter("mobNo", mobileNo);
		tranList = query.getResultList();
		if(tranList.isEmpty())
			throw new BankException("No transactions are made yet");
		return tranList;
	}

	@Override
	public void loadTransaction(PrintTransactions pt) {
		// TODO Auto-generated method stub
		em.persist(pt);
	}

}
