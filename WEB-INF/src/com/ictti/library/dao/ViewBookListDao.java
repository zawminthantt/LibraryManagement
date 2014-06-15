package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewDetailBook;

public interface ViewBookListDao {

	 public	ViewDetailBook getBookListById(Integer id);

	public List<ViewDetailBook> getBookInfo(int callnumber);

}
