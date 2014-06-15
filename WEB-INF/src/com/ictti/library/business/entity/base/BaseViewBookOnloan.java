package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the ViewBookOnloan table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="ViewBookOnloan"
 */

public abstract class BaseViewBookOnloan  implements Serializable {

	public static String REF = "ViewBookOnloan";
	public static String PROP_AUTHORID = "authorid";
	public static String PROP_USERID = "userid";
	public static String PROP_ISSUSESTATUS = "issusestatus";
	public static String PROP_ISBN = "ISBN";
	public static String PROP_DUEDATE = "duedate";
	public static String PROP_AUTHORNAME = "authorname";
	public static String PROP_TITLE = "title";
	public static String PROP_LOANSTATUS = "loanstatus";
	public static String PROP_ISSUEDATE = "issuedate";
	public static String PROP_USERNAME = "username";
	public static String PROP_BOOKID = "bookid";
	public static String PROP_ID = "id";
	public static String PROP_CALLNUMBERCODE = "callnumbercode";


	// constructors
	public BaseViewBookOnloan () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewBookOnloan (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseViewBookOnloan (
		java.lang.Integer id,
		java.lang.String callnumbercode) {

		this.setId(id);
		this.setCallnumbercode(callnumbercode);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String callnumbercode;
	private java.lang.Integer issusestatus;
	private java.lang.Integer bookid;
	private java.lang.Integer authorid;
	private java.lang.String title;
	private java.lang.String iSBN;
	private java.lang.String authorname;
	private java.lang.Integer userid;
	private java.lang.String username;
	private java.lang.Integer loanstatus;
	private java.util.Date issuedate;
	private java.util.Date duedate;



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
	public java.lang.String getCallnumbercode () {
		return callnumbercode;
	}

	/**
	 * Set the value related to the column: call_number_code
	 * @param callnumbercode the call_number_code value
	 */
	public void setCallnumbercode (java.lang.String callnumbercode) {
		this.callnumbercode = callnumbercode;
	}



	/**
	 * Return the value associated with the column: issuse_status
	 */
	public java.lang.Integer getIssusestatus () {
		return issusestatus;
	}

	/**
	 * Set the value related to the column: issuse_status
	 * @param issusestatus the issuse_status value
	 */
	public void setIssusestatus (java.lang.Integer issusestatus) {
		this.issusestatus = issusestatus;
	}



	/**
	 * Return the value associated with the column: book_id
	 */
	public java.lang.Integer getBookid () {
		return bookid;
	}

	/**
	 * Set the value related to the column: book_id
	 * @param bookid the book_id value
	 */
	public void setBookid (java.lang.Integer bookid) {
		this.bookid = bookid;
	}



	/**
	 * Return the value associated with the column: author_id
	 */
	public java.lang.Integer getAuthorid () {
		return authorid;
	}

	/**
	 * Set the value related to the column: author_id
	 * @param authorid the author_id value
	 */
	public void setAuthorid (java.lang.Integer authorid) {
		this.authorid = authorid;
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
	 * Return the value associated with the column: author_name
	 */
	public java.lang.String getAuthorname () {
		return authorname;
	}

	/**
	 * Set the value related to the column: author_name
	 * @param authorname the author_name value
	 */
	public void setAuthorname (java.lang.String authorname) {
		this.authorname = authorname;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public java.lang.Integer getUserid () {
		return userid;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userid the user_id value
	 */
	public void setUserid (java.lang.Integer userid) {
		this.userid = userid;
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
	 * Return the value associated with the column: loan_status
	 */
	public java.lang.Integer getLoanstatus () {
		return loanstatus;
	}

	/**
	 * Set the value related to the column: loan_status
	 * @param loanstatus the loan_status value
	 */
	public void setLoanstatus (java.lang.Integer loanstatus) {
		this.loanstatus = loanstatus;
	}



	/**
	 * Return the value associated with the column: issue_date
	 */
	public java.util.Date getIssuedate () {
		return issuedate;
	}

	/**
	 * Set the value related to the column: issue_date
	 * @param issuedate the issue_date value
	 */
	public void setIssuedate (java.util.Date issuedate) {
		this.issuedate = issuedate;
	}



	/**
	 * Return the value associated with the column: due_date
	 */
	public java.util.Date getDuedate () {
		return duedate;
	}

	/**
	 * Set the value related to the column: due_date
	 * @param duedate the due_date value
	 */
	public void setDuedate (java.util.Date duedate) {
		this.duedate = duedate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewBookOnloan)) return false;
		else {
			com.ictti.library.business.entity.ViewBookOnloan viewBookOnloan = (com.ictti.library.business.entity.ViewBookOnloan) obj;
			if (null == this.getId() || null == viewBookOnloan.getId()) return false;
			else return (this.getId().equals(viewBookOnloan.getId()));
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