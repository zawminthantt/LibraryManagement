package com.ictti.library.dao;

import java.util.Date;
import java.util.List;

import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewReserveBook;

public interface ViewReserveBookDao {
	public ViewReserveBook getById(Integer userId);
	//public List<BookReserve> getBookListById(String bookReserveId);
	public List<ViewReserveBook> getBookListAll();
	public List<ViewReserveBook>  getByUserId(Integer userId);
	public void updateBookReserve(CallNumber myCallNumber);
	//For Admin View Reservation
	public List<ViewReserveBook> getBookListByDate(Date myD1,Date myD2);
	public List<ViewReserveBook> getBookInfoByIsbnNo(String isbn);



}
