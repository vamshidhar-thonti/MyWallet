package com.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wallet.dto.Customer;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.service.BankService;

@Controller
public class WalletController {
	
	@Autowired
	BankService service;
	
	@RequestMapping(value = "addCustomer")
	public String addCustomer(@ModelAttribute("addCust") Customer cust) {
		return "addCustomer";
	}
	
	@RequestMapping(value = "addCustomerNow", method = RequestMethod.POST)
	public ModelAndView addCustomerNow(@ModelAttribute("addCust") Customer cust) {
		String res = null;
		System.out.println(cust);
		try {
			service.createAccount(cust);
			res = "Account was created successfully!!!";
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("success", "result", res);
	}
	
	@RequestMapping(value = "showBal")
	public String showBalance(@ModelAttribute("showBal") Customer custBal) {
		return "showBalance";
	}
	
	@RequestMapping(value = "showBalanceNow", method = RequestMethod.POST)
	public ModelAndView showBalanceNow(@ModelAttribute("showBal") Customer custBal) {
		double balance = 0;
		String res = "Nothing updated :(";
		try {
			balance = service.showBalance(custBal.getMobileNumber());
			res = "Your current balance is "+balance;
		} catch (InvalidPhoneNumber | BankException e) {
			res = e.getMessage();
		}
		return new ModelAndView("success", "result", res);
	}
	
	@RequestMapping(value = "funds")
	public String funds(@ModelAttribute("funding") Customer cust) {
		return "funds";
	}
	
	@RequestMapping(value = "fundsTransfer", method = RequestMethod.POST)
	public ModelAndView fundsTransferNow(@ModelAttribute("funding") Customer cust) {
		String res = null;
		String[] mobile = cust.getMobileNumber().split(",");
		for(String s : mobile)
			System.out.println(s);
		try {
			Customer customer = service.fundTransfer(mobile[0], mobile[1], cust.getAmount());
			res = "Your current balance is "+customer.getAmount();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("success", "result", res);
	}
	
	@RequestMapping(value = "deposit")
	public String deposit(@ModelAttribute("deposit") Customer cust) {
		return "deposit";
	}

	@RequestMapping(value = "depositNow", method = RequestMethod.POST)
	public ModelAndView depositNow(@ModelAttribute("deposit") Customer cust) {
		String res = null;
		try {
			Customer customer = service.depositAmount(cust.getMobileNumber(), cust.getAmount());
			res = "Your current balance is "+customer.getAmount();
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidAmount e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("success", "result", res);
	}

	@RequestMapping(value = "withdraw")
	public String withdraw(@ModelAttribute("withdraw") Customer cust) {
		return "withdraw";
	}
	
	@RequestMapping(value = "withdrawNow", method = RequestMethod.POST)
	public ModelAndView withdrawNow(@ModelAttribute("withdraw") Customer cust) {
		String res = null;
		try {
			Customer customer = service.withdrawAmount(cust.getMobileNumber(), cust.getAmount());
			res = "Your current balance is "+customer.getAmount();
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("success", "result", res);
	}
	
	@RequestMapping(value = "print")
	public String print(@ModelAttribute("print") PrintTransactions printTran) {
		return "printTransactions";
	}
	
	@RequestMapping(value = "printNow", method = RequestMethod.POST)
	public ModelAndView printNow(@ModelAttribute("print") PrintTransactions printTran) {
		String res = null;
		List<PrintTransactions> list = null;
		try {
			list = service.getTransactions(printTran.getMobileNumber());
		} catch (BankException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		} catch (InvalidPhoneNumber e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		return new ModelAndView("Transactions", "result", list);
	}

}
