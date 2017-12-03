package com.a00918598.data;
import java.util.Date;

/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class ChequingAccount extends Account{
	
	private final double FEE = 1.2;
	private int numberOfCheques;
	
	/**
	 * Default constructor for class ChequingAccount
	 */
	public ChequingAccount() {
		super();
	}
	
	/**
	 * 
	 * @param balance A double for the balance to initialize
	 * @param accountNumber A String for the accountNumber to intialize
	 * @param active A boolean for whether the account is active
	 */
	public ChequingAccount(double balance, String accountNumber) {
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
			if(currentBalance - amount - FEE > 0) {
				setBalance(currentBalance - amount - FEE);
				addTransactionInfo(" withdrawal: $" + amount);
				numberOfCheques++;
			}
			else {
				System.out.println("You don't have enough money for that");
			}
		}
	}
	
	/**
	 * 
	 * @return An int for the number of cheques
	 */
	public int getNumberOfCheques() {
		return numberOfCheques;
	}
	
	/**
	 * 
	 * @param numberOfCheques An int for the number of cheques to set
	 */
	public void setNumberOfCheques(int numberOfCheques) {
		if(numberOfCheques > 0) {
			this.numberOfCheques = numberOfCheques;
		}
	}
	
	/**
	 * @param transaction String for the transaction info
	 */
	public void addTransactionInfo(String transaction) {
		if(isValidString(transaction)) {
			transactionInfo.add(new Date().toString() + " - Chequing Account " +transaction);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChequingAccount [FEE=" + FEE + ", numberOfCheques=" + numberOfCheques + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	
}
