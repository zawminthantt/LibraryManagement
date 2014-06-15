package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.presentation.form.UserForm;

public interface BookOnLoanDao {

	 public List<BookOnLoan> getEarilestDateByCallNumber(Integer cno);
	//public BookOnLoan getEarilestDateByCallNumber(Integer cno);

	public List<BookOnLoan> getUserById(Integer usr_id);

	public void saveRenew(BookOnLoan myBookOnLoan);

	public BookOnLoan getBookLoanId(int id);

	//public BookOnLoan getLoginUser(int frmusr_id);
	
	//For Check In
	public void saveCheckinInfo(BookOnLoan myBookOnLoan);
	
	//For Check Out
	public BookOnLoan getLoanStatusById(int usr_id);
	public void saveCheckOutInfo(BookOnLoan myBookOnLoan);


	
	

	
}
