package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.CallNumber;




public interface CallNumberDao {
	
	public List<CallNumber> getCallNumberByBookId(int id);
	public CallNumber getCallNumberById(int id);
	public CallNumber getCallNumberById(Integer callNumberId);
	public void saveOrUpdate(CallNumber myCallNumber);
	public CallNumber getCallNumberCodeByCallNumber(int callNo);
	
	public Integer getCallNumberCount();//For book registration
	public void saveCallnumber(CallNumber myCallNumber);
	
	//For Check In
	public void saveCheckinCallInfo(CallNumber myCallNumber);
	
	//For Book Update
	public List<CallNumber> getLastAccessionNo();
	public void saveBookUpdateInfo(CallNumber myCallNo);
	
	//For Book Delete
	public void saveChangeStatus(CallNumber myCall);
	
	//For Check Out
	public CallNumber getCallNumberIDByCallNumberCode(String c_code);
	public void saveIssuseStatus(CallNumber myCallNo);
	public List<CallNumber> getCallNumberList(String call_code);
	public CallNumber checkCallCode(String callCode);
	public void saveIssueStatusByReserve(CallNumber myCall);
	public CallNumber getCallStatus(String callCode);
	



	

}