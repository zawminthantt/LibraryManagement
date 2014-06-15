package com.ictti.library.business.service;

import java.util.List;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.CallNumberDao;
import com.ictti.library.dao.ViewDetailBookDao;
import com.ictti.library.presentation.form.CheckOutForm;

public class BookDeleteService {
	private ViewDetailBookDao myViewDetailBookDao;
	private BookListDao myBookListDao;
	private CallNumberDao myCallNumberDao;
	
	public ViewDetailBookDao getMyViewDetailBookDao() {
		return myViewDetailBookDao;
	}

	public void setMyViewDetailBookDao(ViewDetailBookDao myViewDetailBookDao) {
		this.myViewDetailBookDao = myViewDetailBookDao;
	}

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	public CallNumberDao getMyCallNumberDao() {
		return myCallNumberDao;
	}

	public void setMyCallNumberDao(CallNumberDao myCallNumberDao) {
		this.myCallNumberDao = myCallNumberDao;
	}

	public List<ViewDetailBook> getBookInfo(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		String isbn=myForm.getFrmIsbn();
		List<ViewDetailBook> myViewDetailBook=myViewDetailBookDao.getBookInfoByIsbnNo(isbn);
		//myForm.setFrmViewDetailBook(myViewDetailBook);
		myForm.setMyViewDetailBook(myViewDetailBook);
		return myViewDetailBook;
	}

	public void deleteBookByCallNumber(List<Object> callnumberlist) {
		// TODO Auto-generated method stub
		for(int i=0;i<callnumberlist.size();i++){
		int	call_id=Integer.parseInt(callnumberlist.get(i).toString());
		System.out.println("Call Number Id in Service!!"+call_id);
		CallNumber myCall=myCallNumberDao.getCallNumberById(call_id);
		myCall.setIssuseStatus(3);
		myCallNumberDao.saveChangeStatus(myCall);
		}	
	}

	public void deleteCopyByBookId(CheckOutForm myForm) {
		// TODO Auto-generated method stub
		int copy=myForm.getMyViewDetailBook().get(0).getNoofcopies();
		int item=myForm.getSelectedItem().length;
		int cp=copy-item;
		int b_id=myForm.getMyViewDetailBook().get(0).getBookId();
		System.out.println("Book Id in Action"+b_id);
		BookList myBook=myBookListDao.getBookListById(b_id);
		myBook.setNoOfCopy(cp);
		myBookListDao.saveChangeCopy(myBook);
	}

	

}
