package com.ictti.library.business.entity;

import com.ictti.library.business.entity.base.BaseBookOnLoan;



public class BookOnLoan extends BaseBookOnLoan {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public BookOnLoan () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public BookOnLoan (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public BookOnLoan (
		java.lang.Integer id,
		com.ictti.library.business.entity.User user) {

		super (
			id,
			user);
	}

/*[CONSTRUCTOR MARKER END]*/


}