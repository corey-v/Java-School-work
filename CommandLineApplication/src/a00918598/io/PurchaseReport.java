/**
 * Project: A00918598_Assignment1
 * File: PurchaseReport.java
 * Date: Feb 22, 2018
 * Time: 8:10:57 PM
 */
package a00918598.io;

import java.util.Collection;

import a00918598.data.Purchase;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class PurchaseReport {
	
	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%-24s %-80s %2s%n";
	public static final String PURCHASE_FORMAT = "%-24s %-80s $%.2f%n";
	
	/**
	 * Private default constructor to prevent instantiation
	 */
	private PurchaseReport() {
	}
	
	public static void write(Collection<Purchase> purchases) {
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "Name", "Title", "Price");
		System.out.println(HORIZONTAL_LINE);
		
		for(Purchase purchase: purchases) {
			String name = purchase.getFirstName() + " " + purchase.getLastName();
			System.out.format(PURCHASE_FORMAT, name, purchase.getBookTitle(), purchase.getPrice());
		}
	}
}
