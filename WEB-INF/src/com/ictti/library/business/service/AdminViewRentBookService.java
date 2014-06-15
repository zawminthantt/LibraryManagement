package com.ictti.library.business.service;

import java.util.List;

import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.UserType;
import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewMostRentBook;
import com.ictti.library.dao.AdminViewBookDao;
import com.ictti.library.dao.CategoryDao;
import com.ictti.library.presentation.form.AdminViewBookForm;
import com.ictti.library.presentation.form.AdminViewMemberInfoForm;

public class AdminViewRentBookService {
	private AdminViewBookDao myAdminViewBookDao;
	private CategoryDao myCategoryDao;

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public AdminViewBookDao getMyAdminViewBookDao() {
		return myAdminViewBookDao;
	}

	public void setMyAdminViewBookDao(AdminViewBookDao myAdminViewBookDao) {
		this.myAdminViewBookDao = myAdminViewBookDao;
	}

	public void fristLoad(AdminViewBookForm myForm) {
		List<Category> l = myCategoryDao.getAllCategory();
		myForm.setFrmCategoryList(l);

	}

	public List<ViewMostRentBook> loadBookInfo(AdminViewBookForm myForm) {

		List<ViewMostRentBook> myList = myAdminViewBookDao.getByBookId(myForm
				.getFrmCategoryId());
		if (myList == null) {
			System.out.println("List is null in service");
		} else {
			myForm.setFrmViewRentBookList(myList);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(myList.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(4);

		}
		return myList;
	}

	public void loadBookInfoAll(AdminViewBookForm myForm) {

		List<ViewMostRentBook> myList = myAdminViewBookDao.getByBookIdAll();
	
			myForm.setFrmViewRentBookList(myList);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(myList.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(4);
	}

}
