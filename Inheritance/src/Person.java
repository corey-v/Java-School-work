/**
 * 
 */

/**
 * @author A00918598 Corey Valentyne
 *
 */
public class Person {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String bcitID;
	
	/**
	 * Default constructor for class Person
	 */
	public Person() {
		
	}
	
	/**
	 * @param firstName A String for the first name to set
	 * @param lastName A String for the last name to set
	 * @param emailAddress A String for the email address to set
	 * @param bcitID A String for the bcit id to set
	 */
	public Person(String firstName, String lastName, String emailAddress, String bcitID) {
		super();
		setFirstName(firstName);
		setLastName(lastName);
		setEmailAddress(emailAddress);
		setBcitID(bcitID);
		
	}

	/**
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName A String for the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(isValidString(firstName)) {
			this.firstName = firstName;
		}
	}

	/**
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName A String for the lastName to set
	 */
	public void setLastName(String lastName) {
		if(isValidString(lastName)) {
			this.lastName = lastName;
		}
	}

	/**
	 * @return the emailAddress as a String
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress A String for the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		if(isValidString(emailAddress)) {
			this.emailAddress = emailAddress;
		}
	}

	/**
	 * @return the bcitID as an int
	 */
	public String getBcitID() {
		return bcitID;
	}

	/**
	 * @param bcitID An int for the bcitID to set
	 */
	public void setBcitID(String bcitID) {
		if(isValidString(bcitID)) {
			this.bcitID = bcitID;
		}
	}
	
	/*
	 * Takes a String and verifies against null and length over 0
	 */
	private boolean isValidString(String theString) {
		boolean valid = false;
		if(theString != null && theString.length() > 0) {
			valid = true;
		}
		return valid;
	}
	
	
}
