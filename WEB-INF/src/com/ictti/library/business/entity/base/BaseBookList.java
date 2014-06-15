package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the book_list table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="book_list"
 */

public abstract class BaseBookList  implements Serializable {

	public static String REF = "BookList";
	public static String PROP_NO_OF_COPY = "noOfCopy";
	public static String PROP_REGISTER_DATE = "registerDate";
	public static String PROP_SUBCATEGORY = "subcategory";
	public static String PROP_ORG_NAME = "orgName";
	public static String PROP_TITLE = "title";
	public static String PROP_YEAR = "year";
	public static String PROP_CATEGORY = "category";
	public static String PROP_ISBN_NO = "isbnNo";
	public static String PROP_EDITION = "edition";
	public static String PROP_PRICE = "price";
	public static String PROP_PUB = "pub";
	public static String PROP_NO_OF_PAGES = "noOfPages";
	public static String PROP_ID = "id";
	public static String PROP_REMARK = "remark";
	public static String PROP_RESOURCES = "resources";


	// constructors
	public BaseBookList () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBookList (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date registerDate;
	private java.lang.String title;
	private java.lang.String isbnNo;
	private java.lang.String edition;
	private java.lang.Integer price;
	private java.lang.String remark;
	private java.util.Date year;
	private java.lang.Integer noOfCopy;
	private java.lang.Integer noOfPages;
	private java.lang.String orgName;
	private java.lang.String resources;

	// many to one
	private com.ictti.library.business.entity.SubCategory subcategory;
	private com.ictti.library.business.entity.Publisher pub;
	private com.ictti.library.business.entity.Category category;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookAuthor> bookAuthors;
	private java.util.Set<com.ictti.library.business.entity.Photo> photos;
	private java.util.Set<com.ictti.library.business.entity.CallNumber> callNumbers;



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
	 * Return the value associated with the column: ISBN_no
	 */
	public java.lang.String getIsbnNo () {
		return isbnNo;
	}

	/**
	 * Set the value related to the column: ISBN_no
	 * @param isbnNo the ISBN_no value
	 */
	public void setIsbnNo (java.lang.String isbnNo) {
		this.isbnNo = isbnNo;
	}



	/**
	 * Return the value associated with the column: edition
	 */
	public java.lang.String getEdition () {
		return edition;
	}

	/**
	 * Set the value related to the column: edition
	 * @param edition the edition value
	 */
	public void setEdition (java.lang.String edition) {
		this.edition = edition;
	}



	/**
	 * Return the value associated with the column: price
	 */
	public java.lang.Integer getPrice () {
		return price;
	}

	/**
	 * Set the value related to the column: price
	 * @param price the price value
	 */
	public void setPrice (java.lang.Integer price) {
		this.price = price;
	}



	/**
	 * Return the value associated with the column: remark
	 */
	public java.lang.String getRemark () {
		return remark;
	}

	/**
	 * Set the value related to the column: remark
	 * @param remark the remark value
	 */
	public void setRemark (java.lang.String remark) {
		this.remark = remark;
	}



	/**
	 * Return the value associated with the column: year
	 */
	public java.util.Date getYear () {
		return year;
	}

	/**
	 * Set the value related to the column: year
	 * @param year the year value
	 */
	public void setYear (java.util.Date year) {
		this.year = year;
	}



	/**
	 * Return the value associated with the column: no_of_copy
	 */
	public java.lang.Integer getNoOfCopy () {
		return noOfCopy;
	}

	/**
	 * Set the value related to the column: no_of_copy
	 * @param noOfCopy the no_of_copy value
	 */
	public void setNoOfCopy (java.lang.Integer noOfCopy) {
		this.noOfCopy = noOfCopy;
	}



	/**
	 * Return the value associated with the column: no_of_pages
	 */
	public java.lang.Integer getNoOfPages () {
		return noOfPages;
	}

	/**
	 * Set the value related to the column: no_of_pages
	 * @param noOfPages the no_of_pages value
	 */
	public void setNoOfPages (java.lang.Integer noOfPages) {
		this.noOfPages = noOfPages;
	}



	/**
	 * Return the value associated with the column: org_name
	 */
	public java.lang.String getOrgName () {
		return orgName;
	}

	/**
	 * Set the value related to the column: org_name
	 * @param orgName the org_name value
	 */
	public void setOrgName (java.lang.String orgName) {
		this.orgName = orgName;
	}



	/**
	 * Return the value associated with the column: resources
	 */
	public java.lang.String getResources () {
		return resources;
	}

	/**
	 * Set the value related to the column: resources
	 * @param resources the resources value
	 */
	public void setResources (java.lang.String resources) {
		this.resources = resources;
	}



	/**
	 * Return the value associated with the column: subcategory_id
	 */
	public com.ictti.library.business.entity.SubCategory getSubcategory () {
		return subcategory;
	}

	/**
	 * Set the value related to the column: subcategory_id
	 * @param subcategory the subcategory_id value
	 */
	public void setSubcategory (com.ictti.library.business.entity.SubCategory subcategory) {
		this.subcategory = subcategory;
	}



	/**
	 * Return the value associated with the column: pub_id
	 */
	public com.ictti.library.business.entity.Publisher getPub () {
		return pub;
	}

	/**
	 * Set the value related to the column: pub_id
	 * @param pub the pub_id value
	 */
	public void setPub (com.ictti.library.business.entity.Publisher pub) {
		this.pub = pub;
	}



	/**
	 * Return the value associated with the column: category_id
	 */
	public com.ictti.library.business.entity.Category getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category_id
	 * @param category the category_id value
	 */
	public void setCategory (com.ictti.library.business.entity.Category category) {
		this.category = category;
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
	 * Return the value associated with the column: photos
	 */
	public java.util.Set<com.ictti.library.business.entity.Photo> getPhotos () {
		return photos;
	}

	/**
	 * Set the value related to the column: photos
	 * @param photos the photos value
	 */
	public void setPhotos (java.util.Set<com.ictti.library.business.entity.Photo> photos) {
		this.photos = photos;
	}

	public void addTophotos (com.ictti.library.business.entity.Photo photo) {
		if (null == getPhotos()) setPhotos(new java.util.TreeSet<com.ictti.library.business.entity.Photo>());
		getPhotos().add(photo);
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
		if (!(obj instanceof com.ictti.library.business.entity.BookList)) return false;
		else {
			com.ictti.library.business.entity.BookList bookList = (com.ictti.library.business.entity.BookList) obj;
			if (null == this.getId() || null == bookList.getId()) return false;
			else return (this.getId().equals(bookList.getId()));
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