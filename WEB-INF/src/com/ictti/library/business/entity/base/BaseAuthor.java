package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the author table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="author"
 */

public abstract class BaseAuthor  implements Serializable {

	public static String REF = "Author";
	public static String PROP_AUTHOR_INIT_NAME = "authorInitName";
	public static String PROP_AUTHOR_NAME = "authorName";
	public static String PROP_ID = "id";


	// constructors
	public BaseAuthor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAuthor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String authorName;
	private java.lang.String authorInitName;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookAuthor> bookAuthors;
	private java.util.Set<com.ictti.library.business.entity.CallNumber> callNumbers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="author_id"
     */
	public java.lang.Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (java.lang.Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: author_name
	 */
	public java.lang.String getAuthorName () {
		return authorName;
	}

	/**
	 * Set the value related to the column: author_name
	 * @param authorName the author_name value
	 */
	public void setAuthorName (java.lang.String authorName) {
		this.authorName = authorName;
	}



	/**
	 * Return the value associated with the column: author_init_name
	 */
	public java.lang.String getAuthorInitName () {
		return authorInitName;
	}

	/**
	 * Set the value related to the column: author_init_name
	 * @param authorInitName the author_init_name value
	 */
	public void setAuthorInitName (java.lang.String authorInitName) {
		this.authorInitName = authorInitName;
	}



	/**
	 * Return the value associated with the column: bookAuthors
	 */
	public java.util.Set<com.ictti.library.business.entity.BookAuthor> getBookAuthors () {
		return bookAuthors;
	}

	/**
	 * Set the value related to the column: bookAuthors
	 * @param bookAuthors the bookAuthors value
	 */
	public void setBookAuthors (java.util.Set<com.ictti.library.business.entity.BookAuthor> bookAuthors) {
		this.bookAuthors = bookAuthors;
	}

	public void addTobookAuthors (com.ictti.library.business.entity.BookAuthor bookAuthor) {
		if (null == getBookAuthors()) setBookAuthors(new java.util.TreeSet<com.ictti.library.business.entity.BookAuthor>());
		getBookAuthors().add(bookAuthor);
	}



	/**
	 * Return the value associated with the column: callNumbers
	 */
	public java.util.Set<com.ictti.library.business.entity.CallNumber> getCallNumbers () {
		return callNumbers;
	}

	/**
	 * Set the value related to the column: callNumbers
	 * @param callNumbers the callNumbers value
	 */
	public void setCallNumbers (java.util.Set<com.ictti.library.business.entity.CallNumber> callNumbers) {
		this.callNumbers = callNumbers;
	}

	public void addTocallNumbers (com.ictti.library.business.entity.CallNumber callNumber) {
		if (null == getCallNumbers()) setCallNumbers(new java.util.TreeSet<com.ictti.library.business.entity.CallNumber>());
		getCallNumbers().add(callNumber);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.Author)) return false;
		else {
			com.ictti.library.business.entity.Author author = (com.ictti.library.business.entity.Author) obj;
			if (null == this.getId() || null == author.getId()) return false;
			else return (this.getId().equals(author.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}