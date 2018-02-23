/**
 * Project: A00918598_Assignment1
 * File: CustomerSorters.java
 * Date: Feb 22, 2018
 * Time: 8:24:53 PM
 */
package a00918598.data;

import java.util.Comparator;

import a00918598.data.Customer;

/**
 * @author Corey Valentyne A00918598
 *
 */

public class CustomerSorters {

	public static class CompareByJoinedDate implements Comparator<Customer> {
		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer1.getJoinedDate().compareTo(customer2.getJoinedDate());
		}
	}

	public static class CompareByJoinedDateDesc implements Comparator<Customer> {
		@Override
		public int compare(Customer customer1, Customer customer2) {
			return customer2.getJoinedDate().compareTo(customer1.getJoinedDate());
		}
	}
}
