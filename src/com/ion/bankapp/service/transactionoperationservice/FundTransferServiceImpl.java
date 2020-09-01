package com.ion.bankapp.service.transactionoperationservice;

import com.ion.bankapp.common.util.BankAppConstants;

public class FundTransferServiceImpl implements IFundTransferService {

	@Override
	public String fundTransfer(final long fromAccountNumber, final long toAccountNumber, final double amount,
			final String description) {
		IFundWithdrawlService fundWithdrawalObj = new FundWithdrawlServiceImpl();
		String result = "";
		String withdrawResult = fundWithdrawalObj.withdrawFund(fromAccountNumber, amount, description);
		if (withdrawResult.contains(BankAppConstants.FUND_WITHDRAWAL_SUCCESSFULLY)) {
			IFundDepositService fundDepositObj = new FundDepositServiceImpl();
			String depositResult = fundDepositObj.depositFund(toAccountNumber, amount, description);
			if (depositResult.contains(BankAppConstants.FUND_DEPOSIT_UNSUCCESSFULLY)) {
				depositResult = fundDepositObj.depositFund(fromAccountNumber, amount, description);
				if (depositResult.contains(BankAppConstants.FUND_DEPOSIT_SUCCESSFULLY)) {
					result += BankAppConstants.FUND_TRANSFER_UNSUCCESSFULLY;
				} else {
					result = BankAppConstants.INTERNAL_ISSUE_TEXT + BankAppConstants.MONEY_REFUND_IN_24HRS;
				}

			} else {
				result += BankAppConstants.FUND_TRANSFER_SUCCESSFULLY;
			}
		} else {
			result += BankAppConstants.FUND_TRANSFER_UNSUCCESSFULLY;
		}

		return result;
	}

}
