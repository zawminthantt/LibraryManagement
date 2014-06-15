package com.ictti.library.dao;
import java.util.List;
import com.ictti.library.business.entity.ViewRecall;
public interface RecallDao {
	public ViewRecall getById(Integer id);
	public List<ViewRecall> findAll();
	public List<ViewRecall> findAll(java.util.Date date);
	public List<ViewRecall> findAll(String st);
	}
	
