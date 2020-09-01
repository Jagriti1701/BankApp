package com.ion.bankapp.servicemanager;

public interface IAccountManager {
	
	public long createAccount(final String name);

	public boolean deleteAccount(final long accountNumber);
}
