package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the view_reserve_book table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="view_reserve_book"
 */

public abstract class BaseViewReserveBook  implements Serializable {

	public static String REF = "ViewReserveBook";
	public static String PROP_USER_TYPE = "userType";
	public static String PROP_RESERVE_DATE = "reserveDate";
	public static String PROP_CALL_STATUS = "callStatus";
	public static String PROP_CALL_NUMBER_ID = "callNumberId";
	public static String PROP_AVAILABLE_DATE = "availableDate";
	public static String PROP_DUE_DATE = "dueDate";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_USER_ID = "userId";
	public static String PROP_TITLE = "title";
	public static String PROP_CALL_NUMBER_CODE = "callNumberCode";
	public static String PROP_EMAIL = "email";
	public static String PROP_AUTHOR_NAME = "authorName";
	public static String PROP_RESERVE_STATUS = "reserveStatus";
	public static String PROP_ID = "id";
	public static String PROP_ISBN = "isbn";


	// constructors
	public BaseViewReserveBook () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewReserveBook (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.Integer userId;
	private java.lang.String userName;
	private java.lang.String email;
	private java.lang.String userType;
	private java.lang.String isbn;
	private java.lang.String authorName;
	private int callNumberId;
	private java.lang.String callNumberCode;
	private java.lang.String title;
	private int callStatus;
	private int reserveStatus;
	private java.util.Date dueDate;
	private java.util.Date reserveDate;
	private java.util.Date availableDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="view_id"
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
	 * Return the value associated with the column: member_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: member_name
	 * @param userName the member_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: member_email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: member_email
	 * @param email the member_email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: member_type_name
	 */
	public java.lang.String getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: member_type_name
	 * @param userType the member_type_name value
	 */
	public void setUserType (java.lang.String userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: ISBN
	 */
	public java.lang.String getIsbn () {
		return isbn;
	}

	/**
	 * Set the value related to the column: ISBN
	 * @param isbn the ISBN value
	 */
	public void setIsbn (java.lang.String isbn) {
		this.isbn = isbn;
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
	 * Return the value associated with the column: callnumber_id
	 */
	public int getCallNumberId () {
		return callNumberId;
	}

	/**
	 * Set the value related to the column: callnumber_id
	 * @param callNumberId the callnumber_id value
	 */
	public void setCallNumberId (int callNumberId) {
		this.callNumberId = callNumberId;
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
	 * Return the value associated with the column: callStatus
	 */
	public int getCallStatus () {
		return callStatus;
	}

	/**
	 * Set the value related to the column: callStatus
	 * @param callStatus the callStatus value
	 */
	public void setCallStatus (int callStatus) {
		this.callStatus = callStatus;
	}



	/**
	 * Return the value associated with the column: reserveStatus
	 */
	public int getReserveStatus () {
		return reserveStatus;
	}

	/**
	 * Set the value related to the column: reserveStatus
	 * @param reserveStatus the reserveStatus value
	 */
	public void setReserveStatus (int reserveStatus) {
		this.reserveStatus = reserveStatus;
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
	 * Return the value associated with the column: reserve_date
	 */
	public java.util.Date getReserveDate () {
		return reserveDate;
	}

	/**
	 * Set the value related to the column: reserve_date
	 * @param reserveDate the reserve_date value
	 */
	public void setReserveDate (java.util.Date reserveDate) {
		this.reserveDate = reserveDate;
	}



	/**
	 * Return the value associated with the column: available_date
	 */
	public java.util.Date getAvailableDate () {
		return availableDate;
	}

	/**
	 * Set the value related to the column: available_date
	 * @param availableDate the available_date value
	 */
	public void setAvailableDate (java.util.Date availableDate) {
		this.availableDate = availableDate;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewReserveBook)) return false;
		else {
			com.ictti.library.business.entity.ViewReserveBook viewReserveBook = (com.ictti.library.business.entity.ViewReserveBook) obj;
			if (null == this.getId() || null == viewReserveBook.getId()) return false;
			else return (this.getId().equals(viewReserveBook.getId()));
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