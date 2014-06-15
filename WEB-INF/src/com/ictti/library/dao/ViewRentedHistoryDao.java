package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.ViewRentedHistory;

public interface ViewRentedHistoryDao {

	 public List<ViewRentedHistory> getUserById(Integer id);

	 public ViewRentedHistory getCallNumberId(Integer id);
      //List<ViewRentedHistory> getCallNumberId();
	//For CheckIN
	public ViewRentedHistory getUserNameByCallNumber(String callCode);




}
