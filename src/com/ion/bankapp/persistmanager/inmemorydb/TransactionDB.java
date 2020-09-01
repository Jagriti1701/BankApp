package com.ion.bankapp.persistmanager.inmemorydb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.StampedLock;

import com.ion.bankapp.bean.Transaction;

public class TransactionDB {

	private static volatile TransactionDB instance = null;
	private  Map<Long, List<Transaction>> inMemoryTransactionDb = null;
	private StampedLock lock = new StampedLock();

	public static TransactionDB getInstance() {
		if (instance == null) {
			synchronized (TransactionDB.class) {
				if (instance == null) {
					instance = new TransactionDB();
				}
			}
		}
		return instance;
	}

	private TransactionDB() {
		initializeDb();
	}

	private void initializeDb() {
		inMemoryTransactionDb = new ConcurrentHashMap<>();
	}

	public void commitTransaction(final long accountNumber, final Transaction transaction) {
		long stamp = lock.writeLock();
		try {
			List<Transaction> tempList;
			if (inMemoryTransactionDb.containsKey(accountNumber)) {
				tempList = inMemoryTransactionDb.get(accountNumber);
				tempList.add(transaction);
			} else {
				tempList = new ArrayList<>();
				tempList.add(transaction);
				inMemoryTransactionDb.put(accountNumber, tempList);
			}
		} finally {
			lock.unlockWrite(stamp);
		}
	}

	public List<Transaction> getLastNTransaction(final long accountNumber, final int n) {
		long stamp = lock.readLock();
		List<Transaction> tempList;
		try {
			tempList = inMemoryTransactionDb.get(accountNumber);
		} finally {
			lock.unlock(stamp);
		}
		if (tempList.size() > n) {
			return tempList.subList(tempList.size() - n, tempList.size());
		} else {
			return tempList;
		}
	}

}
