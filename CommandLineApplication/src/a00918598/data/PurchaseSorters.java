/**
 * Project: A00918598_Assignment1
 * File: PurchaseSorters.java
 * Date: Feb 22, 2018
 * Time: 8:29:34 PM
 */
package a00918598.data;

import java.util.Comparator;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class PurchaseSorters {

	public static class CompareByLastName implements Comparator<Purchase> {
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			return purchase1.getLastName().compareTo(purchase2.getLastName());
		}
	}
	
	public static class CompareByLastNameDesc implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			return purchase2.getLastName().compareTo(purchase1.getLastName());
		}
	}
	
	public static class CompareByBookTitle implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			return purchase1.getBookTitle().compareTo(purchase2.getBookTitle());
		}
	}
	
	public static class CompareByBookTitleDesc implements Comparator<Purchase>{
		@Override
		public int compare(Purchase purchase1, Purchase purchase2) {
			return purchase2.getBookTitle().compareTo(purchase1.getBookTitle());
		}
	}
}
