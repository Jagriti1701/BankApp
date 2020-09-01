package com.ion.bankapp.startup;

import com.ion.bankapp.service.startupservice.BankStartupServiceImpl;

public class BankAppStartUp {
	public static void init() {
		BankStartupServiceImpl.startApp();
	}
}
