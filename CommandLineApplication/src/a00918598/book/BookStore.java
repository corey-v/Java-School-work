package a00918598.book;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;

import a00918598.book.ApplicationException;
import a00918598.data.Book;
import a00918598.data.BookSorters;
import a00918598.data.Customer;
import a00918598.data.CustomerSorters;
import a00918598.data.Purchase;
import a00918598.data.PurchaseSorters;
import a00918598.io.BookReader;
import a00918598.io.BookReport;
import a00918598.io.CustomerReader;
import a00918598.io.CustomerReport;
import a00918598.io.PurchaseReader;
import a00918598.io.PurchaseReport;

/**
 * Project: A00918598_Assignment1
 * File: BookStore.java
 * Date: October, 2017
 * Time: 1:22:25 PM
 */

/**
 * @author Corey Valentyne A00918598
 *
 */
public class BookStore {

	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger();

	/**
	 * Bcmc Constructor. Processes the commandline arguments ex. -inventory
	 * -make=honda -by_count -desc -total -service
	 * 
	 * @throws ApplicationException
	 * @throws ParseException
	 */
	public BookStore(String[] args) throws ApplicationException, ParseException {
		LOG.info("Created Bcmc");

		BookOptions.process(args);
	}

	/**
	 * Entry point to GIS
	 * 
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) {
		Instant startTime = Instant.now();
		LOG.info(startTime);

		// start the Book System
		try {
			BookStore book = new BookStore(args);
			if (BookOptions.isHelpOptionSet()) {
				BookOptions.Value[] values = BookOptions.Value.values();
				System.out.format("%-5s %-15s %-10s %s%n", "Option", "Long Option", "Has Value", "Description");
				for (BookOptions.Value value : values) {
					System.out.format("-%-5s %-15s %-10s %s%n", value.getOption(), ("-" + value.getLongOption()),
							value.isHasArg(), value.getDescription());
				}

				return;
			}

			book.run();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

		Instant endTime = Instant.now();
		LOG.info(endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Configures log4j2 from the external configuration file specified in
	 * LOG4J_CONFIG_FILENAME. If the configuration file isn't found then log4j2's
	 * DefaultConfiguration is used.
	 */
	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format(
					"WARNING! Can't find the log4j logging configuration file %s; using DefaultConfiguration for logging.",
					LOG4J_CONFIG_FILENAME));
			Configurator.initialize(new DefaultConfiguration());
		}
	}

	/**
	 * @throws ApplicationException
	 * @throws FileNotFoundException
	 * 
	 */
	private void run() throws ApplicationException, FileNotFoundException {
		LOG.debug("run()");

		generateReports();
	}

	/**
	 * Generate the reports from the input data
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateReports() throws FileNotFoundException {
		LOG.debug("generating the reports");

		if (BookOptions.isCustomersOptionSet()) {
			LOG.debug("generating the customer report");
			// for program args: -c -J -d
			try {
				File file = new File("customers.dat");
				List<Customer> customers = CustomerReader.read(file);

				// sort the customers by joined date and/or descending
				if (BookOptions.isByJoinDateOptionSet() && BookOptions.isDescendingOptionSet()) {
					Collections.sort(customers, new CustomerSorters.CompareByJoinedDateDesc());
				} else if (BookOptions.isByJoinDateOptionSet()) {
					Collections.sort(customers, new CustomerSorters.CompareByJoinedDate());
				}

				CustomerReport.write(customers);
			} catch (ApplicationException e) {
				LOG.error(e.getMessage(),e);
			}

		}

		if (BookOptions.isBooksOptionSet()) {
			LOG.debug("generating the book report");

			try {
				
				List<Book> books = BookReader.read("books500.csv");
				
				//Sort
				if(BookOptions.isByAuthorOptionSet()) {
					Collections.sort(books, new BookSorters.CompareByAuthorName());
				}
				//Write
				BookReport.write(books);
			} catch (ApplicationException e) {
				LOG.error(e.getMessage(), e);
			}

		}

		if (BookOptions.isPurchasesOptionSet()) {
			LOG.debug("generating the inventory report");
			System.out.println("Purchases total set: " + BookOptions.isTotalOptionSet());

			try {
				File file = new File("customers.dat");
				List<Customer> customers = CustomerReader.read(file);
				List<Purchase> purchases = PurchaseReader.read("purchases.csv");
				List<Book> books = BookReader.read("books500.csv");

				Map<Long, Customer> custMap = new HashMap<>();
				for (Customer customer : customers) {
					custMap.put(customer.getId(), customer);
				}
				Map<Long, Book> bookMap = new HashMap<>();
				for (Book book : books) {
					bookMap.put(book.getId(), book);
				}

				// Add customer name and book title to each purchase
				for (Purchase purchase : purchases) {
					purchase.setFirstName(custMap.get(purchase.getcustomerID()).getFirstName());
					purchase.setLastName(custMap.get(purchase.getcustomerID()).getLastName());
					purchase.setBookTitle(bookMap.get(purchase.getbookID()).getTitle());

				}
				
				//Filter by customer ID if entered
				if (BookOptions.getCustomerId() != null) {
					int id = Integer.parseInt(BookOptions.getCustomerId());
					List<Purchase> filteredPurchases = new ArrayList<>();

					filteredPurchases = purchases.stream().filter(p -> id == p.getcustomerID())
							.collect(Collectors.toList());

					purchases = filteredPurchases;
				}
				
				// Sort
				if (BookOptions.isByLastnameOptionSet() && BookOptions.isDescendingOptionSet()) {
					Collections.sort(purchases, new PurchaseSorters.CompareByLastNameDesc());
				} else if (BookOptions.isByLastnameOptionSet()) {
					Collections.sort(purchases, new PurchaseSorters.CompareByLastName());
				} else if (BookOptions.isByTitleOptionSet() && BookOptions.isDescendingOptionSet()) {
					Collections.sort(purchases, new PurchaseSorters.CompareByBookTitleDesc());
				} else if (BookOptions.isByTitleOptionSet()) {
					Collections.sort(purchases, new PurchaseSorters.CompareByBookTitle());
				}
				
				
				// Write
				PurchaseReport.write(purchases);
				if(BookOptions.isTotalOptionSet()) {
					double total = 0.0;
					for(Purchase purchase: purchases) {
						total += purchase.getPrice();
					}
					
					System.out.format("Value of purchases: $%.2f%n", total);
				}

			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}

		}
	}

}
