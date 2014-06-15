package com.ictti.library.business.service;

import java.util.List;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.business.entity.ViewRentedHistory;
import com.ictti.library.dao.BookOnLoanDao;
import com.ictti.library.dao.BookReserveDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.ViewBookListDao;
import com.ictti.library.dao.ViewRentedHistoryDao;
import com.ictti.library.presentation.form.UserForm;

public class ViewRentService {
	private BookReserveDao myReserveDao;
	private CallNumberDao myCallNumberDao;
	private ViewBookListDao myViewBookListDao;
	private ViewRentedHistoryDao myViewRentDao;
	
	public ViewRentedHistoryDao getMyViewRentDao() {
		return myViewRentDao;
	}
	public void setMyViewRentDao(ViewRentedHistoryDao myViewRentDao) {
		this.myViewRentDao = myViewRentDao;
	}
	public ViewBookListDao getMyViewBookListDao() {
		return myViewBookListDao;
	}
	public void setMyViewBookListDao(ViewBookListDao myViewBookListDao) {
		this.myViewBookListDao = myViewBookListDao;
	}
	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}
	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}
	private BookOnLoanDao myBookOnLoanDao;
	
	public BookReserveDao getMyReserveDao() {
		return myReserveDao;
	}
	public void setMyReserveDao(BookReserveDao myReserveDao) {
		this.myReserveDao = myReserveDao;
	}
	/*public void checkLoginUserId(UserForm myForm) {
		// TODO Auto-generated method stub
		List<BookOnLoan> myBookOnLoan=myBookOnLoanDao.getUserById(myForm.getFrmusr_id());
		if(myBookOnLoan!=null){
			myForm.setFrmUserFlag("data");
			System.out.println("in Rent Service!!!"+myForm.getFrmusr_id());
		}
		
	}*/
	public void getBookLoanInfo(UserForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("In Service!!!!"+myForm.getLoginUser().getId());
		List<ViewRentedHistory> l= myViewRentDao.getUserById(myForm.getLoginUser().getId());
		myForm.setMyViewRentedHistory(l);
		//System.out.println("In Service!!!!"+myForm.getFrmusr_id());
		
		if(myForm.getMyViewRentedHistory()==null)
		{
			myForm.setFrmViewRentFlag("data");
		}
			//myForm.setMyViewRentedHistory(l);
		else{
			System.out.println(l.size());
			myForm.setActualPage(1);
			myForm.setIMaxData(l.size());
			myForm.setIMaxShow(2);
		}	
	}
	/*public void checkLoginUser(UserForm myForm) {
		// TODO Auto-generated method stub
		BookOnLoan myBookOnLoan=myBookOnLoanDao.getLoginUser(myForm.getFrmusr_id());
		if(myBookOnLoan!=null){
			myForm.setFrmUserFlag("data");
			System.out.println("in  View Rent Service!!!"+myForm.getFrmusr_id());
		}*/
	public BookOnLoanDao getMyBookOnLoanDao() {
		return myBookOnLoanDao;
	}
	public void setMyBookOnLoanDao(BookOnLoanDao myBookOnLoanDao) {
		this.myBookOnLoanDao = myBookOnLoanDao;
	}
		
	}


