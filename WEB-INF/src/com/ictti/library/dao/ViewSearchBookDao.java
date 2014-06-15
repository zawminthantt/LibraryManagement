package com.ictti.library.dao;
import java.util.List;
import com.ictti.library.business.entity.ViewSearchBook;
import com.ictti.library.presentation.form.SearchDetailForm;

public interface ViewSearchBookDao {
	public List<ViewSearchBook> getBookListByTitle(String strTitle);//Search by Title
	public List<ViewSearchBook> getBookListByAuthor(String a_strAuthor);//Search by Author
	public List<ViewSearchBook> searchByTitleAuthor(String a_strTitle,String a_strAuthor);//Search by Title & Author
	public List<ViewSearchBook> getBookListByAll(Integer categoryId,Integer subcategoryId);//Search by ALL & ALL
	public List<ViewSearchBook> getViewBookListByCategoryAndSubCategory(String categoryId,String subcategoryId);//Search by Category & SubCategory
	public List<ViewSearchBook> getViewBookListByTitleCategoryAndSubCategory(String title,Integer categoryId,Integer subcategoryId );//Search by Title & Category & SubCategory
	public List<ViewSearchBook> getViewBookListByAuthorCategoryAndSubCategory(String author,Integer categoryId,Integer subcategoryId );//Search by Author & Category & SubCategory
	public List<ViewSearchBook> getViewBookListByAllCriteria(String title,String author,Integer categoryId,Integer subcategoryId );//Search by Title & Author & Category & SubCategory
	public ViewSearchBook getBookListById(int id);  
	public List<ViewSearchBook> getBookListDetail();
	
	
}
