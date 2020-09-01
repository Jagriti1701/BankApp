package com.ion.bankapp.service.transactionoperationservice;

import com.ion.bankapp.common.util.BankAppConstants;
import com.ion.bankapp.exception.BankException;
import com.ion.bankapp.persistmanager.IPersistState;
import com.ion.bankapp.persistmanager.PersistStateImpl;

public class FundDepositServiceImpl implements IFundDepositService{

	@Override
	public String depositFund(final long accountNumber, final double amount, final String description) {
		IPersistState persistStateObj=new PersistStateImpl();
		double amountPostDeposit;
		String result="";
		try {
			amountPostDeposit= persistStateObj.depositFund(accountNumber, amount, description);
			result+=BankAppConstants.FUND_DEPOSIT_SUCCESSFULLY+BankAppConstants.ACCOUNT_BALANCE_STRING+amountPostDeposit;
		}catch(BankException e) {
			result+=BankAppConstants.FUND_DEPOSIT_UNSUCCESSFULLY;
		}
		return result;
	}

}
