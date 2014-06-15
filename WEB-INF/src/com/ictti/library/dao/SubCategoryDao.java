package com.ictti.library.dao;

import java.util.List;

import com.ictti.library.business.entity.SubCategory;



public interface SubCategoryDao {
	public List<SubCategory> getBySubcategory(String categoryId);

	public List<SubCategory> getBySubcategorybyid(Integer catId);

	public SubCategory getBySubcategoryid(Integer catId);
	//2.9.2011
	
	//For book registration
	public SubCategory getSubCategoryId(Integer catId);
	
	
	
}
