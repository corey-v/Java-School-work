/**
 * @author Corey Valentyne A00918598
 *
 */
public class BankCustomer {
	
	private String firstName;
	private String lastName;
	private String passCode;
	private int age;
	private Account myAccount;
	
	/**
	 * Default constructor for class BankCustomer
	 */
	public BankCustomer() {
	}
	
	/**
	 * 
	 * @param firstName String to initialize the firstName field
	 * @param lastName String to initialize the lastName field
	 * @param passCode String to initialize the passcode field
	 * @param age int to initialize the age field
	 */
	public BankCustomer(String firstName, String lastName, String passCode, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setPassCode(passCode);
		setAge(age);
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
	}

	/**
	 * @return the myAccount
	 */
	public Account getMyAccount() {
		return myAccount;
	}

	/**
	 * @param myAccount the myAccount to set
	 */
	public void setMyAccount(Account myAccount) {
		if(myAccount != null) {
			this.myAccount = myAccount;
		}
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BankCustomer [firstName=" + firstName + ", lastName=" + lastName + ", passCode=" + passCode + ", age="
				+ age + ", myAccount=" + myAccount + "]";
	}
	
	
	
}
