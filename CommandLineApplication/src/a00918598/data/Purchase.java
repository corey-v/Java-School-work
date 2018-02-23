/**
 * Project: A00918598_Assignment1
 * File: Purchase.java
 * Date: Feb 22, 2018
 * Time: 5:26:49 PM
 */
package a00918598.data;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class Purchase {
	
	private long customerID;
	private long bookID;
	private double price;
	private String firstName;
	private String lastName;
	private String bookTitle;
	
	public static class Builder{
		//Required parameters
		private final long customerID;
		private final long bookID;
		private final double price;
		
		//Optional parameters
		private String firstName;
		private String lastName;
		private String bookTitle;
		
		public Builder(long customerID, long bookID, double price) {
			this.customerID = customerID;
			this.bookID = bookID;
			this.price = price;
		}
		
		public Purchase build() {
			return new Purchase(this);
		}
		
		public Builder setFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
			return this;
		}
	}
	
	/**
	 * Defaul
	 */
	private Purchase(Builder builder) {
		customerID = builder.customerID;
		bookID = builder.bookID;
		price = builder.price;
		firstName = builder.firstName;
		lastName = builder.lastName;
		bookTitle = builder.bookTitle;
	}

	/**
	 * @return the customerID
	 */
	public long getcustomerID() {
		return customerID;
	}

	/**
	 * @param customerID the customerID to set
	 */
	public void setcustomerID(long customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the bookID
	 */
	public long getbookID() {
		return bookID;
	}

	/**
	 * @param bookID the bookID to set
	 */
	public void setbookID(long bookID) {
		this.bookID = bookID;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Purchase [customerID=" + customerID + ", bookID=" + bookID + ", price=" + price + ", firstName="
				+ firstName + ", lastName=" + lastName + ", bookTitle=" + bookTitle + "]";
	}
	
	
}
