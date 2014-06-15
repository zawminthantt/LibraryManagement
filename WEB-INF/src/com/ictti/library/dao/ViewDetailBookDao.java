package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.ViewDetailBook;

public interface ViewDetailBookDao {

	 public List<ViewDetailBook> getBookInfoByIsbnNo(String isbn);
     public ViewDetailBook getBookInfoByIsbn(String isbn);
	 public ViewDetailBook getBookIdbyCallCode(String c_code);
	 public List<ViewDetailBook> getCallNumberList(int book_id); 
	

}