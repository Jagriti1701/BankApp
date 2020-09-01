package com.ion.bankapp.servicemanager;

public interface ITransactionRetrievalManager {

	public double getBalance(final long accountNumber);

	public String getLastNTransaction(final long accountNumber, final int n);
}
