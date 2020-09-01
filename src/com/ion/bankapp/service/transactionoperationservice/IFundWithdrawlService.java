package com.ion.bankapp.service.transactionoperationservice;

public interface IFundWithdrawlService {
	public String withdrawFund(final long accountNumber, final double amount, final String description);
}
