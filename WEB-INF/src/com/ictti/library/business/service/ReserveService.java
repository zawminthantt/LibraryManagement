package com.ictti.library.business.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.hibernate.Hibernate;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.Photo;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.ViewDetailBook;

import com.ictti.library.dao.BookOnLoanDao;
import com.ictti.library.dao.BookReserveDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.PhotoDao;
import com.ictti.library.dao.UserDao;
import com.ictti.library.dao.ViewBookListDao;
import com.ictti.library.presentation.form.UserForm;

public class ReserveService {
	private static Log log=LogFactory.getLog(UserService.class);
	private ViewBookListDao myViewBookListDao;
	private PhotoDao myPhotoDao;
	
	
	public PhotoDao getMyPhotoDao() {
		return myPhotoDao;
	}

	public void setMyPhotoDao(PhotoDao myPhotoDao) {
		this.myPhotoDao = myPhotoDao;
	}

	public ViewBookListDao getMyViewBookListDao() {
		return myViewBookListDao;
	}

	public void setMyViewBookListDao(ViewBookListDao myViewBookListDao) {
		this.myViewBookListDao = myViewBookListDao;
	}

	private BookReserveDao myReserveDao;
	public BookReserveDao getMyReserveDao() {
		return myReserveDao;
	}

	public void setMyReserveDao(BookReserveDao myReserveDao) {
		this.myReserveDao = myReserveDao;
	}

	private CallNumberDao myCallNumberDao;
	private BookOnLoanDao myBookOnLoanDao;
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

	

	public void getAllBookInfo(UserForm myForm) {
		// TODO Auto-generated method stub
		User myLoginUser = myForm.getLoginUser();
		myForm.setFrmusr_id(myLoginUser.getId());
		ViewDetailBook myViewBookList= myViewBookListDao.getBookListById(Integer.parseInt(myForm.getFrmDetailBookId()));
		System.out.println("In Service!!!!"+myViewBookList.getTitle());
		//myForm.setFrmDetailBookId(myViewBookList);
		myForm.setMyViewBookList(myViewBookList);
	}

