package com.a00918598.data;
import java.util.Date;

/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne 
 *
 */
public class SavingsAccount extends Account{
	
	private final double MIN_AMOUNT = 100;
	
	/**
	 * Default constructor for class SavingsAccount
	 */
	public SavingsAccount() {
		super();
	}
	
	/**
	 * 
	 * @param balance A double for the balance to initialize
	 * @param accountNumber A String for the accountNumber to intialize
	 * @param active A boolean for whether the account is active
	 */
	public SavingsAccount(double balance, String accountNumber) {
		super(balance, accountNumber);
	}
	
	/**
	 * @param amount A double to add to the balance
	 */
	public void addToBalance(double amount) {
		if(amount > 0) {
			double newBalance = getBalance() + amount;
			setBalance(newBalance);
			addTransactionInfo(" deposit: $" + amount);
		}
	}
	
	/**
	 * @param amount A double to subtract from the balance
	 */
	public void subtractFromBalance(double amount) {
		if(amount>0) {
			double currentBalance = getBalance();
			if(currentBalance - amount > 0) {
				setBalance(currentBalance - amount);
				addTransactionInfo(" withdrawal: $" + amount);
				if(getBalance() < MIN_AMOUNT) {
					setActive(false);
				}
			}
			else {
				System.out.println("You don't have enough money for that");
			}
		}
	}
	
	/**
	 * @param transaction String for the transaction info
	 */
	public void addTransactionInfo(String transaction) {
		if(isValidString(transaction)) {
			transactionInfo.add(new Date().toString() + " - Savings Account" + transaction);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SavingsAccount [MIN_AMOUNT=" + MIN_AMOUNT + ", toString()=" + super.toString() + "]";
	}
	
	
}
