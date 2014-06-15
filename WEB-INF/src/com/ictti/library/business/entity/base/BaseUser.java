package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user"
 */

public abstract class BaseUser  implements Serializable {

	public static String REF = "User";
	public static String PROP_USER_TYPE = "userType";
	public static String PROP_ISSUE_DATE = "issueDate";
	public static String PROP_USER_STATUS = "userStatus";
	public static String PROP_USER_NAME = "userName";
	public static String PROP_USER_EMAIL = "userEmail";
	public static String PROP_USER_LOGIN_NAME = "userLoginName";
	public static String PROP_EXPIRE_DATE = "expireDate";
	public static String PROP_GENDER = "gender";
	public static String PROP_USER_ADDRESS = "userAddress";
	public static String PROP_ID = "id";
	public static String PROP_LOAN_COUNT = "loanCount";
	public static String PROP_NRC_NO = "nrcNo";
	public static String PROP_USER_PASSWORD = "userPassword";
	public static String PROP_USER_PHONE_NO = "userPhoneNo";


	// constructors
	public BaseUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUser (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String userLoginName;
	private java.lang.String userName;
	private java.lang.String nrcNo;
	private java.lang.String gender;
	private java.lang.String userPassword;
	private java.lang.String userAddress;
	private java.lang.String userPhoneNo;
	private java.lang.String userEmail;
	private java.util.Date expireDate;
	private java.util.Date issueDate;
	private java.lang.Integer userStatus;
	private java.lang.Integer loanCount;

	// many to one
	private com.ictti.library.business.entity.UserType userType;

	// collections
	private java.util.Set<com.ictti.library.business.entity.EmailLog> emailLogs;
	private java.util.Set<com.ictti.library.business.entity.BookOnLoan> bookOnLoans;
	private java.util.Set<com.ictti.library.business.entity.BookReserve> bookReserves;



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
	 * Return the value associated with the column: user_login_name
	 */
	public java.lang.String getUserLoginName () {
		return userLoginName;
	}

	/**
	 * Set the value related to the column: user_login_name
	 * @param userLoginName the user_login_name value
	 */
	public void setUserLoginName (java.lang.String userLoginName) {
		this.userLoginName = userLoginName;
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
	 * Return the value associated with the column: nrc_no
	 */
	public java.lang.String getNrcNo () {
		return nrcNo;
	}

	/**
	 * Set the value related to the column: nrc_no
	 * @param nrcNo the nrc_no value
	 */
	public void setNrcNo (java.lang.String nrcNo) {
		this.nrcNo = nrcNo;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: user_password
	 */
	public java.lang.String getUserPassword () {
		return userPassword;
	}

	/**
	 * Set the value related to the column: user_password
	 * @param userPassword the user_password value
	 */
	public void setUserPassword (java.lang.String userPassword) {
		this.userPassword = userPassword;
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
	 * Return the value associated with the column: user_phone_no
	 */
	public java.lang.String getUserPhoneNo () {
		return userPhoneNo;
	}

	/**
	 * Set the value related to the column: user_phone_no
	 * @param userPhoneNo the user_phone_no value
	 */
	public void setUserPhoneNo (java.lang.String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}



	/**
	 * Return the value associated with the column: user_email
	 */
	public java.lang.String getUserEmail () {
		return userEmail;
	}

	/**
	 * Set the value related to the column: user_email
	 * @param userEmail the user_email value
	 */
	public void setUserEmail (java.lang.String userEmail) {
		this.userEmail = userEmail;
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
	 * Return the value associated with the column: loan_count
	 */
	public java.lang.Integer getLoanCount () {
		return loanCount;
	}

	/**
	 * Set the value related to the column: loan_count
	 * @param loanCount the loan_count value
	 */
	public void setLoanCount (java.lang.Integer loanCount) {
		this.loanCount = loanCount;
	}



	/**
	 * Return the value associated with the column: user_type_id
	 */
	public com.ictti.library.business.entity.UserType getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: user_type_id
	 * @param userType the user_type_id value
	 */
	public void setUserType (com.ictti.library.business.entity.UserType userType) {
		this.userType = userType;
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
		if (!(obj instanceof com.ictti.library.business.entity.User)) return false;
		else {
			com.ictti.library.business.entity.User user = (com.ictti.library.business.entity.User) obj;
			if (null == this.getId() || null == user.getId()) return false;
			else return (this.getId().equals(user.getId()));
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