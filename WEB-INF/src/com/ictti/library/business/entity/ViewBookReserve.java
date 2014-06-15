package com.ictti.library.business.entity;

import com.ictti.library.business.entity.base.BaseViewBookReserve;



public class ViewBookReserve extends BaseViewBookReserve {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ViewBookReserve () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ViewBookReserve (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ViewBookReserve (
		java.lang.Integer id,
		java.lang.String callnumbercode) {

		super (
			id,
			callnumbercode);
	}

/*[CONSTRUCTOR MARKER END]*/


}