package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the book_reserve table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="book_reserve"
 */

public abstract class BaseBookReserve  implements Serializable {

	public static String REF = "BookReserve";
	public static String PROP_USER = "user";
	public static String PROP_RESERVE_DATE = "reserveDate";
	public static String PROP_AVAIL_DATE = "availDate";
	public static String PROP_CALLNUMBER = "callnumber";
	public static String PROP_RESERVE_STATUS = "reserveStatus";
	public static String PROP_ID = "id";


	// constructors
	public BaseBookReserve () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseBookReserve (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.util.Date reserveDate;
	private java.lang.Integer reserveStatus;
	private java.util.Date availDate;

	// many to one
	private com.ictti.library.business.entity.CallNumber callnumber;
	private com.ictti.library.business.entity.User user;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="book_reserve_id"
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
	 * Return the value associated with the column: reserve_status
	 */
	public java.lang.Integer getReserveStatus () {
		return reserveStatus;
	}

	/**
	 * Set the value related to the column: reserve_status
	 * @param reserveStatus the reserve_status value
	 */
	public void setReserveStatus (java.lang.Integer reserveStatus) {
		this.reserveStatus = reserveStatus;
	}



	/**
	 * Return the value associated with the column: avail_date
	 */
	public java.util.Date getAvailDate () {
		return availDate;
	}

	/**
	 * Set the value related to the column: avail_date
	 * @param availDate the avail_date value
	 */
	public void setAvailDate (java.util.Date availDate) {
		this.availDate = availDate;
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




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.BookReserve)) return false;
		else {
			com.ictti.library.business.entity.BookReserve bookReserve = (com.ictti.library.business.entity.BookReserve) obj;
			if (null == this.getId() || null == bookReserve.getId()) return false;
			else return (this.getId().equals(bookReserve.getId()));
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