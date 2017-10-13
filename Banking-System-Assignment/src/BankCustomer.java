/**
 * 
 */

/**
 * @author Corey Valentyne A00918598
 *
 */
public class BankCustomer {
	
	private String firstName;
	private String lastName;
	private String accountNumber;
	private String passCode;
	private double balance;
	
	/**
	 * Default constructor for class BankCustomer
	 */
	public BankCustomer() {
	}

	/**
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the String to set as the first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the String to set as the last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the String to set for the account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the passCode as a String
	 */
	public String getPassCode() {
		return passCode;
	}

	/**
	 * @param passCode the String for the passcode to set
	 */
	public void setPassCode(String passCode) {
		this.passCode = passCode;
	}

	/**
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the double for the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	/**
	 * @param amount A double for the amount to add to balance
	 */
	public void addToBalance(double amount) {
		this.balance += amount;
	}
	
	/*
	 * Takes a string and checks against null and empty
	 */
	private boolean isValidString(String theString) {
		boolean valid = false;
		if(theString != null && !theString.equals("")) {
			valid = true;
		}
		return valid;
	}
	
	public boolean isValidNumber(double number) {
		boolean valid = false;
		if(number > 0) {
			valid = true;
		}
		return valid;
	}
}
