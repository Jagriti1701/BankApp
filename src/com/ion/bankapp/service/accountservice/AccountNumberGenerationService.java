package com.ion.bankapp.service.accountservice;

import java.util.concurrent.atomic.AtomicLong;

public class AccountNumberGenerationService {

	public static long getNewAccountNumber() {
		return accountnumberSerial.incrementAndGet();
	}
	
	
	private final static long START_MIN_SEQ_VALUE = 999999;
	private static AtomicLong accountnumberSerial = new AtomicLong(START_MIN_SEQ_VALUE);

}
