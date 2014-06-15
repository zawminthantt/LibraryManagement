package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the publisher table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="publisher"
 */

public abstract class BasePublisher  implements Serializable {

	public static String REF = "Publisher";
	public static String PROP_PUB_ADDRESS = "pubAddress";
	public static String PROP_PUB_NAME = "pubName";
	public static String PROP_ID = "id";


	// constructors
	public BasePublisher () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePublisher (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String pubName;
	private java.lang.String pubAddress;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookList> bookLists;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="pub_id"
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
	 * Return the value associated with the column: pub_name
	 */
	public java.lang.String getPubName () {
		return pubName;
	}

	/**
	 * Set the value related to the column: pub_name
	 * @param pubName the pub_name value
	 */
	public void setPubName (java.lang.String pubName) {
		this.pubName = pubName;
	}



	/**
	 * Return the value associated with the column: pub_address
	 */
	public java.lang.String getPubAddress () {
		return pubAddress;
	}

	/**
	 * Set the value related to the column: pub_address
	 * @param pubAddress the pub_address value
	 */
	public void setPubAddress (java.lang.String pubAddress) {
		this.pubAddress = pubAddress;
	}



	/**
	 * Return the value associated with the column: bookLists
	 */
	public java.util.Set<com.ictti.library.business.entity.BookList> getBookLists () {
		return bookLists;
	}

	/**
	 * Set the value related to the column: bookLists
	 * @param bookLists the bookLists value
	 */
	public void setBookLists (java.util.Set<com.ictti.library.business.entity.BookList> bookLists) {
		this.bookLists = bookLists;
	}

	public void addTobookLists (com.ictti.library.business.entity.BookList bookList) {
		if (null == getBookLists()) setBookLists(new java.util.TreeSet<com.ictti.library.business.entity.BookList>());
		getBookLists().add(bookList);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.Publisher)) return false;
		else {
			com.ictti.library.business.entity.Publisher publisher = (com.ictti.library.business.entity.Publisher) obj;
			if (null == this.getId() || null == publisher.getId()) return false;
			else return (this.getId().equals(publisher.getId()));
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