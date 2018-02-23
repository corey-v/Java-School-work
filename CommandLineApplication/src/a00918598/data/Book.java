/**
 * Project: A00918598_Assignment1
 * File: Book.java
 * Date: Feb 21, 2018
 * Time: 7:35:48 PM
 */
package a00918598.data;

/**
 * @author Corey Valentyne A00918598
 *
 */
public class Book {
	
	private long id;
	private String isbn;
	private String authors;
	private String title;
	private int year;
	private double rating;
	private long ratingCount;
	private String imageURL;
	
	public static class Builder{
		//Required parameters
		private final long id;
		
		//Optional parameters
		private String isbn;
		private String authors;
		private int year;
		private String title;
		private double rating;
		private long ratingCount;
		private String imageURL;
		
		public Builder(long id) {
			this.id = id;
		}
		
		/**
		 * 
		 * @param isbn A String for the ISBN to set
		 * 
		 */
		public Builder setISBN(String isbn) {
			this.isbn = isbn;
			return this;
		}
		
		/**
		 * 
		 * @param authors A String for the authors to set
		 *
		 */
		public Builder setAuthors(String authors) {
			this.authors = authors;
			return this;
		}
		
		/**
		 * 
		 * @param year an int for the year to set
		 *
		 */
		public Builder setYear(int year) {
			this.year = year;
			return this;
		}
		
		/**
		 * 
		 * @param title A String for the title to set
		 *
		 */
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * 
		 * @param rating a double for the rating to set
		 * 
		 */
		public Builder setRating(double rating) {
			this.rating = rating;
			return this;
		}
		
		/**
		 * 
		 * @param ratingCount an int for the ratingCount to set
		 * 
		 */
		public Builder setRatingCount(long ratingCount) {
			this.ratingCount = ratingCount;
			return this;
		}
		
		/**
		 * 
		 * @param imageURL A String for the imageURL to set
		 * 
		 */
		public Builder setImageURL(String imageURL) {
			this.imageURL = imageURL;
			return this;
		}
		
		public Book build() {
			return new Book(this);
		}
	}
	/**
	 * Default constructor
	 */
	private Book(Builder builder) {
		id = builder.id;
		isbn = builder.isbn;
		authors = builder.authors;
		year = builder.year;
		title = builder.title;
		rating = builder.rating;
		ratingCount = builder.ratingCount;
		imageURL = builder.imageURL;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * @return the isbn
	 */
	public String getISBN() {
		return isbn;
	}
	
	/**
	 * @param isbn the isbn to set
	 */
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}
	
	/**
	 * @param authors the authors to set
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * @return the ratingCount
	 */
	public long getRatingCount() {
		return ratingCount;
	}
	
	/**
	 * @param ratingCount the ratingCount to set
	 */
	public void setRatingCount(long ratingCount) {
		this.ratingCount = ratingCount;
	}
	
	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}
	
	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", authors=" + authors + ", year=" + year + ", title=" + title
				+ ", rating=" + rating + ", ratingCount=" + ratingCount + ", imageURL=" + imageURL + "]";
	}

	
	
}
