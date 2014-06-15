   package com.ictti.library.business.service;

import java.util.Date;
import java.util.List;

import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.BookReserveDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.UserTypeDao;
import com.ictti.library.dao.BookOnLoanDao;
import com.ictti.library.dao.ViewDetailBookDao;
import com.ictti.library.presentation.form.CheckOutForm;

public class CheckOutService {
	private CallNumberDao myCallNumberDao;
	private UserTypeDao myUserTypeDao;
	private UserDao myUserDao;
	private BookOnLoanDao myBookOnLoanDao;
	private BookListDao myBookListDao;

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	private ViewDetailBookDao myViewDetailBookDao;

	public ViewDetailBookDao getMyViewDetailBookDao() {
		return myViewDetailBookDao;
	}

	public void setMyViewDetailBookDao(ViewDetailBookDao myViewDetailBookDao) {
		this.myViewDetailBookDao = myViewDetailBookDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	public BookOnLoanDao getMyBookOnLoanDao() {
		return myBookOnLoanDao;
	}

	public void setMyBookOnLoanDao(BookOnLoanDao myBookOnLoanDao) {
		this.myBookOnLoanDao = myBookOnLoanDao;
	}

	public UserDao getMyUserDao() {
		return myUserDao;
	}

	public void setMyUserDao(UserDao myUserDao) {
		this.myUserDao = myUserDao;
	}

	public UserTypeDao getMyUserTypeDao() {
		return myUserTypeDao;
	}

	public void setMyUserTypeDao(UserTypeDao myUserTypeDao) {
		this.myUserTypeDao = myUserTypeDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}

	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	private BookReserveDao myBookReserveDao;

	public BookReserveDao getMyBookReserveDao() {
		return myBookReserveDao;
	}

	public void setMyBookReserveDao(BookReserveDao myBookReserveDao) {
		this.myBookReserveDao = myBookReserveDao;
	}

	public void checkLoginUser(CheckOutForm myForm) {
		// TODO Auto-generated method stub

		String usr_name = myForm.getFrmLoginName().trim();
		System.out.println("In Check Out Service" + usr_name);
		User myUser = myUserDao.getExpiredDatebyUserType(usr_name);
		if (myUser != null) {
			myForm.setFrmUserInfo(myUser);
			int usr_id = myUser.getId();
			System.out.println("User Id in Checkout Service" + usr_id);
			Date eDate = myUser.getExpireDate();
			if (eDate == null) {
				BookOnLoan myBookOnLoan = myBookOnLoanDao
						.getLoanStatusById(usr_id);
				if (myBookOnLoan == null) {
					myForm.setFrmBookOnLoanFlag(null);
					System.out.println("no loan");
				} else {

					int loan_status = myBookOnLoan.getLoanStatus();
					System.out
							.println("In Check Out Service get by BookOnLoan Status:"
									+ loan_status);

					if (myBookOnLoan != null) {
						myForm.setFrmBookOnLoanFlag("data");
						// myForm.setFrmBookOnLoanFlag("data");
					}

				}

			} else {
				Date todayDate = new Date();
				if (eDate.compareTo(todayDate) < 0) {
					myForm.setFrmUserFlag("data");
					// myForm.setFrmCheckoutFormControl("data");
				} else {
					BookOnLoan myBookOnLoan = myBookOnLoanDao
							.getLoanStatusById(usr_id);
					if (myBookOnLoan == null) {
						myForm.setFrmBookOnLoanFlag(null);
						System.out.println("no loan");
					} else {

						int loan_status = myBookOnLoan.getLoanStatus();
						System.out
								.println("In Check Out Service get by BookOnLoan Status:"
										+ loan_status);

						if (myBookOnLoan != null) {
							myForm.setFrmBookOnLoanFlag("data");
							// myForm.setFrmBookOnLoanFlag("data");
						}

					}
				}// end else
			}
		} else {
			myForm.setFrmUserInfoFlag("data");
			System.out.println("Student has not registered");

		}

	}

	/* Save Check out info */
	public void saveCheckOutInfo(CheckOutForm myForm) {

		int user_id = myForm.getFrmUserInfo().getId();
		BookOnLoan myBookOnLoan = new BookOnLoan();
		myBookOnLoan.setId(null);
		myBookOnLoan.setIssueDate(myForm.getIDate());
		myBookOnLoan.setReturnDate(null);
		myBookOnLoan.setDueDate(myForm.getdDate());
		myBookOnLoan.setLateFees(0);
		myBookOnLoan.setLoanStatus(0);
		CallNumber myCall = myCallNumberDao.getCallNumberById(myForm.getFrmCheckOutCallNo());
		myBookOnLoan.setCallnumber(myCall);
		User myUser = myUserDao.getUserById(user_id);
		myBookOnLoan.setUser(myUser);
		myBookOnLoanDao.saveCheckOutInfo(myBookOnLoan);

		/* Update Call Number table for issuse_status*/ 
		CallNumber myCallNo = myCallNumberDao.getCallNumberById(myForm.getFrmCheckOutCallNo());
		myCallNo.setIssuseStatus(0);
		myCallNumberDao.saveIssuseStatus(myCallNo);
	}

	public void getReserveByUserId(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int user_id = myForm.getFrmUserInfo().getId();
		int call_id = myForm.getFrmViewDetailBook().getId();
		System.out.println("User id in service user_id" + user_id + "  call_id"
				+ call_id);
		BookReserve myBookReserve = myBookReserveDao.getReserveInfoByUserId(
				user_id, call_id);
		myForm.setMyBookReserve(myBookReserve);
	}

	public void getReserveByCallId(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int call_id = myForm.getFrmViewDetailBook().getId();
		System.out.println("Call Id in service " + call_id);
		BookReserve myBookReserve = myBookReserveDao
				.getReserveInfoByCallId(call_id);
		myForm.setMyBookReserve(myBookReserve);
	}

/*	public void getCallNumberListByCallCode(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		// int book_id=myForm.getMyBookList().getId();
		// String call_code=myForm.getFrmViewDetailBook().getCallNumberCode();
		String call_code = myForm.getFrmCheckOutCallNo();
		System.out.println("In Service Call number Code=" + call_code);
		List<CallNumber> myCallNumber = myCallNumberDao
				.getCallNumberList(call_code);
		myForm.setMyCallNumber(myCallNumber);
	}
*/
	/*public void getBookIdByCallNo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String c_code = myForm.getFrmCheckOutCallNo();
		ViewDetailBook myViewDetailBook = myViewDetailBookDao
				.getBookIdbyCallCode(c_code);
		myForm.setFrmViewDetailBook(myViewDetailBook);
	}*/

	public void updateBookReserveInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int user_id = myForm.getFrmUserInfo().getId();
		User myUser = myUserDao.getUserById(user_id);
		int usr_id = myUser.getId();
		int call_id = myForm.getMyBookReserve().getCallnumber().getId();
		BookReserve myReserve = myBookReserveDao.getReserveStatus(usr_id, call_id);
		myReserve.setReserveStatus(1);
		myBookReserveDao.saveReserveStatus(myReserve);

	}

	public void getBookIdByIsbn(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String isbn=myForm.getFrmIsbn();
		ViewDetailBook myViewDetailBook=myViewDetailBookDao.getBookInfoByIsbn(isbn);
		myForm.setFrmViewDetailBook(myViewDetailBook);
	}

	public void getCallNumberListByBookId(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int usr_id=myForm.getFrmUserInfo().getId();
		System.out.println("User Id in Action="+usr_id);
		int book_id=myForm.getFrmViewDetailBook().getBookId();
		System.out.println("Book id in Checkout Service!!!"+book_id);
		 List<ViewDetailBook> l=myViewDetailBookDao.getCallNumberList(book_id);
		 if(l==null){
			 //myForm.setFrmViewDetailBook(null);
			 myForm.setFrmBookInfoFlag("data");
		 }
		 else{
			 myForm.setMyViewDetailBook(l);
			 for(int i=0;i<l.size();i++){
					int call_id=l.get(i).getId();
					BookReserve myReserve =myBookReserveDao.getReserveStatus(usr_id, call_id);
					if(myReserve!=null)
					{
						myForm.setMyBookReserve(myReserve);
					}
				}
		 }
	}

}