package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the book_on_loan table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="book_on_loan"
 */

public abstract class BaseBookOnLoan  implements Serializable {

	public static String REF = "BookOnLoan";
	public static String PROP_USER = "user";
	public static String PROP_LOAN_STATUS = "loanStatus";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_CALLNUMBER = "callnumber";
	public static String PROP_LATE_FEES = "lateFees";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_ID = "id";
	public static String PROP_RETURN_DATE = "returnDate";


	// constructors
	public BaseBookOnLoan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBookOnLoan (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseBookOnLoan (
		java.lang.Integer id,
		com.ictti.library.business.entity.User user) {

		this.setId(id);
		this.setUser(user);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date issueDate;
	private java.util.Date returnDate;
	private java.util.Date dueDate;
	private java.lang.Integer lateFees;
	private java.lang.Integer loanStatus;

	// many to one
	private com.ictti.library.business.entity.CallNumber callnumber;
	private com.ictti.library.business.entity.User user;

	// collections
	private java.util.Set<com.ictti.library.business.entity.EmailLog> emailLogs;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_loan_id"
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



	/**
	 * Return the value associated with the column: loan_status
	 */
	public java.lang.Integer getLoanStatus () {
		return loanStatus;
	}

	/**
	 * Set the value related to the column: loan_status
	 * @param loanStatus the loan_status value
	 */
	public void setLoanStatus (java.lang.Integer loanStatus) {
		this.loanStatus = loanStatus;
	}



	/**
	 * Return the value associated with the column: callnumber_id
	 */
	public com.ictti.library.business.entity.CallNumber getCallnumber () {
		return callnumber;
	}

	/**
	 * Set the value related to the column: callnumber_id
	 * @param callnumber the callnumber_id value
	 */
	public void setCallnumber (com.ictti.library.business.entity.CallNumber callnumber) {
		this.callnumber = callnumber;
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



	/**
	 * Return the value associated with the column: emailLogs
	 */
	public java.util.Set<com.ictti.library.business.entity.EmailLog> getEmailLogs () {
		return emailLogs;
	}

	/**
	 * Set the value related to the column: emailLogs
	 * @param emailLogs the emailLogs value
	 */
	public void setEmailLogs (java.util.Set<com.ictti.library.business.entity.EmailLog> emailLogs) {
		this.emailLogs = emailLogs;
	}

	public void addToemailLogs (com.ictti.library.business.entity.EmailLog emailLog) {
		if (null == getEmailLogs()) setEmailLogs(new java.util.TreeSet<com.ictti.library.business.entity.EmailLog>());
		getEmailLogs().add(emailLog);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.BookOnLoan)) return false;
		else {
			com.ictti.library.business.entity.BookOnLoan bookOnLoan = (com.ictti.library.business.entity.BookOnLoan) obj;
			if (null == this.getId() || null == bookOnLoan.getId()) return false;
			else return (this.getId().equals(bookOnLoan.getId()));
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