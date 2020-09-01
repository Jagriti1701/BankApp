package com.ion.bankapp.service.startupservice;

import com.ion.bankapp.persistmanager.PersistAdmin;

public final class BankStartupServiceImpl {

	public static void startApp() {
		PersistAdmin.init();
	}
}
