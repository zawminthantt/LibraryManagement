package com.ictti.library.business.entity.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the accession_code table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="accession_code"
 */

public abstract class BaseAccessionCode  implements Serializable {

	public static String REF = "AccessionCode";
	public static String PROP_ACCESSION_CODE = "accessionCode";
	public static String PROP_ID = "id";


	// constructors
	public BaseAccessionCode () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseAccessionCode (java.lang.Integer id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer id;

	// fields
	private java.lang.String accessionCode;

	// collections
	private java.util.Set<com.ictti.library.business.entity.CallNumber> callNumbers;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="accession_id"
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
	 * Return the value associated with the column: accession_code
	 */
	public java.lang.String getAccessionCode () {
		return accessionCode;
	}

	/**
	 * Set the value related to the column: accession_code
	 * @param accessionCode the accession_code value
	 */
	public void setAccessionCode (java.lang.String accessionCode) {
		this.accessionCode = accessionCode;
	}



	/**
	 * Return the value associated with the column: callNumbers
	 */
	public java.util.Set<com.ictti.library.business.entity.CallNumber> getCallNumbers () {
		return callNumbers;
	}

	/**
	 * Set the value related to the column: callNumbers
	 * @param callNumbers the callNumbers value
	 */
	public void setCallNumbers (java.util.Set<com.ictti.library.business.entity.CallNumber> callNumbers) {
		this.callNumbers = callNumbers;
	}

	public void addTocallNumbers (com.ictti.library.business.entity.CallNumber callNumber) {
		if (null == getCallNumbers()) setCallNumbers(new java.util.TreeSet<com.ictti.library.business.entity.CallNumber>());
		getCallNumbers().add(callNumber);
	}




	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ictti.library.business.entity.AccessionCode)) return false;
		else {
			com.ictti.library.business.entity.AccessionCode accessionCode = (com.ictti.library.business.entity.AccessionCode) obj;
			if (null == this.getId() || null == accessionCode.getId()) return false;
			else return (this.getId().equals(accessionCode.getId()));
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