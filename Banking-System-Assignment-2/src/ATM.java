/**
 * @author Corey Valentyne A00918598
 *
 */
public class ATM {
	
	private boolean isSignedIn;
	private Bank bank;
	private BankCustomer theCustomer;
	private InputReader parser;
	
	/**
	 * Default constructor. Calls the initialize() method to seed the Bank with some BankCustomers. 
	 * Calls the run() method to perform the primary program functions.
	 */
	public ATM() {
		this.isSignedIn = false;
		this.bank = new Bank();
		parser = new InputReader();
		initialize();
	}

	/**
	 * @param args
	 * Main method calls the class default constructor.
	 */
	public static void main(String[] args) {
		new ATM().run();
	}
	
	/**
	 * The primary application processor. 
	 * All application functions are called from here. 
	 * Uses a loop to prompt users to perform banking transactions. 
	 * Must use switch/case selection to determine uses choices.
	 */
	public void run() {
		printWelcome();
		printCommands();
		
		boolean finished = false;
        while (! finished) {
            int command = parser.getIntInput();
            
        	switch(command) {
        		case 0: printCommands();
        				break;
        		case 1: verifyCustomer();
        				break;
            	case 2: transactDeposit();
            			break;
            	case 3: transactWithdraw();
            			break;
            	case 4: displayAccountInformation();
            			break;
            	case 5: finished = true;
        	}
        }
        if(theCustomer != null) {
	        System.out.println("ACCOUNT SUMMARY:");
	        System.out.println(theCustomer.toString());
	        System.out.println("Account Activity:");
	        for(String transaction: theCustomer.getMyAccount().getTransactionInfo()) {
	        	System.out.println(transaction);
	        }
        }
        System.out.println("Thank you for banking at Bullwinkle's Bank.");
        System.out.println("DEBUG: Displaying all the accounts in the bank.");
        Bank.displayAllCustomers();
	}
	
	/**
	 * Adds Customer references to the Bank HashMap as seed data for testing
	 */
	public void initialize() {
		
		BankCustomer[] customers = { new BankCustomer("Jerry", "Seinfeld", "h2as2", 23), //Account Num: CA-123 Passcode: h2as2
				new BankCustomer("Harry", "Jones", "ju23a", 66), //Account Num: GA-123 Passcode: ju23a
				new BankCustomer("Jason", "Kruger", "ki39a", 54) //Account Num: SA-123 Passcode: ki39a
		};
		
		Account[] accounts = { new ChequingAccount(100, "CA-123"), new GoldAccount(200, "GA-123", 2),
				new SavingsAccount(500, "SA-123")};
		
		for(int i = 0; i < customers.length; i++) {
			customers[i].setMyAccount(accounts[i]);
		}
		
		for(BankCustomer customer: customers) {
			bank.createAccount(customer);
		}
	}
	
	/**
	 * Performs a deposit into a BankCustomer's account. 
	 * Checks to see if the user has signed in. 
	 * If not, then verifyCustomer() is called and the menu is displayed again.
	 */
	public void transactDeposit() {
		if(isSignedIn) {
			System.out.println("Enter the amount to deposit");
			double amount = parser.getDoubleInput();
			bank.deposit(theCustomer.getMyAccount().getAccountNumber(), amount);
			printCommands();
		}else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction");
			verifyCustomer();
		}
	}
	
	/**
	 * Performs a withdrawal from a BankCustomer's account. 
	 * Checks to see if the user has signed in. 
	 * If not, then verifyCustomer() is called and the menu is displayed again.
	 */
	public void transactWithdraw() {
		if(isSignedIn) {
			System.out.println("Enter the amount to withdraw");
			double amount = parser.getDoubleInput();
			bank.withdraw(theCustomer.getMyAccount().getAccountNumber(), amount);
			printCommands();
		}else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction");
			verifyCustomer();
		}
	}
	
	/**
	 * Displays a BankCustomer's account information if the customer has been previously verified.
	 */
	public void displayAccountInformation() {
		if(isSignedIn) {
			System.out.println("Here is your information.");
			Bank.displayCustomerInformation(theCustomer);
			printCommands();
		}else {
			System.out.println("ERROR: You must LOGIN before you can perform a transaction");
			verifyCustomer();
		}
	}
	
	/**
	 * To confirm a BankCustomer's account number and passcode. 
	 * Called when the user is required to sign in to the application. 
	 * Will set a boolean so the user does not have to sign in again during the session.
	 */
	public void verifyCustomer() {
		System.out.println("Enter account number:");
		String accountNumber = parser.getStringInput();
		System.out.println("Enter passcode:");
		String passCode = parser.getStringInput();
		
		if(isValidString(accountNumber) && isValidString(passCode) && Bank.theBank.containsKey(accountNumber)
				&& Bank.theBank.get(accountNumber).getPassCode().equals(passCode) && Bank.theBank.get(accountNumber).getMyAccount().getActive()) {
					this.theCustomer = Bank.theBank.get(accountNumber);
					this.isSignedIn = true;
					printCommands();
				}else {
					System.out.println("ERROR: Either account number or passcode is incorrect");
					printWelcome();
					printCommands();
					
				}
	}
	
	/*
	 * Prints a welcome message
	 */
	private void printWelcome() {
		System.out.println("Welcome to Bullwinkle's Bank");
	}
	
	/*
	 * Prints the available commands for the user
	 */
	private void printCommands() {
		System.out.println("Choose one of the following options:");
		System.out.println("1 - Sign In");
		System.out.println("2 - Deposit");
		System.out.println("3 - Withdraw");
		System.out.println("4 - Display Account Info");
		System.out.println("5 - Exit");
		System.out.print(">");
	}
	
	/*
	 * Validates a String against null and empty
	 */
	private boolean isValidString(String theString) {
		boolean valid = false;
		if(theString != null && !theString.equals("")) {
			valid = true;
		}
		return valid;
	}
}
