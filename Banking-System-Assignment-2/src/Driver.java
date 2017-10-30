/**
 * 
 */

/**
 * @author a00918598
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankCustomer cust1 = new BankCustomer("Jerry", "Smith", "h2a2", 67, "GA");
		Bank bank1 = new Bank();
		bank1.createAccount(cust1);
		cust1.getMyAccount().addToBalance(20);
		//System.out.println(cust1.getMyAccount().getBalance());
		cust1.getMyAccount().subtractFromBalance(200);
		//System.out.println(cust1.getMyAccount().getBalance());
		cust1.getMyAccount().subtractFromBalance(120);
		//System.out.println(cust1.getMyAccount().getBalance());
		
		BankCustomer cust2 = new BankCustomer("Harry", "Styles", "h2a", 42, "CA");
		cust2.getMyAccount().addToBalance(100);
		cust2.getMyAccount().subtractFromBalance(40);
		//System.out.println(cust2.getMyAccount().getBalance());
		cust2.getMyAccount().subtractFromBalance(58);
		//System.out.println(cust2.getMyAccount().getBalance());
		
		for(String transaction: cust1.getMyAccount().getTransactionInfo()) {
			System.out.println(transaction );
		}
		
		BankCustomer cust3 = new BankCustomer("Jason", "Bourne", "j3a", 43, "SA");
		cust3.getMyAccount().addToBalance(100);
		//System.out.println(cust3.getMyAccount().getBalance());
		cust3.getMyAccount().subtractFromBalance(30);
		//System.out.println(cust3.getMyAccount().getBalance());
		cust3.getMyAccount().subtractFromBalance(300);
		System.out.println(cust3.getMyAccount().getActive());
		for(String transaction: cust3.getMyAccount().getTransactionInfo()) {
			System.out.println(transaction );
		}
		
		bank1.createAccount(cust2);
		bank1.createAccount(cust3);
		//Bank.displayAllCustomers();
		bank1.deactivate("GA-0");
		bank1.deactivate("CA-1");
		Bank.displayAllCustomers();
	}

}
