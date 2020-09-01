package com.ion.bankapp.service.transactionoperationservice;

import com.ion.bankapp.common.util.BankAppConstants;
import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class FundWithdrawlServiceImpl implements IFundWithdrawlService {

	@Override
	public String withdrawFund(final long accountNumber, final double amount, final String description) {
		IPersistState persistStateObj = new PersistStateImpl();
		double amountPostDeposit;
		String result = "";
		try {
			amountPostDeposit = persistStateObj.withdrawFund(accountNumber, amount, description);
			result += BankAppConstants.FUND_WITHDRAWAL_SUCCESSFULLY + BankAppConstants.ACCOUNT_BALANCE_STRING
					+ amountPostDeposit;
		} catch (BankException e) {
			result += BankAppConstants.FUND_WITHDRAWL_UNSUCCESSFULLY;
				result+=BankAppConstants.commomMessagePool.get(e.getErrorCode());
			
		}
		return result;
	}

}
