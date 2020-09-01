package com.ion.bankapp.service.transactionoperationservice;

public interface IFundTransferService {

	public String fundTransfer(final long fromAccountNumber, final long toAccountNumber, final double amount,
			final String description);
}
