package com.ictti.library.business.entity;

import com.ictti.library.business.entity.base.BaseCallNumber;



public class CallNumber extends BaseCallNumber {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CallNumber () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CallNumber (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CallNumber (
		java.lang.Integer id,
		java.lang.String callNumberCode) {

		super (
			id,
			callNumberCode);
	}

/*[CONSTRUCTOR MARKER END]*/


}