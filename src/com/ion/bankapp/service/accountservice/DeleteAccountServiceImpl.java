package com.ion.bankapp.service.accountservice;

import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class DeleteAccountServiceImpl implements IDeleteAccountService {

	@Override
	public boolean deleteAccount(long accountNumber) {
		IPersistState persistStateObj = new PersistStateImpl();
		boolean result;
		try {
			result = persistStateObj.deleteAccount(accountNumber);
		} catch (BankException e) {
			// for logging and handling
			result = false;
		}
		return result;
	}

}
