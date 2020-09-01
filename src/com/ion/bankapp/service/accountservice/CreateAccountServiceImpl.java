package com.ion.bankapp.service.accountservice;

import com.ion.bankapp.bean.Account;
import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class CreateAccountServiceImpl implements ICreateAccountService {

	@Override
	public long createAccount(String name) {
		Account account = new Account(AccountNumberGenerationService.getNewAccountNumber());
		account.setName(name);
		long accountNumber = account.getAccountNumber();
		IPersistState persistStateObj = new PersistStateImpl();
		try {
			persistStateObj.createAccount(account);
		} catch (BankException e) {
			accountNumber = e.getErrorCode();
		}
		return accountNumber;
	}

}
