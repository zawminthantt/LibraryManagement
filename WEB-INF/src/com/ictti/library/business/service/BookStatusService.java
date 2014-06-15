package com.ictti.library.business.service;

import java.util.List;

import com.ictti.library.business.entity.ViewBookOnloan;
import com.ictti.library.business.entity.ViewBookReserve;
import com.ictti.library.dao.ViewBookStatusDao;
import com.ictti.library.presentation.form.BookStatusForm;

public class BookStatusService {
	private ViewBookStatusDao myViewBookStatusDao;

	public ViewBookStatusDao getMyViewBookStatusDao() {
		return myViewBookStatusDao;
	}

	public void setMyViewBookStatusDao(ViewBookStatusDao myViewBookStatusDao) {
		this.myViewBookStatusDao = myViewBookStatusDao;
	}
	private static final Integer Callnumber = null;

	public void firstLoadCallnumber(BookStatusForm myForm) {
		myForm.setFrmRegCallNumber("");
		myForm.setFrmRegFormControl(null);

	}

	public void checkInCallnumber(BookStatusForm myForm) {
		//String cno = myForm.getFrmRegCallNumber();
		//System.out.println("Callnumber from form is......"+ myForm.getFrmRegCallNumber());		
		ViewBookOnloan bookonloan = myViewBookStatusDao.checkByOnLoanStatus(myForm.getFrmRegCallNumber());
		if(bookonloan!=null){
			myForm.setCallnumber(bookonloan);	
			
		}
		else
		{ bookonloan = myViewBookStatusDao.checkByOnLoan(myForm.getFrmRegCallNumber());
		
		myForm.setCallnumber(bookonloan);
		}
		ViewBookReserve reservebook = myViewBookStatusDao.checkByBookReserve(myForm.getFrmRegCallNumber());
		
		if(reservebook!=null){
			
	
			
					myForm.setFrmCallnumber(bookonloan.getCallnumbercode());
					myForm.setFrmRegISBN(bookonloan.getISBN());
					myForm.setFrmRegTitle(bookonloan.getTitle());
					myForm.setFrmRegAuthor(bookonloan.getAuthorname());
					myForm.setFrmadminBookStatus(bookonloan.getLoanstatus());
					myForm.setFrmRegCheckUserName(bookonloan.getUsername());
					myForm.setFrmReserveStatus(reservebook.getReservestatus());
					myForm.setFrmReserved(reservebook.getReservedate());
								
					//myForm.setFrmReserveStatus(reservebook.getReservestatus());
					
					myForm.setFrmLoanStatus(bookonloan.getLoanstatus());
					myForm.setFrmRegReserveUserName(reservebook.getUsername());
					myForm.setFrmIssueDate(bookonloan.getIssuedate());
					myForm.setFrmDueDate(bookonloan.getDuedate());
					myForm.setFrmRegFormControl("data");
					}
	
	
	
}

	public ViewBookOnloan getByCallNumber(String callnumber) {
		// TODO Auto-generated method stub
		//return null;
		return myViewBookStatusDao.checkByCallNumber(callnumber);
		
		
	}




}
