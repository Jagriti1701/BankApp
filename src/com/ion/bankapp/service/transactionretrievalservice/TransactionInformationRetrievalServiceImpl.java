package com.ion.bankapp.service.transactionretrievalservice;

import java.util.List;

import com.ion.bankapp.bean.Transaction;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class TransactionInformationRetrievalServiceImpl implements ITransactionInformationRetrievalService {

	@Override
	public String getLastNTransaction(long accountNumber, final int n) {
		IPersistState persistateObj = new PersistStateImpl();
		List<Transaction> lastNTransactionList = persistateObj.getLastNTransaction(accountNumber, n);
		String result = "";
		for (Transaction txcnObj : lastNTransactionList) {
			result += txcnObj.toString() + "\n";
		}
		return result;
	}

}
