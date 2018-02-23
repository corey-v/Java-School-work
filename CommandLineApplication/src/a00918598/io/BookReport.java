/**
 * Project: A00918598_Assignment1
 * File: BookReport.java
 * Date: Feb 22, 2018
 * Time: 3:42:32 PM
 */
package a00918598.io;

import java.util.Collection;

import a00918598.data.Book;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class BookReport {
	
	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%-8s %-12s %-40s %-40s %-4s %-6s %-13s %-60s%n";
	public static final String BOOK_FORMAT = "%08d %-12s %-40s %-40s %4d %6.3f %13d %-60s%n";
	
	/**
	 * private default constructor to prevent instantiation
	 */
	private BookReport() {	
	}

	public static void write(Collection<Book> books) {
		System.out.println("Books report");
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "ID", "ISBN", "Authors", "Title", "Year", "Rating", "Ratings Count", "Image URL");
		System.out.println(HORIZONTAL_LINE);
		
		for(Book book: books) {
			String author = book.getAuthors();
			if(author.length() > 40) {
				author = author.substring(0,37) + "...";
			}
			String title = book.getTitle();
			if(title.length() > 40) {
				title = title.substring(0, 37) + "...";
			}
			String imageURL = book.getImageURL();
			if(imageURL.length() > 60) {
				imageURL = imageURL.substring(0, 57) + "...";
			}
			System.out.format(BOOK_FORMAT, 
					book.getId(),
					book.getISBN(), 
					author, 
					title,
					book.getYear(),
					book.getRating(),
					book.getRatingCount(),
					imageURL);
		}
	
	}
	
	
}
