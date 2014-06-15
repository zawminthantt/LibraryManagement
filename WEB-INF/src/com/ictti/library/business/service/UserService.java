package com.ictti.library.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ictti.library.business.entity.IcttiCourse;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.UserType;
import com.ictti.library.dao.IcttiCourseDao;
import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.UserTypeDao;

import com.ictti.library.presentation.action.WebConstants;
import com.ictti.library.presentation.form.UserForm;

public class UserService {
	private static Log log=LogFactory.getLog(UserService.class);
	private UserDao myUserDao;
	private IcttiCourseDao myIcttiCourseDao;
	public IcttiCourseDao getMyIcttiCourseDao() {
		return myIcttiCourseDao;
	}

	public void setMyIcttiCourseDao(IcttiCourseDao myIcttiCourseDao) {
		this.myIcttiCourseDao = myIcttiCourseDao;
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

	private UserTypeDao myUserTypeDao;

	public void checkLoginUser(UserForm myForm) {
		User myUser = myUserDao.getUserByLoginNameAndPassword(
				myForm.getFrmLoginName(), myForm.getFrmPassword());
		myForm.setLoginUser(myUser);
	}

	public void firstLoadRegistration(UserForm myForm) {
		List<UserType> l = myUserTypeDao.getAllUserType();
		myForm.setFrmRegUserTypeList(l);
		myForm.setFrmRegUserTypeId("0");
		myForm.setFrmRegAddress("");
		myForm.setFrmRegConfPassword("");
		myForm.setFrmRegEmail("");
		myForm.setFrmRegLoginName("");
		// myForm.setFrmRegGender("");
		myForm.setFrmRegNRC("");
		myForm.setFrmRegPassword("");
		myForm.setFrmRegPhone("");
		myForm.setFrmRegFormControl(null);
	}

	public void saveNewUser(UserForm myForm) {
		// TODO Auto-generated method stub
		User myUser = new User();
		myUser.setId(null);
		myUser.setIssueDate(new Date());
		myUser.setUserLoginName(myForm.getFrmRegLoginName());
		myUser.setUserAddress(myForm.getFrmRegAddress());
		myUser.setGender(myForm.getFrmRegGender());
		myUser.setUserEmail(myForm.getFrmRegEmail());
		UserType myUserType = myUserTypeDao.getUserTypeById(Integer
				.parseInt(myForm.getFrmRegUserTypeId()));
		myUser.setUserType(myUserType);
		myUser.setUserName(myForm.getFrmRegName());
		myUser.setUserPassword(myForm.getFrmRegPassword());
		myUser.setNrcNo(myForm.getFrmRegNRC());
		myUser.setUserPhoneNo(myForm.getFrmRegPhone());
		if(myUser.getUserType().getId().equals("8") ||myUser.getUserType().getId().equals("9")){
			myUser.setExpireDate(null);
		}
		myUser.setExpireDate(myForm.getFrmEndDate());
		myUser.setUserStatus(1);
		myUserDao.saveUser(myUser);

	}

	public void checkLoginName(UserForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("Get Login Name in UserService="+myForm.getFrmRegLoginName());
		User myUser = myUserDao.getUserByAccountName(myForm
				.getFrmRegLoginName());
		if (myUser != null) {
			myForm.setFrmRegLoginNameError("errors");
			myForm.setFrmRegFormControl(null);

		} else {
			UserType myUserType = myUserTypeDao.getUserTypeById(Integer
					.parseInt(myForm.getFrmRegUserTypeId()));

			SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
			myForm.setFrmRegDate(myFormat.format(new Date()));
			myForm.setFrmRegUserTypeName(myUserType.getUserTypeName());
			myForm.setFrmRegFormControl("data");
			myForm.setFrmRegLoginNameError("data");
		}

	}

	public void fristLoadUpdateProfile(UserForm myForm) {
		User myLoginUser = myForm.getLoginUser();
		System.out.println("Error is here!!!!!!!!!!!1");
		myForm.setFrmRegLoginName(myLoginUser.getUserLoginName());
		System.out.println("Login Name" + myLoginUser.getUserLoginName());
		myForm.setFrmRegName(myLoginUser.getUserName());
		myForm.setFrmRegPassword(myLoginUser.getUserPassword());
		myForm.setFrmRegGender(myLoginUser.getGender());
		myForm.setFrmRegEmail(myLoginUser.getUserEmail());
		// myForm.setFrmRegUserType(myLoginUser.getUserType());
		myForm.setFrmRegNRC(myLoginUser.getNrcNo());
		myForm.setFrmRegPhone(myLoginUser.getUserPhoneNo());
		myForm.setFrmRegAddress(myLoginUser.getUserAddress());
		// myForm.setFrmRegUserTypeName(myLoginUser.getUserType().getUserTypeName());
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		// myForm.setFrmRegDate(myFormat.format(myLoginUser.getRegisterDate()));
		myForm.setFrmRegFormControl(null);
		System.out.println("myForm" + myForm);
	}

	public void saveUpdateUser(UserForm myForm) {
		User myUser = myForm.getLoginUser();
		myUser.setUserAddress(myForm.getFrmRegAddress());
		myUser.setUserEmail(myForm.getFrmRegEmail());
		myUser.setUserName(myForm.getFrmRegName());
		myUser.setUserPassword(myForm.getFrmRegPassword());
		myUser.setUserPhoneNo(myForm.getFrmRegPhone());
		myUserDao.saveUser(myUser);
	}

	public void checkUserAtLDAP(UserForm myForm) {
		// Set environment to access the LDAP server
		System.out.println("in User Service!!!!!!"
				+ myForm.getFrmRegLoginName());
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				WebConstants.INITIAL_CONTEXT_FACTORY);
		env.put(Context.PROVIDER_URL, WebConstants.LDAP_URL);
		env.put(Context.SECURITY_PRINCIPAL, WebConstants.LDAP_PRINCIPAL);
		env.put(Context.SECURITY_CREDENTIALS, WebConstants.LDAP_CREDENTIALS);
		try {

			// Obtain initial directory context using the environment
			DirContext ctx = new InitialDirContext(env);
			// Set searching scope
			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
			// Search based on the scope
			NamingEnumeration<SearchResult> entries = ctx.search("dc=ictti, dc=site", "uid="+ myForm.getFrmRegLoginName().trim(),searchControls);
			if (entries.hasMore()) {
				// exist at LDAP
				myForm.setFrmRegAccountNameError("noerrors");
				
			} else { // no exist
				myForm.setFrmRegAccountNameError("errors");
				myForm.setFrmRegFormControl(null);
				//myForm.setFrmRegUserFlag("data");
			}
			// Close the directory context
			ctx.close();
		} catch (Exception e) {
			System.err.println(e);
			System.out.println("Error happens here!!!!!!!");
		}
	}
	public void prepareForMail(UserForm myForm) throws MessagingException {
			
		// Log log = LogFactory.getLog(UserService.class);
		 boolean debug = false;
		// Please load SMTP host name from your project web.xml file
		final String SMTP_HOST_NAME = "192.168.48.13";
		// Please read followings from your project database
		final String emailMsgTxt = "You have been successfully registered at ICTTI library";
		final String emailSubjectTxt = "Register Comfirmation";
		final String emailFromAddress = "admin@ictti.site";
		final String emailToAddress = myForm.getFrmRegEmail();
		// 1. Prepare Properties
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(debug);
		// 2. Create a MimeMessage
		Message msg = new MimeMessage(session);
		InternetAddress addressFrom=new InternetAddress(emailFromAddress);
		InternetAddress addressTo=new InternetAddress(emailToAddress);
		msg.setFrom(addressFrom);
		
		msg.setRecipient(Message.RecipientType.TO, addressTo);
		
		msg.setSubject(emailSubjectTxt);
		
		msg.setContent(emailMsgTxt,"text/plain");
		Transport.send(msg);
		if(log.isInfoEnabled()){
			log.info("Message sent successfully");
		}		
	}
 public void checkExpireDate(String temp,UserForm myForm){
	 IcttiCourse myIcttiCourse=myIcttiCourseDao.getExpireDateByCourseCode(temp);
	 Date expireDate=myIcttiCourse.getEndDate();
	 myForm.setFrmEndDate(expireDate);
	 
 }
}