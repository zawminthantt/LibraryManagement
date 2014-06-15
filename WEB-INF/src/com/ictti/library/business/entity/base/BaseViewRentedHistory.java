package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the viewrentedhistory table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="viewrentedhistory"
 */

public abstract class BaseViewRentedHistory  implements Serializable {

	public static String REF = "ViewRentedHistory";
	public static String PROP_BOOKLOAN_ID = "bookloanId";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_CALL_NUMBER_ID = "callNumberId";
	public static String PROP_LATE_FEES = "lateFees";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_AUTHOR_NAME = "authorName";
	public static String PROP_BOOK_ID = "bookId";
	public static String PROP_CALL_NUMBER = "callNumber";
	public static String PROP_RETURN_DATE = "returnDate";
	public static String PROP_ISBN = "isbn";
	public static String PROP_USER_ID = "userId";
	public static String PROP_TITLE = "title";


	// constructors
	public BaseViewRentedHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewRentedHistory (java.lang.Integer bookloanId) {
		this.setBookloanId(bookloanId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer bookloanId;

	// fields
	private java.lang.Integer callNumberId;
	private java.lang.Integer bookId;
	private java.lang.Integer userId;
	private java.lang.String isbn;
	private java.lang.String title;
	private java.lang.String callNumber;
	private java.util.Date returnDate;
	private java.lang.String authorName;
	private java.util.Date issueDate;
	private java.util.Date dueDate;
	private java.lang.Integer lateFees;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_loan_id"
     */
	public java.lang.Integer getBookloanId () {
		return bookloanId;
	}

	/**
	 * Set the unique identifier of this class
	 * @param bookloanId the new ID
	 */
	public void setBookloanId (java.lang.Integer bookloanId) {
		this.bookloanId = bookloanId;
		this.hashCode = Integer.MIN_VALUE;
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
	 * Return the value associated with the column: book_id
	 */
	public java.lang.Integer getBookId () {
		return bookId;
	}

	/**
	 * Set the value related to the column: book_id
	 * @param bookId the book_id value
	 */
	public void setBookId (java.lang.Integer bookId) {
		this.bookId = bookId;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.Integer getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (java.lang.Integer userId) {
		this.userId = userId;
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
	 * Return the value associated with the column: call_number_code
	 */
	public java.lang.String getCallNumber () {
		return callNumber;
	}

	/**
	 * Set the value related to the column: call_number_code
	 * @param callNumber the call_number_code value
	 */
	public void setCallNumber (java.lang.String callNumber) {
		this.callNumber = callNumber;
	}



	/**
	 * Return the value associated with the column: return_date
	 */
	public java.util.Date getReturnDate () {
		return returnDate;
	}

	/**
	 * Set the value related to the column: return_date
	 * @param returnDate the return_date value
	 */
	public void setReturnDate (java.util.Date returnDate) {
		this.returnDate = returnDate;
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
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssueDate () {
		return issueDate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issueDate the issue_date value
	 */
	public void setIssueDate (java.util.Date issueDate) {
		this.issueDate = issueDate;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDueDate () {
		return dueDate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param dueDate the due_date value
	 */
	public void setDueDate (java.util.Date dueDate) {
		this.dueDate = dueDate;
	}



	/**
	 * Return the value associated with the column: late_fees
	 */
	public java.lang.Integer getLateFees () {
		return lateFees;
	}

	/**
	 * Set the value related to the column: late_fees
	 * @param lateFees the late_fees value
	 */
	public void setLateFees (java.lang.Integer lateFees) {
		this.lateFees = lateFees;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewRentedHistory)) return false;
		else {
			com.ictti.library.business.entity.ViewRentedHistory viewRentedHistory = (com.ictti.library.business.entity.ViewRentedHistory) obj;
			if (null == this.getBookloanId() || null == viewRentedHistory.getBookloanId()) return false;
			else return (this.getBookloanId().equals(viewRentedHistory.getBookloanId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getBookloanId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getBookloanId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}