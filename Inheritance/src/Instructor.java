/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class Instructor extends Person{

	private int hourlyWage;
	
	/**
	 * Default constructor for class Instructor
	 */
	public Instructor() {
		super();
	}
	
	/**
	 * 
	 * @param firstName A String for the first name to set
	 * @param lastName A Stirng for the last name to set
	 * @param emailAddress A String for the email address to set
	 * @param bcitID A String for the BCIT ID to set
	 * @param hourlyWage An int for the hourly wage to set
	 */
	public Instructor(String firstName, String lastName, String emailAddress, String bcitID, int hourlyWage) {
		super(firstName, lastName, emailAddress, bcitID);
		setHourlyWage(hourlyWage);
	}
	
	/**
	 * @return the hourlyWage as an int
	 */
	public int getHourlyWage() {
		return hourlyWage;
	}

	/**
	 * @param hourlyWage An int for the hourlyWage to set
	 */
	public void setHourlyWage(int hourlyWage) {
		if(hourlyWage >= 0) {
			this.hourlyWage = hourlyWage;
		}
	}
	
	
}
