package com.ion.bankapp.servicemanager;

import com.ion.bankapp.service.accountservice.CreateAccountServiceImpl;
import com.ion.bankapp.service.accountservice.DeleteAccountServiceImpl;
import com.ion.bankapp.service.accountservice.ICreateAccountService;
import com.ion.bankapp.service.accountservice.IDeleteAccountService;

public class AccountManager implements IAccountManager {

	@Override
	public long createAccount(final String name) {
		ICreateAccountService createAccountServiceObj = new CreateAccountServiceImpl();
		return createAccountServiceObj.createAccount(name);
	}

	@Override
	public boolean deleteAccount(final long accountNumber) {
		IDeleteAccountService deleteAccountServiceObj = new DeleteAccountServiceImpl();
		return deleteAccountServiceObj.deleteAccount(accountNumber);
	}

}
