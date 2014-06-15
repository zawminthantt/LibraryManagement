package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_type table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_type"
 */

public abstract class BaseUserType  implements Serializable {

	public static String REF = "UserType";
	public static String PROP_LOAN_PERIOD = "loanPeriod";
	public static String PROP_USER_TYPE_NAME = "userTypeName";
	public static String PROP_ID = "id";


	// constructors
	public BaseUserType () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserType (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userTypeName;
	private java.lang.Integer loanPeriod;

	// collections
	private java.util.Set<com.ictti.library.business.entity.User> users;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="user_type_id"
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
	 * Return the value associated with the column: user_type_name
	 */
	public java.lang.String getUserTypeName () {
		return userTypeName;
	}

	/**
	 * Set the value related to the column: user_type_name
	 * @param userTypeName the user_type_name value
	 */
	public void setUserTypeName (java.lang.String userTypeName) {
		this.userTypeName = userTypeName;
	}



	/**
	 * Return the value associated with the column: loan_period
	 */
	public java.lang.Integer getLoanPeriod () {
		return loanPeriod;
	}

	/**
	 * Set the value related to the column: loan_period
	 * @param loanPeriod the loan_period value
	 */
	public void setLoanPeriod (java.lang.Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}



	/**
	 * Return the value associated with the column: users
	 */
	public java.util.Set<com.ictti.library.business.entity.User> getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: users
	 * @param users the users value
	 */
	public void setUsers (java.util.Set<com.ictti.library.business.entity.User> users) {
		this.users = users;
	}

	public void addTousers (com.ictti.library.business.entity.User user) {
		if (null == getUsers()) setUsers(new java.util.TreeSet<com.ictti.library.business.entity.User>());
		getUsers().add(user);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.UserType)) return false;
		else {
			com.ictti.library.business.entity.UserType userType = (com.ictti.library.business.entity.UserType) obj;
			if (null == this.getId() || null == userType.getId()) return false;
			else return (this.getId().equals(userType.getId()));
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