package com.ion.bankapp.persistmanager;

import java.util.List;

import com.ion.bankapp.bean.Account;
import com.ion.bankapp.bean.Transaction;
import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.inmemorydb.AccountDB;
import com.ion.bankapp.persistmanager.inmemorydb.TransactionDB;

public class PersistStateImpl implements IPersistState {

	@Override
	public void createAccount(Account account) throws BankException {
		if (AccountDB.containsKey(account.getAccountNumber())) {
			throw new BankException(-1);
		} else {
			AccountDB.addAccountRecord(account);
		}

	}

	@Override
	public boolean deleteAccount(final long accountNumber) throws BankException {
		return AccountDB.removeAccountRecord(accountNumber);
	}

	@Override
	public double depositFund(final long accountNumber, final double amount, final String description) throws BankException {
		checkForRecordExistence(accountNumber);
		return AccountDB.updateAccountForDeposit(accountNumber, amount, description);
	}

	@Override
	public double withdrawFund(final long accountNumber, final double amount, final String description) throws BankException {
		checkForRecordExistence(accountNumber);
		return AccountDB.updateAccountForWithdrawl(accountNumber, amount, description);
	}

	private void checkForRecordExistence(final long accountNumber) throws BankException {
		if (!AccountDB.containsKey(accountNumber)) {
			throw new BankException(-3);
		}
	}

	@Override
	public double getBalance(long accountNumber) throws BankException {
		return AccountDB.getAccountBalance(accountNumber);
	}

	@Override
	public List<Transaction> getLastNTransaction(long accountNumber, int n) {
		return TransactionDB.getInstance().getLastNTransaction(accountNumber, n);
	}

}
