package com.ion.bankapp.service.balanceretrievalservice;

import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class BalanceRetrievalServiceImpl implements IBankAccountBalanceRetrievalService{

	@Override
	public double getBalance(long accountNumber) {
		IPersistState persistStateObj= new PersistStateImpl();
		try {
		return persistStateObj.getBalance(accountNumber);
		}catch(BankException e) {
			return -2;
		}
	}

}
