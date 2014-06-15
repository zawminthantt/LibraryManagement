package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.Category;



public interface CategoryDao {
	public List<Category> getAllCategory();
	public Category getByCategoryName(String catid);
	public Category getCategoryById(Integer catid);
	
   
}
