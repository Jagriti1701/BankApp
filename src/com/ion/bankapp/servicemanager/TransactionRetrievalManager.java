package com.ion.bankapp.servicemanager;

import com.ion.bankapp.service.balanceretrievalservice.BalanceRetrievalServiceImpl;
import com.ion.bankapp.service.balanceretrievalservice.IBankAccountBalanceRetrievalService;
import com.ion.bankapp.service.transactionretrievalservice.ITransactionInformationRetrievalService;
import com.ion.bankapp.service.transactionretrievalservice.TransactionInformationRetrievalServiceImpl;

public class TransactionRetrievalManager implements ITransactionRetrievalManager {

	@Override
	public double getBalance(long accountNumber) {
		IBankAccountBalanceRetrievalService balanceRetrievalService = new BalanceRetrievalServiceImpl();
		return balanceRetrievalService.getBalance(accountNumber);
	}

	@Override
	public String getLastNTransaction(final long accountNumber, final int n) {
		ITransactionInformationRetrievalService txcnRetrievalService = new TransactionInformationRetrievalServiceImpl();
		return txcnRetrievalService.getLastNTransaction(accountNumber, n);
	}

}
