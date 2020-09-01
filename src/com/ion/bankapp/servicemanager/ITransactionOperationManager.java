package com.ion.bankapp.servicemanager;

public interface ITransactionOperationManager {

	public String depositFunds(final long accountNumber, final double amount, final String description);

	public String withdrawFunds(final long accoutNumber, final double amount, final String description);

	public String transferFunds(final long fromAccountNumber, final long toAccountNumber, final double amount,
			final String description);
}
