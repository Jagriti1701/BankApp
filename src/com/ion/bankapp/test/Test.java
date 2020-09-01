package com.ion.bankapp.test;

import com.ion.bankapp.facade.BankFacade;
import com.ion.bankapp.facade.IBankFacade;
import com.ion.bankapp.startup.BankAppStartUp;

public class Test {

	public static void main(String[] args) {
		// initialize the APP
		BankAppStartUp.init();

		IBankFacade facade = new BankFacade();

		// 1.1 create an account with name "ABC"
		// 1.2 create an account with name "DEF"
		System.out.println("ACCOUNT Number for ABC  " + facade.createAccount("ABC"));
		System.out.println("ACCOUNT Number for DEF  " + facade.createAccount("ABC"));
		System.out.println("\n\n");
		// ======================================================================================================================================
		// ======================================================================================================================================

		// 2.1 deposit 1000 to ABC account with account number: 1000000
		// 2.2 deposit 5000 to DEF account with account number: 1000001
		System.out.println("FOR ABC ACCOUNT   :  "
				+ facade.depositFund(1000000, 1000, "deposit 1000 to ABC account with account number: 1000000"));
		System.out.println("FOR DEF ACCOUNT   :  "
				+ facade.depositFund(1000001, 5000, "deposit 5000 to DEF account with account number: 1000001"));
		System.out.println("\n\n");
		// ======================================================================================================================================
		// ======================================================================================================================================

		// 3.1 withdraw 1159 from ABC account with account number: 1000000
		// 3.2 withdraw 2499 from DEF account with account number: 1000001
		System.out.println("FOR ABC ACCOUNT   :"
				+ facade.withdrawFund(1000000, 1159, "withdraw 1159 from ABC account with account number: 1000000")); // low
																														// balance
																														// scenario
		System.out.println("FOR DEF ACCOUNT   :"
				+ facade.withdrawFund(1000001, 2499, "withdraw 2499 from DEF account with account number: 1000001"));
		System.out.println("\n\n");
		// ======================================================================================================================================
		// ======================================================================================================================================

		// 4.1 get balance for ABC with account number 1000000
		// 4.2 get balance for DEF with account number 1000001
		System.out.println("FOR ABC ACCOUNT:   " + facade.getBalance(1000000));
		System.out.println("FOR DEF ACCOUNT:   " + facade.getBalance(1000001));
		System.out.println("\n\n");

		// ======================================================================================================================================
		// ======================================================================================================================================

		// 5.1 Fund Transfer from DEF(amount 200, a/c num : 1000001) account to ABC(a/c
		// num: 1000000) account
		System.out.println("FUND TRANSFER FROM DEF TO ABC  of INR: 200 "
				+ facade.transferFund(1000001, 1000000, 200, "INB TRANSFER"));

		// 5.2 Fund Transfer from DEF(amount 15200, a/c num : 1000001) account to
		// ABC(a/c
		// num: 1000000) account
		System.out.println("FUND TRANSFER FROM DEF TO ABC   of INR: 15200"
				+ facade.transferFund(1000001, 1000000, 15200, "INB TRANSFER"));
		System.out.println("\n\n");
		// ======================================================================================================================================
		// ======================================================================================================================================

		// 6.1 get last 10 transaction for ABC with account number 1000000
		// 6.2 get last 10 transaction for ABC with account number 1000002
		System.out.println("FOR ABC ACCOUNT:  \n\n " + facade.getLastNTransaction(1000000, 10));
		System.out.println("=====================================================================\n");
		System.out.println("FOR DEF ACCOUNT:   \n\n" + facade.getLastNTransaction(1000001, 10));
		System.out.println("\n\n");

	}
}
