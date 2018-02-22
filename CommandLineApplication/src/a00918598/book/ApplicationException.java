/**
 * Project: Bcmc
 * File: ApplicationException.java
 * Date: Aug 18, 2016
 * Time: 1:59:25 PM
 */

package a00918598.book;

/**
 * @author Corey Valentyne A00918598
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	/**
	 * Construct an ApplicationException
	 * 
	 * @param message
	 *            the exception message.
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Construct an ApplicationException
	 * 
	 * @param throwable
	 *            a Throwable.
	 */
	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

}
