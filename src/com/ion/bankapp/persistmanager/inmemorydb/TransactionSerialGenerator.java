package com.ion.bankapp.persistmanager.inmemorydb;

import java.util.concurrent.atomic.AtomicLong;

public class TransactionSerialGenerator {

	public static long getNewTransactionNumber() {
		return transactionSerial.incrementAndGet();
	}
	
	
	private final static long START_MIN_SEQ_VALUE = 1;
	private static AtomicLong transactionSerial = new AtomicLong(START_MIN_SEQ_VALUE);

}
