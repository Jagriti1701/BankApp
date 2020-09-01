package com.ion.bankapp.common.util;

import java.util.HashMap;
import java.util.Map;

public class BankAppConstants {
	
	public static final String RECORD_ALREADY_EXISTS=" Data already exists for the user, cannot create account.";
	public static final String INTERNAL_ISSUE_TEXT=" Some internal issue occured, please try again later.";
	public static final String RECORD_DOESNT_EXISTS=" Account record is not found coresponding to account number.";
	public static final String RECORD_CANNOT_BE_FETCHED=" Cannot retieve the record at the moment.";
	public static final String INSUFFICINT_FUNDS=" Insufficient fund in your account.";
	
	
	public static final String FUND_DEPOSIT_SUCCESSFULLY="fund deposit successfully.";
	public static final String FUND_DEPOSIT_UNSUCCESSFULLY="fund deposit is NOT successful.";
	
	public static final String FUND_WITHDRAWAL_SUCCESSFULLY="fund withdrawn successfully.";
	public static final String FUND_WITHDRAWL_UNSUCCESSFULLY="fund withdrawal is NOT successful.";
	
	public static final String FUND_TRANSFER_SUCCESSFULLY="fund transferred successfully.";
	public static final String FUND_TRANSFER_UNSUCCESSFULLY="fund transfer is NOT successful.";
	
	public static final String MONEY_REFUND_IN_24HRS="Your MONEY will be credited to your bank account in 24 hrs.";
	
	
	public static final String ACCOUNT_BALANCE_STRING="Your a/c balance is :   INR ";
	
	public static Map<Integer, String> commomMessagePool=new HashMap<>();
	static {
		commomMessagePool.put(-1, RECORD_ALREADY_EXISTS);
		commomMessagePool.put(-2, INTERNAL_ISSUE_TEXT);
		commomMessagePool.put(-3, RECORD_DOESNT_EXISTS);
		commomMessagePool.put(-4, RECORD_CANNOT_BE_FETCHED);
		commomMessagePool.put(-5, INSUFFICINT_FUNDS);
	}
	
}
