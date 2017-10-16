import java.util.HashMap;
import java.util.Set;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class Bank {
	
	public static HashMap<String, BankCustomer> theBank;
	
	/**
	 * Default constructor for Bank class. Initializes the HashMap
	 */
	public Bank() {
		theBank = new HashMap<String, BankCustomer>();
	}
	
	/**
	 * 
	 * @param newCustomer The new element to add to the HashMap using the account number as the key and the new BankCustomer as the value
	 */
	public void createAccount(BankCustomer newCustomer) {
		if(newCustomer != null) {
			if(newCustomer.getAccountNumber() != null) {
				theBank.put(newCustomer.getAccountNumber(),newCustomer);
				System.out.println("New customer added");
			}else {
				System.out.println("Cannot add new customer");
			}
		}else {
			System.out.println("Cannot add new customer");
		}
	}
	
	/**
	 * 
	 * @param accountNumber The key of the element to remove from the HashMap
	 */
	public void closeAccount(String accountNumber) {
		if(isValidAccountNumber(accountNumber)) {
			theBank.remove(accountNumber);
		}else {
			System.out.println("Cannot close account");
		}
	}
	
	/**
	 * 
	 * @param accountNumber The account number of the BankCustomer
	 * @param amount The amount to deposit
	 */
	public void deposit(String accountNumber, double amount) {
		if(isValidAccountNumber(accountNumber)) {
			theBank.get(accountNumber).addToBalance(amount);
		}
	}
	
	/**
	 * 
	 * @param accountNumber The account number of the BankCustomer
	 * @param amount The amount to subtract from a BankCustomer's balance
	 */
	public void withdraw(String accountNumber, double amount) {
		if(isValidAccountNumber(accountNumber)) {
			if((theBank.get(accountNumber).getBalance() - amount) < 0) {
				System.out.println("You don't have enough money for that");
			}else {
				theBank.get(accountNumber).subtractFromBalance(amount);
			}
		}
	}
	
	/**
	 * 
	 * @param customer the BankCustomer chosen to display
	 */
	public static void displayCustomerInformation(BankCustomer customer) {
		if(customer != null) {
			System.out.println(customer.toString());
		}
	}
	
	/**
	 * Displays all elements of the HashMap by using BankCustomer.toString() implementation of each
	 */
	public static void displayAllCustomers() {
		Set<String> accounts = theBank.keySet();
		for(String account: accounts) {
			BankCustomer cust = theBank.get(account);
			System.out.println(cust.toString());
		}
	}
	
	/*
	 * Takes an account number String and checks for null, empty, and if the bank has that account
	 */
	private static boolean isValidAccountNumber(String accountNumber) {
		boolean valid = false;
		if(accountNumber != null && !accountNumber.equals("") && theBank.containsKey(accountNumber)) {
			valid = true;
		}
		return valid;
	}
}
	

