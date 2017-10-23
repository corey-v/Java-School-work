import java.util.ArrayList;

/**
 * 
 */

/**
 * @author a00918598 Corey Valentyne
 *
 */
public class Database {
	
	private ArrayList<Person> people;
	
	/**
	 * Default constructor for class Database
	 */
	public Database() {
		people = new ArrayList<Person>();
	}
	
	/**
	 * 
	 * @param thePerson takes a Person object and adds them to the ArrayList of people
	 */
	public void addPerson(Person thePerson) {
		if(thePerson != null) {
			people.add(thePerson);
		}
	}
	
	/**
	 * Prints out the name and email address of each person in people
	 */
	public void displayDetails() {
		for(Person thePerson: people) {
			System.out.println(thePerson.getFirstName() + " " + thePerson.getLastName() + " " + thePerson.getEmailAddress());
		}
	}
}
