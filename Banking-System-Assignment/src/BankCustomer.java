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
	 * 
	 * @param firstName String to initialize the firstName field
	 * @param lastName String to initialize the lastName field
	 * @param accountNumber String to initialize the accountNumber field
	 * @param passCode String to initialize the passcode field
	 */
	public BankCustomer(String firstName, String lastName, String accountNumber, String passCode) {
		setFirstName(firstName);
		setLastName(lastName);
		setAccountNumber(accountNumber);
		setPassCode(passCode);
		setBalance(0.0);
	}
	
	/**
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(isValidString(firstName)) {
			this.firstName = firstName;
		}else {
			System.out.println("Please enter a valid first name");
		}
	}

	/**
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(isValidString(lastName)) {
			this.lastName = lastName;
		}else {
			System.out.println("Please enter a valid last name");
		}
	}

	/**
	 * @return the accountNumber as a String
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		if(isValidString(accountNumber)) {
			this.accountNumber = accountNumber;
		}else {
			System.out.println("Please enter a valid account number");
		}
	}

	/**
	 * @return the passCode as a String
	 */
	public String getPassCode() {
		return passCode;
	}

	/**
	 * @param passCode the passcode to set
	 */
	public void setPassCode(String passCode) {
		if(isValidString(passCode)) {
			this.passCode = passCode;
		}else {
			System.out.println("Please enter a valid passcode");
		}
	}

	/**
	 * @return the balance as a double
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if(isValidNumber(balance)) {
			this.balance = balance;
		}else {
			System.out.println("Please enter a valid balance");
		}
	}
	
	/**
	 * @param amount a double to add to the existing balance field
	 */
	public void addToBalance(double amount) {
		if(isValidNumber(amount)) {
			this.balance += amount;
		}else {
			System.out.println("You cannot deposit a negative amount");
		}
	}
	
	/**
	 * 
	 * @param amount a double to subtract from the balance field
	 */
	public void subtractFromBalance(double amount) {
		if(isValidNumber(amount)) {
			this.balance -= amount;
		}else {
			System.out.println("You cannot withdraw a negative amount");
		}
	}
	
	
	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + ", accountNumber=" + accountNumber
				+ ", passCode=" + passCode + ", balance=" + balance + "]";
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
	
	/*
	 * Takes a double number and checks if it's positive
	 */
	public boolean isValidNumber(double number) {
		boolean valid = false;
		if(number >= 0) {
			valid = true;
		}
		return valid;
	}
	
	
}
