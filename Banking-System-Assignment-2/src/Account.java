import java.util.ArrayList;
import java.util.Date;

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class Account {
	
	private double balance;
	private String accountNumber;
	private boolean active;
	private ArrayList<String> transactionInfo;
	
	/**
	 * Default constructor for class Account
	 */
	public Account() {
	}
	
	/**
	 * @param balance A double for the balance to initialize
	 * @param accountNumber A String for the accountNumber to intialize
	 * @param active A boolean for whether the account is active
	 */
	public Account(double balance, String accountNumber) {
		super();
		setBalance(balance);
		setAccountNumber(accountNumber);
		setActive(true);
		transactionInfo = new ArrayList<String>();
	}

	/**
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance A double for the balance to set
	 */
	public void setBalance(double balance) {
			this.balance = balance;
	}
	
	/**
	 * @param amount A double to add to the balance
	 */
	public void addToBalance(double amount) {
	}
	
	/**
	 * @param amount A double to subtract from the balance
	 */
	public void subtractFromBalance(double amount) {
	}
	
	/**
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber A String for the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if(isValidString(accountNumber)) {
			this.accountNumber = accountNumber;
		}
	}

	/**
	 * @return the active status as a boolean
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * @param active A boolean for the active status to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the transactionInfo as an ArrayList of Strings
	 */
	public ArrayList<String> getTransactionInfo() {
		return transactionInfo;
	}
	
	/**
	 * 
	 * @param transaction A String for the transaction info to add
	 */
	public void addTransactionInfo(String transaction) {
		if(isValidString(transaction)) {
			this.transactionInfo.add(new Date().toString() + transaction);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountNumber=" + accountNumber + ", active=" + active + "]";
	}
	
	/*
	 * Takes a String and validates against null and empty
	 */
	private boolean isValidString(String theString) {
		if(theString != null && theString.length() > 0) {
			return true;
		}
		return false;
	}
}
