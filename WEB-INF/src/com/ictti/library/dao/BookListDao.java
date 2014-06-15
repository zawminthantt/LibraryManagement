package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.ViewDetailBook;



public interface BookListDao {
	public List<BookList> getBookListByTitle(String a_strTitle);
	public BookList getBookListById(int id);
	public List<BookList> getBookListAll();
	public void saveNewBook(BookList myBook);
	public BookList getByBookISBN(String isbn);
	//For Book Update
	public void saveBookInfo(BookList myBookList);
	//For Book Delete
	public void saveChangeCopy(BookList myBook);


	
}
