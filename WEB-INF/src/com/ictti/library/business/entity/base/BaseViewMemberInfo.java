package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the view_member_info table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="view_member_info"
 */

public abstract class BaseViewMemberInfo  implements Serializable {

	public static String REF = "ViewMemberInfo";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_LOAN_DATE = "loanDate";
	public static String PROP_USER_ADDRESS = "userAddress";
	public static String PROP_USER_STATUS = "userStatus";
	public static String PROP_USER_TYPE_NAME = "userTypeName";
	public static String PROP_ID = "id";
	public static String PROP_PHONE_NUMBER = "phoneNumber";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_USER_EMAIL = "userEmail";
	public static String PROP_RENT_COUNT = "rentCount";
	public static String PROP_USER_TYPE_ID = "userTypeId";


	// constructors
	public BaseViewMemberInfo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewMemberInfo (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userName;
	private java.lang.Integer userTypeId;
	private java.lang.Integer userStatus;
	private java.lang.String userTypeName;
	private java.lang.String userAddress;
	private java.lang.String phoneNumber;
	private java.lang.String userEmail;
	private java.util.Date issueDate;
	private java.util.Date loanDate;
	private java.util.Date expireDate;
	private java.lang.Integer rentCount;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="user_id"
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
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: user_type_id
	 */
	public java.lang.Integer getUserTypeId () {
		return userTypeId;
	}

	/**
	 * Set the value related to the column: user_type_id
	 * @param userTypeId the user_type_id value
	 */
	public void setUserTypeId (java.lang.Integer userTypeId) {
		this.userTypeId = userTypeId;
	}



	/**
	 * Return the value associated with the column: user_status
	 */
	public java.lang.Integer getUserStatus () {
		return userStatus;
	}

	/**
	 * Set the value related to the column: user_status
	 * @param userStatus the user_status value
	 */
	public void setUserStatus (java.lang.Integer userStatus) {
		this.userStatus = userStatus;
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
	 * Return the value associated with the column: user_address
	 */
	public java.lang.String getUserAddress () {
		return userAddress;
	}

	/**
	 * Set the value related to the column: user_address
	 * @param userAddress the user_address value
	 */
	public void setUserAddress (java.lang.String userAddress) {
		this.userAddress = userAddress;
	}



	/**
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhoneNumber () {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phoneNumber the phone value
	 */
	public void setPhoneNumber (java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getUserEmail () {
		return userEmail;
	}

	/**
	 * Set the value related to the column: email
	 * @param userEmail the email value
	 */
	public void setUserEmail (java.lang.String userEmail) {
		this.userEmail = userEmail;
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
	 * Return the value associated with the column: loan_date
	 */
	public java.util.Date getLoanDate () {
		return loanDate;
	}

	/**
	 * Set the value related to the column: loan_date
	 * @param loanDate the loan_date value
	 */
	public void setLoanDate (java.util.Date loanDate) {
		this.loanDate = loanDate;
	}



	/**
	 * Return the value associated with the column: expire_date
	 */
	public java.util.Date getExpireDate () {
		return expireDate;
	}

	/**
	 * Set the value related to the column: expire_date
	 * @param expireDate the expire_date value
	 */
	public void setExpireDate (java.util.Date expireDate) {
		this.expireDate = expireDate;
	}



	/**
	 * Return the value associated with the column: rentcount
	 */
	public java.lang.Integer getRentCount () {
		return rentCount;
	}

	/**
	 * Set the value related to the column: rentcount
	 * @param rentCount the rentcount value
	 */
	public void setRentCount (java.lang.Integer rentCount) {
		this.rentCount = rentCount;
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.ViewMemberInfo)) return false;
		else {
			com.ictti.library.business.entity.ViewMemberInfo viewMemberInfo = (com.ictti.library.business.entity.ViewMemberInfo) obj;
			if (null == this.getId() || null == viewMemberInfo.getId()) return false;
			else return (this.getId().equals(viewMemberInfo.getId()));
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