package com.ion.bankapp.bean;

public class Transaction {

	public Transaction(final long transactionId, final String description, final TransactionType type,
			final double balance, final double amount) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.type = type;
		this.balance = balance;
		this.amount = amount;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public String getDescription() {
		return description;
	}

	public TransactionType getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "[transactionId=" + transactionId + ", description=" + description + ", type=" + type + ", amount="
				+ amount + ", balance=" + balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (transactionId ^ (transactionId >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Transaction) {
			Transaction tempObj = (Transaction) obj;
			if (tempObj.transactionId == this.transactionId && tempObj.amount == this.amount
					&& tempObj.balance == this.balance && tempObj.type == this.type) {
				return true;
			}
		}
		return false;
	}

	private final long transactionId;
	private final String description;
	private final double balance;
	private final double amount;
	private final TransactionType type;

}
