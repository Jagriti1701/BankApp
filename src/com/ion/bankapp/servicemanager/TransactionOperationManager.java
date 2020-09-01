package com.ion.bankapp.servicemanager;

import com.ion.bankapp.service.transactionoperationservice.FundDepositServiceImpl;
import com.ion.bankapp.service.transactionoperationservice.FundTransferServiceImpl;
import com.ion.bankapp.service.transactionoperationservice.FundWithdrawlServiceImpl;
import com.ion.bankapp.service.transactionoperationservice.IFundDepositService;
import com.ion.bankapp.service.transactionoperationservice.IFundTransferService;
import com.ion.bankapp.service.transactionoperationservice.IFundWithdrawlService;

public class TransactionOperationManager implements ITransactionOperationManager {

	@Override
	public String depositFunds(final long accountNumber, final double amount, final String description) {
		IFundDepositService depositFundObj = new FundDepositServiceImpl();
		return depositFundObj.depositFund(accountNumber, amount, description);
	}

	@Override
	public String withdrawFunds(final long accountNumber, final double amount, final String description) {
		IFundWithdrawlService fundWithdrawalObj = new FundWithdrawlServiceImpl();
		return fundWithdrawalObj.withdrawFund(accountNumber, amount, description);
	}

	@Override
	public String transferFunds(final long fromAccountNumber, final long toAccountNumber, final double amount,
			final String description) {
		IFundTransferService transferFundServiceObj = new FundTransferServiceImpl();
		return transferFundServiceObj.fundTransfer(fromAccountNumber, toAccountNumber, amount, description);
	}

}
