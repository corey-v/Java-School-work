package a00918598.book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.DefaultConfiguration;



/**
 * Project: Book
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
	 * Bcmc Constructor. Processes the commandline arguments
	 * ex. -inventory -make=honda -by_count -desc -total -service
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
					System.out.format("-%-5s %-15s %-10s %s%n", value.getOption(), ("-" + value.getLongOption()), value.isHasArg(),
							value.getDescription());
				}

				return;
			}
			
			book.run();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.debug(e.getMessage());
		}

		Instant endTime = Instant.now();
		LOG.info(endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	/**
	 * Configures log4j2 from the external configuration file specified in LOG4J_CONFIG_FILENAME.
	 * If the configuration file isn't found then log4j2's DefaultConfiguration is used.
	 */
	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("WARNING! Can't find the log4j logging configuration file %s; using DefaultConfiguration for logging.",
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
			System.out.println("Cutomer Report: " + BookOptions.isCustomersOptionSet());
			System.out.println("Cutomer Join Date: " + BookOptions.isByJoinDateOptionSet());
			System.out.println("Cutomer Join Date DESC: " + BookOptions.isDescendingOptionSet());
			
			
			
		}

		if (BookOptions.isBooksOptionSet()) {
			LOG.debug("generating the book report");
			
			
			
		}

		if (BookOptions.isPurchasesOptionSet()) {
			LOG.debug("generating the inventory report");
			System.out.println("Purchases total set: " + BookOptions.isTotalOptionSet());
			
			
		}
	}


}
