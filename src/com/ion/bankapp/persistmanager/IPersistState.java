package com.ion.bankapp.persistmanager;

import java.util.List;

import com.ion.bankapp.bean.Account;
import com.ion.bankapp.bean.Transaction;
import com.ion.bankapp.exception.BankException;

public interface IPersistState {

	public void createAccount(Account account) throws BankException;

	public boolean deleteAccount(final long accountNumber) throws BankException;
	
	public double depositFund(final long accountNumber, final double amount, final String description) throws BankException;
	
	public double withdrawFund(final long accountNumber, final double amount, final String decription) throws BankException;
	
	public double getBalance(final long accountNumber)throws BankException;
	
	public List<Transaction> getLastNTransaction(final long accountNumber, final int n);
	
}
