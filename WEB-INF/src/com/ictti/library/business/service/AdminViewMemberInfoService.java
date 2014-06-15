package com.ictti.library.business.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.UserType;
import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.dao.AdminViewMemberInfoDao;
import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.UserTypeDao;
import com.ictti.library.presentation.form.AdminViewMemberInfoForm;
import com.ictti.library.presentation.form.AdminViewReservationForm;

public class AdminViewMemberInfoService {
	private static Log log = LogFactory.getLog(UserService.class);
	private UserTypeDao myUserTypeDao;
	private AdminViewMemberInfoDao myViewMemberInfoDao;
	private UserDao myUserDao;

	public UserDao getMyUserDao() {
		return myUserDao;
	}

	public void setMyUserDao(UserDao myUserDao) {
		this.myUserDao = myUserDao;
	}

	public AdminViewMemberInfoDao getMyViewMemberInfoDao() {
		return myViewMemberInfoDao;
	}

	public void setMyViewMemberInfoDao(
			AdminViewMemberInfoDao myViewMemberInfoDao) {
		this.myViewMemberInfoDao = myViewMemberInfoDao;
	}

	public UserTypeDao getMyUserTypeDao() {
		return myUserTypeDao;
	}

	public void setMyUserTypeDao(UserTypeDao myUserTypeDao) {
		this.myUserTypeDao = myUserTypeDao;
	}

	public void fristLoad(AdminViewMemberInfoForm myForm) {
		List<UserType> l = myUserTypeDao.getAllUserType();
		myForm.setFrmUserTypeList(l);

	}

	public List<ViewMemberInfo> loadMemberInfo(AdminViewMemberInfoForm myForm) {

		List<ViewMemberInfo> myList = myViewMemberInfoDao
				.getByUserTypeName(myForm.getFrmUserTypeId());
		System.out.println("List is null in service "+myList);
		if (myList == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmViewMemberList(myList);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(myList.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(4);
			System.out.println("this is test of member info service List"
					+ myList.size());
		}
		return myList;
	}

	public List<ViewMemberInfo> getUserInfo(AdminViewMemberInfoForm myForm) {
		// TODO Auto-generated method stub
		String userTypeName = myForm.getFrmUserTypeName();
		List<ViewMemberInfo> myViewInfo = myViewMemberInfoDao
				.getByUserTypeName(userTypeName);
		// myForm.setFrmViewDetailBook(myViewDetailBook);
		myForm.setFrmViewMemberList(myViewInfo);
		return myViewInfo;
	}

	public void updateUserByUserId(List<Object> userlist) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userlist.size(); i++) {
			int user_id = Integer.parseInt(userlist.get(i).toString());
			System.out.println("User Id in Service!!" + user_id);
			User myUser = myUserDao.getUserId(user_id);
			// CallNumber myCall =
			// myCallNumberDao.getCallNumberById(reserve_id);
			// myCall.setStatus(1);
			myUser.setUserLoginName(null);
			myUser.setUserStatus(0);
			myUserDao.saveUser(myUser);
			System.out.println("Reserve status in Service!!"
					+ myUser.getUserStatus());
		}

	}

	public void checkDate(List<Object> dateList, String nowDate) {
		System.out.println("Now Date in Service!!" + nowDate);
		for (int i = 0; i < dateList.size(); i++) {
			String date = dateList.get(i).toString();
			System.out.println("Date in Service!!" + date);

		}
	}

	public List<ViewMemberInfo> loadRentMemberInfo(
			AdminViewMemberInfoForm myForm) {

		List<ViewMemberInfo> myRentList = myViewMemberInfoDao
				.getUserByLoanCount(myForm.getFrmUserTypeId());
		if (myRentList == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmViewRentMemberList(myRentList);
			myForm.setActualPage(1);
			System.out.println("this is test" + myRentList.size());
			// set the maximum size of the result list
			myForm.setiMaxData(myRentList.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(4);
			System.out.println("this is test of member info service"
					+ myRentList.size());
		}
		return myRentList;
	}

	public User getUserById(AdminViewMemberInfoForm myForm) {
		return myUserDao.getUserId(myForm.getFrmDeleteId());
	}

	public void saveOrUpdate(User myUser) {
		myUserDao.saveUser(myUser);
	}

	public void prepareForMail(AdminViewMemberInfoForm myForm,
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
			final String emailSubjectTxt = "User Comfirmation";
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
			String strMailContext = "Dear " + "," + "\n\t\t\t"
					+ "Your Registered is expired. " + "\n\t\t\t" + "\""
					+ "\n\t\t\t" + "Thanks for your registration."
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
