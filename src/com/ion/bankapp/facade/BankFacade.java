package com.ion.bankapp.facade;

import com.ion.bankapp.servicemanager.AccountManager;
import com.ion.bankapp.servicemanager.IAccountManager;
import com.ion.bankapp.servicemanager.ITransactionOperationManager;
import com.ion.bankapp.servicemanager.ITransactionRetrievalManager;
import com.ion.bankapp.servicemanager.TransactionOperationManager;
import com.ion.bankapp.servicemanager.TransactionRetrievalManager;

public class BankFacade implements IBankFacade {

	@Override
	public long createAccount(final String name) {
		IAccountManager accountManagerObj = new AccountManager();
		return accountManagerObj.createAccount(name);
	}

	@Override
	public boolean deleteAccount(long accountNumber) {
		IAccountManager accountManagerObj = new AccountManager();
		return accountManagerObj.deleteAccount(accountNumber);
	}

	@Override
	public String depositFund(final long accountNumber, double amount, final String description) {
		ITransactionOperationManager transactionOperationManagerObj = new TransactionOperationManager();
		return transactionOperationManagerObj.depositFunds(accountNumber, amount, description);
	}

	@Override
	public String withdrawFund(final long accountNumber, final double amount, final String description) {
		ITransactionOperationManager transactionOperationManagerObj = new TransactionOperationManager();
		return transactionOperationManagerObj.withdrawFunds(accountNumber, amount, description);
	}

	@Override
	public String transferFund(final long fromAccountNumber, final long toAccountNumber, final double amount,
			final String description) {
		ITransactionOperationManager transactionOperationManagerObj = new TransactionOperationManager();
		return transactionOperationManagerObj.transferFunds(fromAccountNumber, toAccountNumber, amount, description);
	}

	@Override
	public double getBalance(final long accountNumber) {
		ITransactionRetrievalManager transactionRetrievalManagerObj = new TransactionRetrievalManager();
		return transactionRetrievalManagerObj.getBalance(accountNumber);
	}

	@Override
	public String getLastNTransaction(final long accountNumber, final int n) {
		ITransactionRetrievalManager transactionRetrievalManagerObj = new TransactionRetrievalManager();
		return transactionRetrievalManagerObj.getLastNTransaction(accountNumber,n);
	}

}
