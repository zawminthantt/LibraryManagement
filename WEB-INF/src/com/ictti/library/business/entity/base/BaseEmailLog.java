package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the email_log table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="email_log"
 */

public abstract class BaseEmailLog  implements Serializable {

	public static String REF = "EmailLog";
	public static String PROP_USER = "user";
	public static String PROP_REMIND_DATE = "remindDate";
	public static String PROP_ID = "id";
	public static String PROP_BOOK_LOAN = "bookLoan";
	public static String PROP_EMAIL_STATUS = "emailStatus";


	// constructors
	public BaseEmailLog () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseEmailLog (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseEmailLog (
		java.lang.Integer id,
		com.ictti.library.business.entity.BookOnLoan bookLoan,
		com.ictti.library.business.entity.User user) {

		this.setId(id);
		this.setBookLoan(bookLoan);
		this.setUser(user);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date remindDate;
	private java.lang.String emailStatus;

	// many to one
	private com.ictti.library.business.entity.BookOnLoan bookLoan;
	private com.ictti.library.business.entity.User user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="email_id"
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
	 * Return the value associated with the column: remind_date
	 */
	public java.util.Date getRemindDate () {
		return remindDate;
	}

	/**
	 * Set the value related to the column: remind_date
	 * @param remindDate the remind_date value
	 */
	public void setRemindDate (java.util.Date remindDate) {
		this.remindDate = remindDate;
	}



	/**
	 * Return the value associated with the column: email_status
	 */
	public java.lang.String getEmailStatus () {
		return emailStatus;
	}

	/**
	 * Set the value related to the column: email_status
	 * @param emailStatus the email_status value
	 */
	public void setEmailStatus (java.lang.String emailStatus) {
		this.emailStatus = emailStatus;
	}



	/**
	 * Return the value associated with the column: book_loan_id
	 */
	public com.ictti.library.business.entity.BookOnLoan getBookLoan () {
		return bookLoan;
	}

	/**
	 * Set the value related to the column: book_loan_id
	 * @param bookLoan the book_loan_id value
	 */
	public void setBookLoan (com.ictti.library.business.entity.BookOnLoan bookLoan) {
		this.bookLoan = bookLoan;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public com.ictti.library.business.entity.User getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (com.ictti.library.business.entity.User user) {
		this.user = user;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.EmailLog)) return false;
		else {
			com.ictti.library.business.entity.EmailLog emailLog = (com.ictti.library.business.entity.EmailLog) obj;
			if (null == this.getId() || null == emailLog.getId()) return false;
			else return (this.getId().equals(emailLog.getId()));
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