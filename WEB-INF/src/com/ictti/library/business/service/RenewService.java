package com.ictti.library.business.service;

//import java.text.ParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.ViewRentedHistory;
import com.ictti.library.dao.BookOnLoanDao;
import com.ictti.library.dao.BookReserveDao;
import com.ictti.library.dao.CallNumberDao;

import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.ViewRentedHistoryDao;
import com.ictti.library.presentation.form.UserForm;
import com.ictti.library.util.Util;

public class RenewService {

	private ViewRentedHistoryDao myViewRentDao;
	private BookReserveDao myReserveDao;
	private UserDao myUserDao;
	private CallNumberDao myCallDao;
	
	public CallNumberDao getMyCallDao() {
		return myCallDao;
	}

	public void setMyCallDao(CallNumberDao myCallDao) {
		this.myCallDao = myCallDao;
	}

	public UserDao getMyUserDao() {
		return myUserDao;
	}

	public void setMyUserDao(UserDao myUserDao) {
		this.myUserDao = myUserDao;
	}

	
	public BookReserveDao getMyReserveDao() {
		return myReserveDao;
	}

	public void setMyReserveDao(BookReserveDao myReserveDao) {
		this.myReserveDao = myReserveDao;
	}


	private BookOnLoanDao myBookOnLoanDao;

	public BookOnLoanDao getMyBookOnLoanDao() {
		return myBookOnLoanDao;
	}

	public void setMyBookOnLoanDao(BookOnLoanDao myBookOnLoanDao) {
		this.myBookOnLoanDao = myBookOnLoanDao;
	}
	public ViewRentedHistoryDao getMyViewRentDao() {
		return myViewRentDao;
	}

	public void setMyViewRentDao(ViewRentedHistoryDao myViewRentDao) {
		this.myViewRentDao = myViewRentDao;
	}

	public void getRenewInfo(UserForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("In Renew Service!!!!"
				+ myForm.getLoginUser().getId());
		int id=myForm.getLoginUser().getId();
		ViewRentedHistory myViewCallNumber = myViewRentDao.getCallNumberId(id);
		//myForm.setCallNo(myViewCallNumber.getCallNumberId());
		myForm.setFrmViewRentedHistory(myViewCallNumber);
		int c_id = myViewCallNumber.getCallNumberId();
		System.out.println("Call Number Id in Service!!!!"+c_id);
		//BookReserve myReserveStatus=myReserveDao.getStatus(myViewCallNumber.getCallNumberId());
		BookReserve myReserveStatus=myReserveDao.getStatus(c_id);
		/*if (myReserveStatus==null) {
			// gotoError
		    myForm.setFrmRenewFlag("data");
		} else {
			Date today =new Date(); 
			Date issue_Date = myForm.getFrmViewRentedHistory().getIssueDate();
			Date due_Date = myForm.getFrmViewRentedHistory().getDueDate();
			System.out.println(" Old Issue_Date"+issue_Date);
			System.out.println(" Old Due_Date"+due_Date);
			long date_check=due_Date.getTime()-today.getTime();
			long date_diff = due_Date.getTime() - issue_Date.getTime();
			if(date_check>=(date_diff/2)){
				myForm.setFrmOverRenewFlag("data");
			}
			else{
				long dueDateNew = due_Date.getTime() + date_diff;
				Date dDateNew = new Date(dueDateNew);
				myForm.setI_Date(due_Date);
				myForm.setD_Date(dDateNew);
				System.out.println("New Issue Date:"+due_Date);
				System.out.println("New Due Date:" + dDateNew);	
			}
		}*/
		if(myReserveStatus!=null){
			if(myReserveStatus.getReserveStatus()==0){
				 myForm.setFrmRenewFlag("data");
			}
			else{
				Date today =new Date(); 
				Date t=Util.isDate(today.toString());
				
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				String st = sdf.format(today);
				try{
				today=sdf.parse(st); 
				}catch (ParseException e){
				}
				Date issue_Date = myForm.getFrmViewRentedHistory().getIssueDate();
				Date due_Date = myForm.getFrmViewRentedHistory().getDueDate();
				System.out.println(" Old Issue_Date"+issue_Date);
				System.out.println(" Old Due_Date"+due_Date);
				if(due_Date.compareTo(today)>=0){
					//myForm.setFrmOverRenewFlag("overdue");
					long date_check=due_Date.getTime()-today.getTime();
					long date_diff = due_Date.getTime() - issue_Date.getTime();
					if(date_check>=(date_diff/2)){
						myForm.setFrmOverRenewFlag("data");
					}
					else{
						long dueDateNew = due_Date.getTime() + date_diff;
						Date dDateNew = new Date(dueDateNew);
						myForm.setI_Date(due_Date);
						myForm.setD_Date(dDateNew);
						System.out.println("New Issue Date:"+due_Date);
						System.out.println("New Due Date:" + dDateNew);	
					}
					
				}
				else{
					myForm.setFrmOverDueFlag("overdue");
				}
				
				System.out.println("Reg User Flag="+myForm.getFrmRenewFlag());
			}
		}
		else{
			Date today =new Date(); 
			Date t=Util.isDate(today.toString());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			String st = sdf.format(today);
			try{
			today=sdf.parse(st); 
			}catch (ParseException e){
			}
			Date issue_Date = myForm.getFrmViewRentedHistory().getIssueDate();
			Date due_Date = myForm.getFrmViewRentedHistory().getDueDate();
			System.out.println(" Old Issue_Date"+issue_Date);
			System.out.println(" Old Due_Date"+due_Date);
			if(due_Date.compareTo(today)>=0){
				//myForm.setFrmOverRenewFlag("overdue");
				long date_check=due_Date.getTime()-today.getTime();
				long date_diff = due_Date.getTime() - issue_Date.getTime();
				if(date_check>=(date_diff/2)){
					myForm.setFrmOverRenewFlag("data");
				}
				else{
					long dueDateNew = due_Date.getTime() + date_diff;
					Date dDateNew = new Date(dueDateNew);
					myForm.setI_Date(due_Date);
					myForm.setD_Date(dDateNew);
					System.out.println("New Issue Date:"+due_Date);
					System.out.println("New Due Date:" + dDateNew);	
				}
				
			}
			else{
				myForm.setFrmOverDueFlag("overdue");
			}
			
			System.out.println("Reg User Flag="+myForm.getFrmRenewFlag());
			
		}
	}

	public void saveRenewInfo(UserForm myForm) {
		// TODO Auto-generated method stub
		//get book_on_loan id
		int id=myForm.getFrmViewRentedHistory().getBookloanId(); 
		//BookOnLoan myBookOnLoan = new BookOnLoan();
		BookOnLoan  myBookOnLoan=myBookOnLoanDao.getBookLoanId(id);
		myBookOnLoan.setIssueDate(myForm.getI_Date());
		myBookOnLoan.setDueDate(myForm.getD_Date());
	   /* User myUser=myUserDao.getUserById(myForm.getLoginUser().getId());
	    CallNumber myCall=myCallDao.getCallNumberById(myForm.getCallNo());
	    myBookOnLoan.setUser(myUser);
	    myBookOnLoan.setCallnumber(myCall)*/
		System.out.println("In Book On Loan Issue Date!!!! "+myBookOnLoan.getIssueDate());
		System.out.println("In Book On Loan Due Date!!!!" +myBookOnLoan.getDueDate());
		myBookOnLoanDao.saveRenew(myBookOnLoan);
	}
}