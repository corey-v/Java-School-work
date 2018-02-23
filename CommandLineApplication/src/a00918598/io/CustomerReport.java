/**
 * Project: A00918598Lab5
 * File: CustomerReport.java
 * 
 */

package a00918598.io;

import java.time.LocalDate;
import java.util.List;


import a00918598.data.Customer;
import a00918598.util.Common;

/**
 * Prints a formated Customers report.
 * 
 * @author Corey Valentyne A00918598
 *
 */
public class CustomerReport {

	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%4s. %-6s %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s%n";
	public static final String CUSTOMER_FORMAT = "%4d. %06d %-12s %-12s %-40s %-25s %-12s %-15s %-40s %-12s%n";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param customers
	 */
	public static void write(List<Customer> customers) {
		
		 System.out.println("Customers Report"); System.out.println(HORIZONTAL_LINE);
		 System.out.format(HEADER_FORMAT, "#", "ID", "First name", "Last name",
		 "Street", "City", "Postal Code", "Phone", "Email", "Join Date");
		 System.out.println(HORIZONTAL_LINE);
		 
		 int i = 0;
		 
		 for (Customer customer : customers) {
				LocalDate date = customer.getJoinedDate();
				System.out.format(CUSTOMER_FORMAT, ++i, customer.getId(), customer.getFirstName(), customer.getLastName(),
						customer.getStreet(), customer.getCity(), customer.getPostalCode(), customer.getPhone(),
						customer.getEmailAddress(), Common.DATE_FORMAT.format(date));
			}
		
		/*Formatter output = null;

		try {
			output = new Formatter("customers_report.txt");
			output.format("%s%n", HORIZONTAL_LINE);
			output.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone",
					"Email", "Join Date");
			output.format("%s%n", HORIZONTAL_LINE);

			int i = 0;
			// For each customer, output a new line to the file with that customer's info
			for (Customer customer : customers) {
				LocalDate date = customer.getJoinedDate();
				output.format(CUSTOMER_FORMAT, ++i, customer.getId(), customer.getFirstName(), customer.getLastName(),
						customer.getStreet(), customer.getCity(), customer.getPostalCode(), customer.getPhone(),
						customer.getEmailAddress(), Common.DATE_FORMAT.format(date));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (Exception e) {
				}
			}
		}*/

	}
}
