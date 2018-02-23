/**
 * Project: A00918598_Assignment1
 * File: PurchaseReader.java
 * Date: Feb 22, 2018
 * Time: 5:47:36 PM
 */
package a00918598.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00918598.book.ApplicationException;
import a00918598.data.Purchase;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class PurchaseReader {
	
	private static final Logger LOG = LogManager.getLogger();
	/**
	 * 
	 */
	private PurchaseReader() {	
	}

	public static List<Purchase> read(String filePath) throws ApplicationException{
		File file = new File(filePath);
		FileReader in;
		Iterable<CSVRecord> records;
		List<Purchase> purchases = new ArrayList<>();
		LOG.debug("Reading " + file.getAbsolutePath());
		try {
			in = new FileReader(file);
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			
			for(CSVRecord record: records) {
				long customerID = Integer.parseInt(record.get("customer_id"));
				long bookID = Integer.parseInt(record.get("book_id"));
				double price = Double.parseDouble(record.get("price"));
				
				Purchase myPurchase = new Purchase.Builder(customerID, bookID, price).build();
				
				purchases.add(myPurchase);
				LOG.debug("Added " + myPurchase);
			}
		}catch(IOException e) {
			LOG.error(e.getMessage(), e);
			throw new ApplicationException(e);
		}
		
		
		return purchases;
	}
}
