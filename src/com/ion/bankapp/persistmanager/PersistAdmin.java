package com.ion.bankapp.persistmanager;

import com.ion.bankapp.persistmanager.inmemorydb.AccountDB;

public class PersistAdmin {

	private static volatile PersistAdmin instance = null;

	public static PersistAdmin getInstance() {
		if (instance == null) {
			synchronized (PersistAdmin.class) {
				if (instance == null) {
					instance = new PersistAdmin();
				}
			}
		}
		return instance;
	}

	private PersistAdmin() {
		AccountDB.initializeDb();
	}

	public static  void init() {
		getInstance();
	}

}
