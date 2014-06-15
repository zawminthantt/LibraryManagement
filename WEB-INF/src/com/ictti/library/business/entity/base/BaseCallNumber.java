package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the call_number table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="call_number"
 */

public abstract class BaseCallNumber  implements Serializable {

	public static String REF = "CallNumber";
	public static String PROP_BOOK = "book";
	public static String PROP_ISSUSE_STATUS = "issuseStatus";
	public static String PROP_CALL_NUMBER_CODE = "callNumberCode";
	public static String PROP_AUTHOR = "author";
	public static String PROP_ID = "id";
	public static String PROP_ACCESSION = "accession";
	public static String PROP_ACCESSION_NO = "accessionNo";


	// constructors
	public BaseCallNumber () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCallNumber (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCallNumber (
		java.lang.Integer id,
		java.lang.String callNumberCode) {

		this.setId(id);
		this.setCallNumberCode(callNumberCode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String callNumberCode;
	private java.lang.Integer issuseStatus;
	private java.lang.Integer accessionNo;

	// many to one
	private com.ictti.library.business.entity.BookList book;
	private com.ictti.library.business.entity.Author author;
	private com.ictti.library.business.entity.AccessionCode accession;

	// collections
	private java.util.Set<com.ictti.library.business.entity.BookOnLoan> bookOnLoans;
	private java.util.Set<com.ictti.library.business.entity.BookReserve> bookReserves;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="callnumber_id"
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
	 * Return the value associated with the column: call_number_code
	 */
	public java.lang.String getCallNumberCode () {
		return callNumberCode;
	}

	/**
	 * Set the value related to the column: call_number_code
	 * @param callNumberCode the call_number_code value
	 */
	public void setCallNumberCode (java.lang.String callNumberCode) {
		this.callNumberCode = callNumberCode;
	}



	/**
	 * Return the value associated with the column: issuse_status
	 */
	public java.lang.Integer getIssuseStatus () {
		return issuseStatus;
	}

	/**
	 * Set the value related to the column: issuse_status
	 * @param issuseStatus the issuse_status value
	 */
	public void setIssuseStatus (java.lang.Integer issuseStatus) {
		this.issuseStatus = issuseStatus;
	}



	/**
	 * Return the value associated with the column: accession_no
	 */
	public java.lang.Integer getAccessionNo () {
		return accessionNo;
	}

	/**
	 * Set the value related to the column: accession_no
	 * @param accessionNo the accession_no value
	 */
	public void setAccessionNo (java.lang.Integer accessionNo) {
		this.accessionNo = accessionNo;
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



	/**
	 * Return the value associated with the column: accession_id
	 */
	public com.ictti.library.business.entity.AccessionCode getAccession () {
		return accession;
	}

	/**
	 * Set the value related to the column: accession_id
	 * @param accession the accession_id value
	 */
	public void setAccession (com.ictti.library.business.entity.AccessionCode accession) {
		this.accession = accession;
	}



	/**
	 * Return the value associated with the column: bookOnLoans
	 */
	public java.util.Set<com.ictti.library.business.entity.BookOnLoan> getBookOnLoans () {
		return bookOnLoans;
	}

	/**
	 * Set the value related to the column: bookOnLoans
	 * @param bookOnLoans the bookOnLoans value
	 */
	public void setBookOnLoans (java.util.Set<com.ictti.library.business.entity.BookOnLoan> bookOnLoans) {
		this.bookOnLoans = bookOnLoans;
	}

	public void addTobookOnLoans (com.ictti.library.business.entity.BookOnLoan bookOnLoan) {
		if (null == getBookOnLoans()) setBookOnLoans(new java.util.TreeSet<com.ictti.library.business.entity.BookOnLoan>());
		getBookOnLoans().add(bookOnLoan);
	}



	/**
	 * Return the value associated with the column: bookReserves
	 */
	public java.util.Set<com.ictti.library.business.entity.BookReserve> getBookReserves () {
		return bookReserves;
	}

	/**
	 * Set the value related to the column: bookReserves
	 * @param bookReserves the bookReserves value
	 */
	public void setBookReserves (java.util.Set<com.ictti.library.business.entity.BookReserve> bookReserves) {
		this.bookReserves = bookReserves;
	}

	public void addTobookReserves (com.ictti.library.business.entity.BookReserve bookReserve) {
		if (null == getBookReserves()) setBookReserves(new java.util.TreeSet<com.ictti.library.business.entity.BookReserve>());
		getBookReserves().add(bookReserve);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.CallNumber)) return false;
		else {
			com.ictti.library.business.entity.CallNumber callNumber = (com.ictti.library.business.entity.CallNumber) obj;
			if (null == this.getId() || null == callNumber.getId()) return false;
			else return (this.getId().equals(callNumber.getId()));
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