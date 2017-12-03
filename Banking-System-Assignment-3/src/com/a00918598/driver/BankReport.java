package com.a00918598.driver;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Set;

import com.a00918598.data.BankCustomer;

/**
 * 
 */

/**
 * @author a00918598
 *
 */
public class BankReport implements ReporterInterface{
	
	
	/**
	 * 
	 */
	public BankReport() {
		
	}
	
	/**
	 * @param records A hashmap of the bank's records
	 * @param prefix A String designating the account prefix to display
	 */
	public void displayByCode(HashMap<String, BankCustomer> records, String prefix) {
		Set<String> accounts = records.keySet();
		for(String account: accounts) {
			BankCustomer cust = records.get(account);
			if(cust.getMyAccount().getAccountNumber().substring(0,2).equals(prefix)) {
				System.out.println(cust);
			}
		}
	}
	
	/**
	 * @param records A hashmap of the bank's records
	 */
	public void displayAllCodes(HashMap<String, BankCustomer> records) {
		Set<String> accounts = records.keySet();
		for(String account: accounts) {
			BankCustomer cust = records.get(account);
			if(cust.getMyAccount().getActive()) {
				System.out.println(cust.toString());
			}
			
		}
	}
	
	/**
	 * @param records A hashmap of the bank's records
	 */
	public void displayInactiveCodes(HashMap<String, BankCustomer> records) {
		Set<String> accounts = records.keySet();
		for(String account: accounts) {
			BankCustomer cust = records.get(account);
			if(!cust.getMyAccount().getActive()) {
				System.out.println(cust.toString());
			}
			
		}
	}
	
	/**
	 * 
	 * @param theBank A hashmap of the bank
	 */
	public void displayAccountTotals(HashMap<String, BankCustomer> theBank) {
		DecimalFormat format = new DecimalFormat("$0.00");
		Set<String> accounts = theBank.keySet();
		double accountTotal = 0;
		for(String account: accounts) {
			BankCustomer cust = theBank.get(account);
			accountTotal += cust.getMyAccount().getBalance();
		}
		System.out.println("The account total balance is: " + format.format(accountTotal));
	}
}
