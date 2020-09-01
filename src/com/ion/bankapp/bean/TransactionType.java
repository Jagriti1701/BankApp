package com.ion.bankapp.bean;

public enum TransactionType {
	CREDIT("cr"), DEBIT("db");
	private String type;

	TransactionType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