	public void getAvailableDate(UserForm myForm) {
		// TODO Auto-generated method stub
		List<CallNumber> l=myCallNumberDao.getCallNumberByBookId(Integer.parseInt(myForm.getFrmDetailBookId()));
		if(l==null){
			myForm.setFrmreserveFlag("data");
		}
		//System.out.println("in Service at Available Date"+l.size());
		else{
			CallNumber c=l.get(0);
			System.out.println("In getAvailableDate ="+c.getId());
			Date first=new Date();//today's date
			Date second=new Date();//today's date
			System.out.println("Today Date:"+ first);
			Date d=new Date();
			int callNo=0;
			if(l.size()==1)
			{
				List<BookOnLoan> l1=myBookOnLoanDao.getEarilestDateByCallNumber(l.get(0).getId());
				
				if(l1!=null)
				{callNo=l1.get(0).getCallnumber().getId();
				Date dDate=l1.get(0).getDueDate();
				//String callCode=l1.get(0).getCallnumber().getCallNumberCode();	
				System.out.println("in get available date"+callNo);
				myForm.setA_Date(dDate);
				myForm.setCallNo(callNo);
				//myForm.setCallNumberCode(callCode);
				CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
				String code=c_code.getCallNumberCode().toString();
				System.out.println("Call Number Code!!!!"+code);
				myForm.setCallNumberCode(code);
				System.out.println("Available Date:"+myForm.getA_Date());
				System.out.println("Due Date:"+ d);
				}
				else{
					myForm.setFrmCallNumberFlag("data");
									
				}
			}
			if(l.size()>1){
			
			for(int i=0;i<l.size();i++)
			{
				System.out.println(l.get(i).getId());
				if(l.get(i).getIssuseStatus()==1){
					myForm.setFrmCallNumberFlag("data");
					break;
				}
				else{
				List<BookOnLoan> l1=myBookOnLoanDao.getEarilestDateByCallNumber(l.get(i).getId());
				Date dDate=l1.get(0).getDueDate();
				 // System.out.println("Due Date:" + dDate);
								
				if(first.compareTo(dDate)>0){
					first=dDate;
					callNo=l1.get(0).getCallnumber().getId();
					 myForm.setA_Date(dDate);
					 myForm.setCallNo(callNo);
					System.out.println("Available Date:"+myForm.getA_Date());
					System.out.println("Due Date:"+ d);
					CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
					String code=c_code.getCallNumberCode().toString();
					System.out.println("Call Number Code!!!!"+code);
					myForm.setCallNumberCode(code);
				}
				else{
					second=first;				
					callNo=l1.get(0).getCallnumber().getId();
					myForm.setCallNo(callNo);
					myForm.setA_Date(dDate);
					if(i==0)
				    {
					first=dDate;
					callNo=l1.get(0).getCallnumber().getId();
					myForm.setA_Date(first);
					myForm.setCallNo(callNo);
					System.out.println("Available Date:"+myForm.getA_Date());
					System.out.println("Due Date:"+ d);
					CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
					String code=c_code.getCallNumberCode().toString();
					System.out.println("Call Number Code!!!!"+code);
					myForm.setCallNumberCode(code);
					}
					
				}
				
				 callNo=l1.get(0).getCallnumber().getId();
				// myForm.setA_Date(d);
				 myForm.setA_Date(dDate);
				 myForm.setCallNo(callNo);
				
				}
			}
				/*CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
				String code=c_code.getCallNumberCode().toString();
				System.out.println("Call Number Code!!!!"+code);
				myForm.setCallNumberCode(code);*/
			}
		    System.out.println("Earilest Date!!!!!"+d);
		    System.out.println("Call Number!!!!"+callNo);
		}
	/*	CallNumber c=l.get(0);
		System.out.println("In getAvailableDate ="+c.getId());
		Date first=new Date();//today's date
		Date second=new Date();//today's date
		System.out.println("Today Date:"+ first);
		Date d=new Date();
		int callNo=0;
		if(l.size()==1)
		{
			List<BookOnLoan> l1=myBookOnLoanDao.getEarilestDateByCallNumber(l.get(0).getId());
			
			if(l1!=null)
			{callNo=l1.get(0).getCallnumber().getId();
			Date dDate=l1.get(0).getDueDate();
			//String callCode=l1.get(0).getCallnumber().getCallNumberCode();	
			System.out.println("in get available date"+callNo);
			myForm.setA_Date(dDate);
			myForm.setCallNo(callNo);
			//myForm.setCallNumberCode(callCode);
			CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
			String code=c_code.getCallNumberCode().toString();
			System.out.println("Call Number Code!!!!"+code);
			myForm.setCallNumberCode(code);
			System.out.println("Available Date:"+myForm.getA_Date());
			System.out.println("Due Date:"+ d);
			}
			else{
				myForm.setFrmCallNumberFlag("data");
								
			}
		}
		if(l.size()>1){
		
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getId());
			if(l.get(i).getIssuseStatus()==1){
				myForm.setFrmCallNumberFlag("data");
				break;
			}
			else{
			List<BookOnLoan> l1=myBookOnLoanDao.getEarilestDateByCallNumber(l.get(i).getId());
			Date dDate=l1.get(0).getDueDate();
			 // System.out.println("Due Date:" + dDate);
							
			if(first.compareTo(dDate)>0){
				first=dDate;
				callNo=l1.get(0).getCallnumber().getId();
				 myForm.setA_Date(dDate);
				 myForm.setCallNo(callNo);
				System.out.println("Available Date:"+myForm.getA_Date());
				System.out.println("Due Date:"+ d);
				CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
				String code=c_code.getCallNumberCode().toString();
				System.out.println("Call Number Code!!!!"+code);
				myForm.setCallNumberCode(code);
			}
			else{
				second=first;				
				callNo=l1.get(0).getCallnumber().getId();
				myForm.setCallNo(callNo);
				myForm.setA_Date(dDate);
				if(i==0)
			    {
				first=dDate;
				callNo=l1.get(0).getCallnumber().getId();
				myForm.setA_Date(first);
				myForm.setCallNo(callNo);
				System.out.println("Available Date:"+myForm.getA_Date());
				System.out.println("Due Date:"+ d);
				CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
				String code=c_code.getCallNumberCode().toString();
				System.out.println("Call Number Code!!!!"+code);
				myForm.setCallNumberCode(code);
				}
				
			}
			
			 callNo=l1.get(0).getCallnumber().getId();
			 myForm.setA_Date(d);
			 myForm.setCallNo(callNo);
			
			}
		}
			CallNumber c_code=myCallNumberDao.getCallNumberCodeByCallNumber(callNo);
			String code=c_code.getCallNumberCode().toString();
			System.out.println("Call Number Code!!!!"+code);
			myForm.setCallNumberCode(code);
		}
	    System.out.println("Earilest Date!!!!!"+d);
	    System.out.println("Call Number!!!!"+callNo);*/
	   
	}

