package com.ion.bankapp.persistmanager.inmemorydb;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

import com.ion.bankapp.bean.Account;
import com.ion.bankapp.bean.Transaction;
import com.ion.bankapp.bean.TransactionType;
import com.ion.bankapp.exception.BankException;

public class AccountDB {

	private static Map<Long, Account> inMemoryAccountDb = null;
	private static StampedLock lock = new StampedLock();

	public static void initializeDb() {
		inMemoryAccountDb = new ConcurrentHashMap<>();
	}

	public static void deInitializeDb() {
		inMemoryAccountDb = null;
	}

	public static boolean containsKey(long key) {
		return inMemoryAccountDb.containsKey(key);
	}

	public static void addAccountRecord(Account account) throws BankException {
		long stamp = lock.writeLock();
		try {
			inMemoryAccountDb.put(account.getAccountNumber(), account);
		} catch (Exception e) {
			throw new BankException(-2);
		} finally {
			lock.unlockWrite(stamp);
		}
	}

	public static double getAccountBalance(long accountNumber) throws BankException {
		long stamp = lock.readLock();
		try {
			return inMemoryAccountDb.get(accountNumber).getBalance();
		} catch (Exception e) {
			throw new BankException(-4);
		} finally {
			lock.unlockRead(stamp);
		}
	}

	public static boolean removeAccountRecord(long accountNumber) throws BankException {
		long stamp = lock.writeLock();
		try {
			inMemoryAccountDb.remove(accountNumber);
			return true;
		} catch (Exception e) {
			throw new BankException(-2);
		} finally {
			lock.unlockWrite(stamp);
		}
	}

	public static double updateAccountForWithdrawl(long accountNumber, double amount, String description)
			throws BankException {
		boolean isInsufficientFunds=false;
		try {
			Account tempAccountObj = fetchAccountDetails(accountNumber);
			if (tempAccountObj.getBalance() > amount) {
				synchronized (tempAccountObj) {
					tempAccountObj.setBalance(tempAccountObj.getBalance() - amount);
					TransactionDB.getInstance().commitTransaction(accountNumber,
							createTransaction(amount, tempAccountObj.getBalance(), TransactionType.DEBIT, description));
				}
				return tempAccountObj.getBalance();
			} else {
				isInsufficientFunds=true;
				throw new BankException(-5); // insufficient funds
			}
		} catch (Exception e) {
			if(isInsufficientFunds) {
				throw new BankException(-5);
			}else {
				throw new BankException(-2);
			}
		}
	}

	public static double updateAccountForDeposit(final long accountNumber, final double amount,
			final String description) throws BankException {

		try {
			Account tempAccountObj = inMemoryAccountDb.get(accountNumber);
			synchronized (tempAccountObj) {
				tempAccountObj.setBalance(tempAccountObj.getBalance() + amount);
				TransactionDB.getInstance().commitTransaction(accountNumber,
						createTransaction(amount, tempAccountObj.getBalance(), TransactionType.CREDIT, description));
			}
			return tempAccountObj.getBalance();
		} catch (Exception e) {
			throw new BankException(-2);// internal error
		}
	}

	private static Transaction createTransaction(final double amount, final double balance,
			final TransactionType txcnType, final String description) {
		Transaction txcnObj = new Transaction(TransactionSerialGenerator.getNewTransactionNumber(), description,
				txcnType, balance, amount);
		return txcnObj;
	}

	public static Account fetchAccountDetails(final long accountNumber) {
		long stamp = lock.readLock();
		try {
			return inMemoryAccountDb.get(accountNumber);
		} finally {
			lock.unlockRead(stamp);
		}
	}
}
