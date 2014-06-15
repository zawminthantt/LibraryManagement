package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the view_most_rent_book table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="view_most_rent_book"
 */

public abstract class BaseViewMostRentBook  implements Serializable {

	public static String REF = "ViewMostRentBook";
	public static String PROP_RENT_TIMES = "rentTimes";
	public static String PROP_CATEGORY_NAME = "categoryName";
	public static String PROP_CATEGORY_ID = "categoryId";
	public static String PROP_PUB_DATE = "pubDate";
	public static String PROP_CALL_NUMBER_ID = "callNumberId";
	public static String PROP_PUBLISHER_NAME = "publisherName";
	public static String PROP_AUTHOR_NAME = "authorName";
	public static String PROP_SUB_CATEGORY_NAME = "subCategoryName";
	public static String PROP_REGISTER_DATE = "registerDate";
	public static String PROP_ID = "id";
	public static String PROP_ISBN = "isbn";
	public static String PROP_TITLE = "title";


	// constructors
	public BaseViewMostRentBook () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewMostRentBook (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String isbn;
	private java.lang.String title;
	private java.lang.Integer callNumberId;
	private java.lang.Integer categoryId;
	private java.lang.String categoryName;
	private java.lang.String subCategoryName;
	private java.lang.String authorName;
	private java.util.Date pubDate;
	private java.util.Date registerDate;
	private java.lang.String publisherName;
	private java.lang.Integer rentTimes;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_id"
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
	 * Return the value associated with the column: isbn
	 */
	public java.lang.String getIsbn () {
		return isbn;
	}

	/**
	 * Set the value related to the column: isbn
	 * @param isbn the isbn value
	 */
	public void setIsbn (java.lang.String isbn) {
		this.isbn = isbn;
	}



	/**
	 * Return the value associated with the column: title
	 */
	public java.lang.String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (java.lang.String title) {
		this.title = title;
	}



	/**
	 * Return the value associated with the column: callnumber_id
	 */
	public java.lang.Integer getCallNumberId () {
		return callNumberId;
	}

	/**
	 * Set the value related to the column: callnumber_id
	 * @param callNumberId the callnumber_id value
	 */
	public void setCallNumberId (java.lang.Integer callNumberId) {
		this.callNumberId = callNumberId;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public java.lang.Integer getCategoryId () {
		return categoryId;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param categoryId the category_id value
	 */
	public void setCategoryId (java.lang.Integer categoryId) {
		this.categoryId = categoryId;
	}



	/**
	 * Return the value associated with the column: category_name
	 */
	public java.lang.String getCategoryName () {
		return categoryName;
	}

	/**
	 * Set the value related to the column: category_name
	 * @param categoryName the category_name value
	 */
	public void setCategoryName (java.lang.String categoryName) {
		this.categoryName = categoryName;
	}



	/**
	 * Return the value associated with the column: subcategory_name
	 */
	public java.lang.String getSubCategoryName () {
		return subCategoryName;
	}

	/**
	 * Set the value related to the column: subcategory_name
	 * @param subCategoryName the subcategory_name value
	 */
	public void setSubCategoryName (java.lang.String subCategoryName) {
		this.subCategoryName = subCategoryName;
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
	 * Return the value associated with the column: published_date
	 */
	public java.util.Date getPubDate () {
		return pubDate;
	}

	/**
	 * Set the value related to the column: published_date
	 * @param pubDate the published_date value
	 */
	public void setPubDate (java.util.Date pubDate) {
		this.pubDate = pubDate;
	}



	/**
	 * Return the value associated with the column: register_date
	 */
	public java.util.Date getRegisterDate () {
		return registerDate;
	}

	/**
	 * Set the value related to the column: register_date
	 * @param registerDate the register_date value
	 */
	public void setRegisterDate (java.util.Date registerDate) {
		this.registerDate = registerDate;
	}



	/**
	 * Return the value associated with the column: publisher_name
	 */
	public java.lang.String getPublisherName () {
		return publisherName;
	}

	/**
	 * Set the value related to the column: publisher_name
	 * @param publisherName the publisher_name value
	 */
	public void setPublisherName (java.lang.String publisherName) {
		this.publisherName = publisherName;
	}



	/**
	 * Return the value associated with the column: rented_times
	 */
	public java.lang.Integer getRentTimes () {
		return rentTimes;
	}

	/**
	 * Set the value related to the column: rented_times
	 * @param rentTimes the rented_times value
	 */
	public void setRentTimes (java.lang.Integer rentTimes) {
		this.rentTimes = rentTimes;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewMostRentBook)) return false;
		else {
			com.ictti.library.business.entity.ViewMostRentBook viewMostRentBook = (com.ictti.library.business.entity.ViewMostRentBook) obj;
			if (null == this.getId() || null == viewMostRentBook.getId()) return false;
			else return (this.getId().equals(viewMostRentBook.getId()));
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