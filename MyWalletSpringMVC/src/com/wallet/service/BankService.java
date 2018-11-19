package com.wallet.service;

import java.util.List;

import com.wallet.dto.Customer;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;

public interface BankService {
	
	public Customer createAccount(Customer c) throws BankException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, BankException;
	public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws BankException;
	public Customer depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, BankException;
	public Customer withdrawAmount(String mobileNo, double amount) throws BankException;
	public boolean validateUserName(String name) throws NameException;
	public boolean validatePhoneNumber(String mobNo) throws InvalidPhoneNumber;
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber;
	public boolean validateAmount(double amt) throws InvalidAmount;
	public boolean validateAll(Customer c) throws BankException, NameException, InvalidAmount, InvalidPhoneNumber;
	public List<PrintTransactions> getTransactions(String mobileNo) throws BankException, InvalidPhoneNumber;
	
}
