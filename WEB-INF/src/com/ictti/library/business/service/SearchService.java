package com.ictti.library.business.service;

import java.util.List;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.CategoryDao;
import com.ictti.library.presentation.form.SearchForm;

public class SearchService {
	private BookListDao myBookListDao;
	private CategoryDao myCategoryDao;

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	public void detailForSearch(SearchForm myForm) {
		// TODO Auto-generated method stub
		BookList myBook = myBookListDao.getBookListById(Integer.parseInt(myForm
				.getFrmDetailBookId()));
		// myForm.setFrmBooksDetail(myBook);

	}

	public List<BookList> firstLoadSearch(SearchForm myForm) {
		// TODO Auto-generated method stub
		List<BookList> l = myBookListDao.getBookListByTitle(myForm
				.getFrmBookTitle());
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			// set the first page
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
		}
		return l;
	}

}