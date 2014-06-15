package com.ictti.library.business.entity;

import com.ictti.library.business.entity.base.BaseViewBookOnloan;



public class ViewBookOnloan extends BaseViewBookOnloan {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ViewBookOnloan () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ViewBookOnloan (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ViewBookOnloan (
		java.lang.Integer id,
		java.lang.String callnumbercode) {

		super (
			id,
			callnumbercode);
	}

/*[CONSTRUCTOR MARKER END]*/


}