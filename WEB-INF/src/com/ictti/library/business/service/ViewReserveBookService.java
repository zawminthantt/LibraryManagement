package com.ictti.library.business.service;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.dao.BookReserveDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.ViewReserveBookDao;
import com.ictti.library.presentation.form.AdminViewReservationForm;
import com.ictti.library.presentation.form.UserForm;
import com.ictti.library.presentation.form.ViewReserveBookForm;

public class ViewReserveBookService {
	private static Log log = LogFactory.getLog(UserService.class);
	private ViewReserveBookDao myViewReserveBookDao;

	public ViewReserveBookDao getMyViewReserveBookDao() {
		return myViewReserveBookDao;
	}

	public void setMyViewReserveBookDao(ViewReserveBookDao myViewReserveBookDao) {
		this.myViewReserveBookDao = myViewReserveBookDao;
	}

	private CallNumberDao myCallNumberDao;
	private BookReserveDao myBookReserveDao;

	public BookReserveDao getMyBookReserveDao() {
		return myBookReserveDao;
	}

	public void setMyBookReserveDao(BookReserveDao myBookReserveDao) {
		this.myBookReserveDao = myBookReserveDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}

	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	public List<ViewReserveBook> firstLoadReserve(ViewReserveBookForm myForm,
			Integer Id) {
		List<ViewReserveBook> myBookList = myViewReserveBookDao.getByUserId(Id);
		//System.out.println("List "+myBookList.size());
		if (myBookList.get(0)==null ) {
			System.out.println("List is null in service ");
			myForm.setFrmViewBookReserveList(null);
		} else {
			myForm.setFrmViewBookReserveList(myBookList);
			System.out.println("this is test of all" + myBookList.size());

			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(myBookList.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(2);
		}
		return myBookList;
	}

	public CallNumber getCallNumberById(Integer callNumberId) {
		return myCallNumberDao.getCallNumberById(callNumberId);
	}

	public void saveOrUpdate(CallNumber myCallNumber) {
		myCallNumberDao.saveOrUpdate(myCallNumber);
	}

	public BookReserve getAllDataById(Integer bookReserveId) {
		return myBookReserveDao.getAllDataById(bookReserveId);
	}

	public void saveOrUpdate(BookReserve newBookReserve) {
		myBookReserveDao.saveOrUpdate(newBookReserve);
	}

	public void loadUpdate(ViewReserveBookForm myForm, Integer id) {
		List<ViewReserveBook> myBookList = myViewReserveBookDao.getByUserId(id);
		System.out.println("This is test of Service");
		myForm.setFrmViewBookReserveList(myBookList);
		System.out.println("this is test of all" + myBookList.size());

		myForm.setActualPage(1);
		// set the maximum size of the result list
		myForm.setiMaxData(myBookList.size());
		// set the maximum size to show the current page
		myForm.setiMaxShow(2);
	}

	public void loadReserveList(AdminViewReservationForm myForm, Date myD1,
			Date myD2) {

		List<ViewReserveBook> myadminBookList = myViewReserveBookDao
				.getBookListByDate(myD1, myD2);
		myForm.setFrmAdminViewBookReserveList(myadminBookList);
		System.out.println("List size" + myadminBookList.size());

		myForm.setActualPage(1);
		// set the maximum size of the result list
		myForm.setiMaxData(myadminBookList.size());
		// set the maximum size to show the current page
		myForm.setiMaxShow(10);
	}

	public List<ViewReserveBook> getBookInfo(AdminViewReservationForm myForm) {
		// TODO Auto-generated method stub
		String isbn = myForm.getIsbn();
		List<ViewReserveBook> myViewReserveBook = myViewReserveBookDao
				.getBookInfoByIsbnNo(isbn);
		// myForm.setFrmViewDetailBook(myViewDetailBook);
		myForm.setFrmAdminViewBookReserveList(myViewReserveBook);
		return myViewReserveBook;
	}

	public void updateBookByBookReserve(List<Object> bookReserveList) {
		// TODO Auto-generated method stub
		for (int i = 0; i < bookReserveList.size(); i++) {
			int reserve_id = Integer
					.parseInt(bookReserveList.get(i).toString());
			System.out.println("Reserve Id in Service!!" + reserve_id);
			BookReserve myReserve = myBookReserveDao.getAllDataById(reserve_id);
			// CallNumber myCall =
			// myCallNumberDao.getCallNumberById(reserve_id);
			// myCall.setStatus(1);
			myReserve.setReserveStatus(1);
			myBookReserveDao.saveOrUpdate(myReserve);
			System.out.println("Reserve status in Service!!"
					+ myReserve.getReserveStatus());
		}
	}

	public void updateBookByCallNumber(List<Object> callnumberlist) {
		// TODO Auto-generated method stub
		for (int i = 0; i < callnumberlist.size(); i++) {
			int call_id = Integer.parseInt(callnumberlist.get(i).toString());
			System.out.println("Call number Id in Service!!" + call_id);
			CallNumber myCall = myCallNumberDao.getCallNumberById(call_id);
			// CallNumber myCall =
			// myCallNumberDao.getCallNumberById(reserve_id);
			// myCall.setStatus(1);
			myCall.setIssuseStatus(0);
			myCallNumberDao.saveOrUpdate(myCall);
			System.out.println("Call Number status in Service!!"
					+ myCall.getIssuseStatus());
		}
	}

	public void prepareForMail(AdminViewReservationForm myForm,
			List<Object> emailList) throws MessagingException {
		// for (int i = 0; i < userList.size(); i++) {

		for (int i = 0; i < emailList.size(); i++) {

			String user_email = emailList.get(i).toString();

			System.out.println("User Email in Service!!" + user_email);
			// Log log = LogFactory.getLog(UserService.class);
			boolean debug = false;
			// Please load SMTP host name from your project web.xml
			// file
			final String SMTP_HOST_NAME = "192.168.48.13";
			// Please read followings from your project database
			// final String emailMsgTxt =
			// "You have been successfully registered at ICTTI library";
			// final String memberName = user_name;
			// final int memberId = myForm.getFrmusr_id();
			// final int callnumber=myForm.getCallNo();
			// final String callNumberCode = call_code;
			final String emailSubjectTxt = "Reservation Comfirmation";
			final String emailFromAddress = "admin@ictti.site";
			final String emailToAddress = user_email;
			System.out.println("User email" + emailToAddress);
			// final String emailToAddress =
			// "ps9-ayeaye@ictti.site";
			// 1. Prepare Properties
			Properties props = new Properties();
			props.put("mail.smtp.host", SMTP_HOST_NAME);
			Session session = Session.getDefaultInstance(props, null);
			session.setDebug(debug);
			// 2. Create a MimeMessage
			Message msg = new MimeMessage(session);
			InternetAddress addressFrom = new InternetAddress(emailFromAddress);
			InternetAddress addressTo = new InternetAddress(emailToAddress);
			msg.setFrom(addressFrom);

			msg.setRecipient(Message.RecipientType.TO, addressTo);

			msg.setSubject(emailSubjectTxt);
			String strMailContext = "Dear "
					+ ","
					+ "\n\t\t\t"
					+ "Your Reservation is OverDued. "
					+ "\n\t\t\t"
					+ "\""
					+ "\""
					+ "\n\t\t\t"
					+ "\n\t\t\t"
					+ "You have already over due reserved the above book."
					+ "\n\t\t\t"
					+ "From now on you can reserve another book from our library notice."
					+ "\n\t\t\t" + "Thanks for your reservation."
					+ "\n\n\t\t\t\t\t\t\t" + "Yours sincerely,"
					+ "\n\t\t\t\t\t\t\t" + "ICTTI Library Admin";

			msg.setContent(strMailContext, "text/plain");
			Transport.send(msg);
			if (log.isInfoEnabled()) {
				log.info("Message sent successfully");
			}
		}
	}

}
