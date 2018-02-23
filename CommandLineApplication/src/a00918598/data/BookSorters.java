/**
 * Project: A00918598_Assignment1
 * File: BookSorters.java
 * Date: Feb 22, 2018
 * Time: 8:29:23 PM
 */
package a00918598.data;

import java.util.Comparator;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class BookSorters {

	public static class CompareByAuthorName implements Comparator<Book> {
		@Override
		public int compare(Book book1, Book book2) {
			return book1.getAuthors().compareTo(book2.getAuthors());
		}
	}

}
