package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the book_author table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="book_author"
 */

public abstract class BaseBookAuthor  implements Serializable {

	public static String REF = "BookAuthor";
	public static String PROP_BOOK = "book";
	public static String PROP_AUTHOR = "author";
	public static String PROP_ID = "id";


	// constructors
	public BaseBookAuthor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBookAuthor (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// many to one
	private com.ictti.library.business.entity.BookList book;
	private com.ictti.library.business.entity.Author author;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_author_id"
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
	 * Return the value associated with the column: book_id
	 */
	public com.ictti.library.business.entity.BookList getBook () {
		return book;
	}

	/**
	 * Set the value related to the column: book_id
	 * @param book the book_id value
	 */
	public void setBook (com.ictti.library.business.entity.BookList book) {
		this.book = book;
	}



	/**
	 * Return the value associated with the column: author_id
	 */
	public com.ictti.library.business.entity.Author getAuthor () {
		return author;
	}

	/**
	 * Set the value related to the column: author_id
	 * @param author the author_id value
	 */
	public void setAuthor (com.ictti.library.business.entity.Author author) {
		this.author = author;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.BookAuthor)) return false;
		else {
			com.ictti.library.business.entity.BookAuthor bookAuthor = (com.ictti.library.business.entity.BookAuthor) obj;
			if (null == this.getId() || null == bookAuthor.getId()) return false;
			else return (this.getId().equals(bookAuthor.getId()));
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