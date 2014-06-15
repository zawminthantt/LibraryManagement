package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.BookReserve;

public interface BookReserveDao {
	public BookReserve getAllDataById(Integer callNumberId);
	public void saveOrUpdate(BookReserve newBookReserve);
	
	public BookReserve getBookReserveByUserId(Integer id);

	public List<BookReserve> findAll(Integer userId);

	public BookReserve getById(Integer Id);
	
	public BookReserve getUserById(int id);
	//public CallNumber getCallNumberByBookId(Integer id);
	//public List<ViewDetailBook>  getUserById(int id);
	
	//public void saveOrUpdate(BookReserve myBookReserve);

	public BookReserve getStatus(Integer c_id);
	//public BookReserve getStatus();
	//public BookReserve getReserveStatus(Integer c_id);
	
	//For Check Out
	public BookReserve getReserveInfoByUserId(int user_id,int call_id);
	
	public BookReserve getReserveInfoByCallId(int call_id);
	
	public BookReserve getReserveStatus(int usr_id, int call_id);

	public void saveReserveStatus(BookReserve myReserve);

}