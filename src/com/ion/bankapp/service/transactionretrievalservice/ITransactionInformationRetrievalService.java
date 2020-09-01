package com.ion.bankapp.service.transactionretrievalservice;

public interface ITransactionInformationRetrievalService {

	public String getLastNTransaction(final long accountNumber, final int n);
}
