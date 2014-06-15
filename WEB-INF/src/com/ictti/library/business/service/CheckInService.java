package com.ictti.library.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.ViewRentedHistory;
import com.ictti.library.dao.BookOnLoanDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.ViewRentedHistoryDao;
import com.ictti.library.presentation.form.CheckOutForm;

public class CheckInService {
	private ViewRentedHistoryDao myViewRentDao;
	private BookOnLoanDao myBookOnLoanDao;
	private CallNumberDao myCallNumberDao;
	private UserDao myUserDao;

	public UserDao getMyUserDao() {
		return myUserDao;
	}

	public void setMyUserDao(UserDao myUserDao) {
		this.myUserDao = myUserDao;
	}

	public BookOnLoanDao getMyBookOnLoanDao() {
		return myBookOnLoanDao;
	}

	public void setMyBookOnLoanDao(BookOnLoanDao myBookOnLoanDao) {
		this.myBookOnLoanDao = myBookOnLoanDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}

	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	public ViewRentedHistoryDao getMyViewRentDao() {
		return myViewRentDao;
	}

	public void setMyViewRentDao(ViewRentedHistoryDao myViewRentDao) {
		this.myViewRentDao = myViewRentDao;
	}

	public void getCheckInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String callCode = myForm.getFrmCallNumber().trim();
		CallNumber myCallNumber = myCallNumberDao.checkCallCode(callCode);
		if (myCallNumber != null) {
			ViewRentedHistory myViewRent = myViewRentDao
					.getUserNameByCallNumber(callCode);
			myForm.setMyViewRentedHistory(myViewRent);
			if (myForm.getMyViewRentedHistory()== null) {
				myForm.setFrmCallNumberFlag2("data");
				System.out.println("CAll number Flag2="
						+ myForm.getFrmCallNumberFlag2());

			} else {
				int id = myViewRent.getUserId();
				System.out.println("User Id in Check in Service!!!"+id);
				User myUser = myUserDao.getUserById(id);
				String name = myUser.getUserName();
				myForm.setFrmUserName(name);
				System.out.println("User Name in Check in Service!!!"+name);
				Date returnDate = new Date();
				// returnDate.getDate();
				myForm.setrDate(returnDate);
				System.out.println("Return Date in Check in Service!!!"+myForm.getrDate());
				Date dueDate = myViewRent.getDueDate();
				if (dueDate.compareTo(returnDate) < 0) {
					long rDays = returnDate.getTime();
					long dDays = dueDate.getTime();
					// long diff_Days=rDays-dDays;
					int noOfDays = (int) (rDays - dDays) / (24 * 3600 * 1000);
					System.out.println("Over Due Day" + noOfDays);
					int late_fee = noOfDays * 100;
					// myViewRent.setLateFees(late_fee);
					System.out.println("Total Late Fees" + late_fee);
					myForm.setL_fees(late_fee);
				} else {
					myForm.setL_fees(0);
				}
			}
		} else {
			myForm.setFrmCallNumberFlag("data");
		}
	}

	public void saveBookLoanInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int id = myForm.getMyViewRentedHistory().getBookloanId();
		BookOnLoan myBookOnLoan = myBookOnLoanDao.getBookLoanId(id);
		myBookOnLoan.setReturnDate(myForm.getrDate());
		// SimpleDateFormat myFormat=new SimpleDateFormat("yyyy-mm-dd");
		// myBookOnLoan.setReturnDate(myFormat.format(new Date()));
		myBookOnLoan.setLateFees(myForm.getL_fees());
		myBookOnLoan.setLoanStatus(1);
		myBookOnLoanDao.saveCheckinInfo(myBookOnLoan);
	}

	public void saveCallNoInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int id = myForm.getMyViewRentedHistory().getCallNumberId();
		CallNumber myCallNumber = myCallNumberDao.getCallNumberById(id);
		myCallNumber.setIssuseStatus(1);
		myCallNumberDao.saveCheckinCallInfo(myCallNumber);
	}

	public void getCallStatus(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String callCode = myForm.getFrmCallNumber();
		CallNumber myCallNo = myCallNumberDao.getCallStatus(callCode);
		if (myCallNo != null) {
			myForm.setFrmCallNumberFlag("data");
		}
	}

}