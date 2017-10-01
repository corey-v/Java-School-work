import java.util.HashMap;
import java.util.Set;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class EmailInfo {
	private HashMap<String, String> addressBook;
	
	/**
	 * Default constructor for class EmailInfo
	 */
	public EmailInfo() {
		addressBook = new HashMap<String, String>();
	}
	
	/**
	 * 
	 * @param name A string for the friend's name
	 * @param email A string for the friend's email
	 */
	public void addFriend(String name, String email) {
		if(isValidName(name) && isValidName(email)) {
			name = formatName(name);
			addressBook.put(name, email);
		}
	}
	
	/**
	 * 
	 * @param name A String for the friend to remove
	 */
	public void removeFriend(String name) {
		if(isValidName(name)) {
			name = formatName(name);
			addressBook.remove(name);
		}
	}
	
	/**
	 * 
	 * @param name A String for the friend whose email you want
	 * @return String for the email address
	 */
	public String getAddress(String name) {
		if(isValidName(name)) {
			name = formatName(name);
			return addressBook.get(name);
		}
		return null;
	}
	
	/**
	 * Prints out the friends and their email addresses
	 * @param email A String for the email to search for
	 */
	public void findFriends(String email) {
		Set<String> names = addressBook.keySet();
		if(isValidName(email) && addressBook.containsValue(email)) {
			for(String name: names) {
				if(addressBook.get(name).equalsIgnoreCase(email)) {
					System.out.println(name + ": " + addressBook.get(name));
				}
			}
		}
	}
	
	/**
	 * Prints out all the names and associated email addresses
	 */
	public void listAll() {
		Set<String> names = addressBook.keySet();
		for(String name: names) {
			System.out.println(name + ": " + addressBook.get(name));
		}
	}
	
	/**
	 * @param name A string for the name to be formatted
	 * @return A String of the properly formatted name
	 */
	private String formatName(String name) {
		String formattedName = "";
		if(isValidName(name)) {
			formattedName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		}
		return formattedName;
	}
	
	/**
	 * @param name A string for the name to validate
	 * @return A boolean of whether it's valid
	 */
	private boolean isValidName(String name) {
		boolean valid = false;
		if(name != null && name.length() >0) {
			valid = true;
		}
		return valid;
	}
}