	public void checkLoginUserId(UserForm myForm) {
		// TODO Auto-generated method stub
		BookReserve myBookReserve=myReserveDao.getUserById(myForm.getFrmusr_id());
		if(myBookReserve!=null){
			
			myForm.setFrmUserFlag("data");
			System.out.println("This is testing for service"+ myForm.getFrmRegUserFlag());
			System.out.println("in Res Service!!!"+myForm.getFrmusr_id());
		}
	}
/*save Reserve Information*/
	public void saveReserveInfo(UserForm myForm) {
		// TODO Auto-generated method stub
		BookReserve myBookReserve= new BookReserve();
		myBookReserve.setId(null);
		myBookReserve.setReserveDate(new Date());
		myBookReserve.setReserveStatus(0);
		CallNumber myCallNo=myCallNumberDao.getCallNumberById(myForm.getCallNo());
	    myBookReserve.setCallnumber(myCallNo);
	    User myUser=myUserDao.getUserById(myForm.getFrmusr_id());
	    myForm.setFrmRegEmail(myUser.getUserEmail());
	   // myForm.setFrmRegLoginName(myUser.getUserLoginName());
	    myForm.setFrmRegName(myUser.getUserName());
	    //BookReserve myUserId=myReserveDao.getUserById(myForm.getFrmusr_id());
	    myBookReserve.setUser(myUser);
		myBookReserve.setAvailDate(myForm.getA_Date());
	    myReserveDao.saveOrUpdate(myBookReserve);
	}
	/*Send Reserve Email*/
	public void prepareForMail(UserForm myForm) throws MessagingException {	
		// Log log = LogFactory.getLog(UserService.class);
		 boolean debug = false;
		// Please load SMTP host name from your project web.xml file
		final String SMTP_HOST_NAME = "192.168.48.13";
		// Please read followings from your project database
		//final String emailMsgTxt = "You have been successfully registered at ICTTI library";
		final String memberName=myForm.getFrmRegName();
		final int memberId=myForm.getFrmusr_id();
		//final int callnumber=myForm.getCallNo();
		final String callNumberCode=myForm.getCallNumberCode();
		final String emailSubjectTxt = "Book Reserve Comfirmation";
		final String emailFromAddress = "admin@ictti.site";
		final String emailToAddress = myForm.getFrmRegEmail();
		System.out.println("User email"+emailToAddress);
		//final String emailToAddress = "ps9-ayeaye@ictti.site";
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
		  String strMailContext = "Dear " + memberName + "," + "\n\t\t\t"
          + "Your Reservation is Finished. " + "\n\t\t\t"
          + "Library member ID=\"" + memberId + "\""
          + "\n\t\t\t"
          + "Callnumber=\"" +  callNumberCode + "\""
          + "\n\t\t\t"
          + "\n\t\t\t"
          + "You have already reserved the above book."
          + "\n\t\t\t"
          + "From now on you can rent this book from our library notice."
          + "\n\t\t\t" + "Thanks for your reservation."
          + "\n\n\t\t\t\t\t\t\t"
          +"Yours sincerely,"
          +"\n\t\t\t\t\t\t\t"
          +"ICTTI Library Admin";

		msg.setContent(strMailContext,"text/plain");
		Transport.send(msg);
		if(log.isInfoEnabled()){
			log.info("Message sent successfully");
		}		
	}
//Retrieve photo
	/*public void retrievePhoto(UserForm myForm) {
		// TODO Auto-generated method stub
	      Photo myPhoto=myPhotoDao.getPhotoById(Integer.valueOf(myForm.getFrmPhotoId()));
		//Photo myPhoto=myPhotoDao.getPhotoById(Integer.parseInt(myForm.getFrmPhotoId()));
		myForm.setFrmPhoto(myPhoto);
	}*/
	//Upload Photo
	/*public void saveUploadPhoto(UserForm myForm){
		FileOutputStream outputStream = null;
		FormFile formFile = myForm.getFrmUploadFile();
		Blob bfile;
		try {
			bfile = Hibernate.createBlob(formFile.getInputStream());
			String fst = formFile.getFileName().trim();
			Integer size = formFile.getFileSize();
			//IcttiFile myFile = new IcttiFile();
			Photo myPhoto=new Photo();
			myPhoto.setId(null);
			myPhoto.setPhotoName(fst);
			myPhoto.setPhotoData(bfile);
			myPhoto.setPhotoType(formFile.getContentType());
			myPhoto.setPhotoSize(size);
			myPhotoDao.saveNewPhoto(myPhoto);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/

	public void changeCallNumberStatus(UserForm myForm) {
		// TODO Auto-generated method stub
		CallNumber myCall=myCallNumberDao.getCallNumberById(myForm.getCallNo());
		System.out.println("In Changing Call Number Status"+myCall.getId());
		myCall.setIssuseStatus(2);
		myCallNumberDao.saveIssueStatusByReserve(myCall);
	}
		
}