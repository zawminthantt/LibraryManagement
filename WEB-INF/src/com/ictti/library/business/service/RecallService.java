package com.ictti.library.business.service;

import java.util.Date;
import java.util.List;
import com.ictti.library.business.entity.ViewRecall;
import com.ictti.library.dao.RecallDao;

public class RecallService<Accessioncode> {
	private RecallDao myRecallDao;

	public RecallDao getMyRecallDao() {
		return myRecallDao;
	}

	public void setMyRecallDao(RecallDao myRecallDao) {
		this.myRecallDao = myRecallDao;
	}

	public List<ViewRecall> findAll() {
		return myRecallDao.findAll();
	}

	public RecallDao getMyViewrecallDao() {
		return myRecallDao;
	}

	public void setMyViewrecallDao(RecallDao myRecallDao) {
		this.myRecallDao = myRecallDao;
	}

	public List<ViewRecall> findAll(Date date) {
		// TODO Auto-generated method stub
		return myRecallDao.findAll(date);
	}

	/*public void firstLoadRecall(RecallForm myform) {
		// TODO Auto-generated method stub
		myform.setFrmRegFormControl(null);
		
	}*/
	
}