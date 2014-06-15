package com.ictti.library.business.service;

import java.util.List;
import java.util.Set;

import com.ictti.library.business.entity.AccessionCode;
import com.ictti.library.business.entity.Author;
import com.ictti.library.business.entity.BookAuthor;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.dao.AccessionDao;
import com.ictti.library.dao.AuthorDao;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.ViewDetailBookDao;
import com.ictti.library.presentation.form.CheckOutForm;

public class BookUpdateService {
	
	private ViewDetailBookDao myViewDetailBookDao;
	private BookListDao myBookListDao;
	private CallNumberDao myCallNumberDao;
	private AuthorDao myAuthorDao;
	private AccessionDao myAccessionCodeDao;
	

	public AccessionDao getMyAccessionCodeDao() {
		return myAccessionCodeDao;
	}

	public void setMyAccessionCodeDao(AccessionDao myAccessionCodeDao) {
		this.myAccessionCodeDao = myAccessionCodeDao;
	}

	public AuthorDao getMyAuthorDao() {
		return myAuthorDao;
	}

	public void setMyAuthorDao(AuthorDao myAuthorDao) {
		this.myAuthorDao = myAuthorDao;
	}

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	public void setMyViewDetailBookDao(ViewDetailBookDao myViewDetailBookDao) {
		this.myViewDetailBookDao = myViewDetailBookDao;
	}

	public ViewDetailBookDao getMyViewDetailBookDao() {
		return myViewDetailBookDao;
	}
	
	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}
	
	public void getBookInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String isbn=myForm.getFrmIsbn();
		ViewDetailBook myViewDetailBook=myViewDetailBookDao.getBookInfoByIsbn(isbn);
		myForm.setFrmViewDetailBook(myViewDetailBook);
		
	}

	public void saveBookUpdateInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int cp=myForm.getNoOfcopies();
		System.out.println("No Of Copy in Book Update Service!!!!"+cp);
		List<CallNumber> l=myCallNumberDao.getLastAccessionNo();
		int size=l.size();
		System.out.println("in service"+size);
		/*CallNumber c=l.get(size);
		int last_no=c.getAccessionNo();
		int c_id=c.getId();*/
		
		int book_id=myForm.getFrmViewDetailBook().getBookId();
		int author_id=myForm.getFrmViewDetailBook().getAuthorId();
		int accession_id=myForm.getFrmViewDetailBook().getAccessionId();
		String call_code=myForm.getFrmViewDetailBook().getCallNumberCode();
		System.out.println("Call Code"+call_code);
		String[] temp_callCode;
		String delimiter = "-";
		temp_callCode=call_code.split(delimiter);
		String st="";
		st+=temp_callCode[0];
		String st1="-";
		String st2=st+st1;
		System.out.println("Call number Code"+st2);
		for(int i=1;i<=cp;i++){
			CallNumber myCallNo=new CallNumber();
			int accession_no=size+i;
			myCallNo.setId(null);
			//int accession_no=size+i;
		    String st3=Integer.toString(accession_no);
			myCallNo.setCallNumberCode(st2+st3);
			myCallNo.setAccessionNo(accession_no);
			myCallNo.setIssuseStatus(1);
		    BookList myBookList=myBookListDao.getBookListById(book_id);
		    /*myBookList.setId(book_id);
		    AccessionCode myAccession=
		    myCallNo.setAccession(myAccession);*/
		    //BookList myBook=
		    myCallNo.setBook(myBookList);
		    Author myAuthor=myAuthorDao.getAuthorById(author_id);
		    myCallNo.setAuthor(myAuthor);
		   // myAuthor.setId(author_id);
		  //  myAuthor.setBookAuthors((Set<BookAuthor>) myAuthor);
		    AccessionCode myAccessionCode=myAccessionCodeDao.getAccessionCodeById(accession_id);
		   // myAccessionCode.setId(accession_id);
		    myCallNo.setAccession(myAccessionCode);
		    myCallNumberDao.saveBookUpdateInfo(myCallNo);
		}
		
	}

	public void saveBookListInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int id=myForm.getFrmViewDetailBook().getBookId();
		BookList myBookList=myBookListDao.getBookListById(id);
		int c=myForm.getFrmViewDetailBook().getNoofcopies();
		int copy=c+myForm.getNoOfcopies();
		myForm.setNoOfcopies(copy);
		myBookList.setNoOfCopy(copy);
		myBookListDao.saveBookInfo(myBookList);
		
	}

	public void firstLoadBookUpdate(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String isbn=myForm.getFrmIsbn();
		ViewDetailBook myViewDetailBook=myViewDetailBookDao.getBookInfoByIsbn(isbn);
		myForm.setFrmViewDetailBook(myViewDetailBook);
		int cp=myViewDetailBook.getNoofcopies();
		System.out.println("No of Copy in First Load Book Update="+cp);
		myForm.setNoOfcopies(cp);
		
	}
}
