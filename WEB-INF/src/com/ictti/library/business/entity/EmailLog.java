package com.ictti.library.business.entity;

import com.ictti.library.business.entity.base.BaseEmailLog;



public class EmailLog extends BaseEmailLog {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public EmailLog () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public EmailLog (java.lang.Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public EmailLog (
		java.lang.Integer id,
		com.ictti.library.business.entity.BookOnLoan bookLoan,
		com.ictti.library.business.entity.User user) {

		super (
			id,
			bookLoan,
			user);
	}

/*[CONSTRUCTOR MARKER END]*/


}