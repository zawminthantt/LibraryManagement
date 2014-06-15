package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the viewrecall table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="viewrecall"
 */

public abstract class BaseViewRecall  implements Serializable {

	public static String REF = "ViewRecall";
	public static String PROP_USER_TYPE = "userType";
	public static String PROP_BOOKLOAN_ID = "bookloanId";
	public static String PROP_SEND_DATE = "sendDate";
	public static String PROP_EMAIL = "email";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_ISBN = "ISBN";
	public static String PROP_CALLNUMBER_ID = "callnumber_id";
	public static String PROP_USERNAME = "username";
	public static String PROP_USER_ID = "userId";
	public static String PROP_TITLE = "title";


	// constructors
	public BaseViewRecall () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewRecall (java.lang.Integer bookloanId) {
		this.setBookloanId(bookloanId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer bookloanId;

	// fields
	private java.lang.String username;
	private java.lang.Integer userId;
	private java.lang.String email;
	private java.lang.String title;
	private java.lang.String callnumber_id;
	private java.lang.String iSBN;
	private java.util.Date dueDate;
	private java.lang.String userType;
	private java.util.Date sendDate;



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
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param username the user_name value
	 */
	public void setUsername (java.lang.String username) {
		this.username = username;
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
	 * Return the value associated with the column: user_email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: user_email
	 * @param email the user_email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
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
	public java.lang.String getCallnumber_id () {
		return callnumber_id;
	}

	/**
	 * Set the value related to the column: callnumber_id
	 * @param callnumber_id the callnumber_id value
	 */
	public void setCallnumber_id (java.lang.String callnumber_id) {
		this.callnumber_id = callnumber_id;
	}



	/**
	 * Return the value associated with the column: ISBN_no
	 */
	public java.lang.String getISBN () {
		return iSBN;
	}

	/**
	 * Set the value related to the column: ISBN_no
	 * @param iSBN the ISBN_no value
	 */
	public void setISBN (java.lang.String iSBN) {
		this.iSBN = iSBN;
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
	 * Return the value associated with the column: user_type
	 */
	public java.lang.String getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: user_type
	 * @param userType the user_type value
	 */
	public void setUserType (java.lang.String userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: send_date
	 */
	public java.util.Date getSendDate () {
		return sendDate;
	}

	/**
	 * Set the value related to the column: send_date
	 * @param sendDate the send_date value
	 */
	public void setSendDate (java.util.Date sendDate) {
		this.sendDate = sendDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewRecall)) return false;
		else {
			com.ictti.library.business.entity.ViewRecall viewRecall = (com.ictti.library.business.entity.ViewRecall) obj;
			if (null == this.getBookloanId() || null == viewRecall.getBookloanId()) return false;
			else return (this.getBookloanId().equals(viewRecall.getBookloanId()));
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