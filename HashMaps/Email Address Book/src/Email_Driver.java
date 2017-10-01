/**
 * @author Corey Valentyne A00918598
 *
 */
public class Email_Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Email_Driver().test();
	}

	/**
	 * Tests all the methods for EmailInfo class
	 */
	private void test() {
		EmailInfo emails = new EmailInfo();
		
		
		emails.addFriend("Casey", "CJ@hotmail.com");
		emails.addFriend("Jerry", "Seinfeld@live.ca");
		System.out.println("Address book:");
		
		
		emails.listAll();
		System.out.println();
		
		System.out.println("**Removing Jerry**");
		emails.removeFriend("jerry");
		System.out.println();
		System.out.println("Address book:");
		emails.listAll();
		
		String theAddress = emails.getAddress("Casey");
		System.out.println();
		System.out.println(theAddress);
		System.out.println();
		
		emails.findFriends("CJ@hotmail.com");
	}
}
