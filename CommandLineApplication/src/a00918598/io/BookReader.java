/**
 * Project: A00918598_Assignment1
 * File: BookReader.java
 * Date: Feb 21, 2018
 * Time: 8:09:52 PM
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
import a00918598.data.Book;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class BookReader {
	
	private static final Logger LOG = LogManager.getLogger();
	/**
	 * private constructor to prevent instantiation
	 */
	private BookReader() {
	}
	
	public static List<Book> read(String filePath) throws ApplicationException{
		File file = new File(filePath);
		FileReader in;
		Iterable<CSVRecord> records;
		List<Book> books = new ArrayList<>();
		
		LOG.debug("Reading " + file.getAbsolutePath());
		
		try {
			in = new FileReader(file);
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
			
			for(CSVRecord record: records) {
				long id = Integer.parseInt(record.get("book_id"));
				String isbn = record.get("isbn");
				String authors = record.get("authors");
				int year = Integer.parseInt(record.get("original_publication_year"));
				String title = record.get("original_title");
				double rating = Double.parseDouble(record.get("average_rating"));
				long ratingCount = Integer.parseInt(record.get("ratings_count"));
				String imageURL = record.get("image_url");
				
				Book myBook = new Book.Builder(id).setISBN(isbn).setAuthors(authors)
						.setYear(year).setTitle(title).setRating(rating)
						.setRatingCount(ratingCount).setImageURL(imageURL).build();
				books.add(myBook);
				LOG.debug("Added " + myBook);
			}
		}catch(IOException e) {
			LOG.error(e.getMessage(), e);
			throw new ApplicationException(e.getMessage());
		}
		
		return books;
		
	}
}
