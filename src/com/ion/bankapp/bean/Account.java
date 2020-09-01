package com.ion.bankapp.bean;

public class Account {

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", balance=" + balance + "]";
	}

	public Account(final long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (null != obj && obj instanceof Account) {
			Account tempObj = (Account) obj;
			if (this.accountNumber == tempObj.getAccountNumber() && this.name.equals(tempObj.getName())) {
				return true;
			}
		}
		return false;
	}

	private final long accountNumber;
	private String name;
	private double balance;

}
