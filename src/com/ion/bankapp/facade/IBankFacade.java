package com.ion.bankapp.facade;

public interface IBankFacade {

	public long createAccount(final String Name);

	public boolean deleteAccount(final long accountNumber);

	public String depositFund(final long accountNumber, final double amount, final String description);

	public String withdrawFund(final long accountNumber, final double amount, final String description);

	public String transferFund(final long fromAccountNumber, final long toAccountNumber, final double amount, final String description);

	public double getBalance(final long accountNumber);

	public String getLastNTransaction(final long accountNumber, final int n);
}
