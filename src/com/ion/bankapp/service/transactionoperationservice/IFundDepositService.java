package com.ion.bankapp.service.transactionoperationservice;

public interface IFundDepositService {
	public String depositFund(final long accountNumber, final double amount, final String description);
}
