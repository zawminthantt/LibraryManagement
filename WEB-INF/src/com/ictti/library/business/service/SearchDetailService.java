package com.ictti.library.business.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionErrors;

import com.ictti.library.business.entity.Author;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.Photo;
import com.ictti.library.business.entity.SubCategory;

import com.ictti.library.business.entity.ViewSearchBook;

import com.ictti.library.dao.AuthorDao;
import com.ictti.library.dao.BookListDao;
import com.ictti.library.dao.CategoryDao;
import com.ictti.library.dao.PhotoDao;
import com.ictti.library.dao.SubCategoryDao;
import com.ictti.library.dao.ViewSearchBookDao;
import com.ictti.library.presentation.form.SearchDetailForm;

public class SearchDetailService {
	private BookListDao myBookListDao;
	private AuthorDao myAuthorDao;
	private CategoryDao myCategoryDao;
	private SubCategoryDao mySubCategoryDao;
	private PhotoDao myPhotoDao;
	ActionErrors errors = new ActionErrors();

	public PhotoDao getMyPhotoDao() {
		return myPhotoDao;
	}

	public void setMyPhotoDao(PhotoDao myPhotoDao) {
		this.myPhotoDao = myPhotoDao;
	}

	public SubCategoryDao getMySubCategoryDao() {
		return mySubCategoryDao;
	}

	public void setMySubCategoryDao(SubCategoryDao mySubCategoryDao) {
		this.mySubCategoryDao = mySubCategoryDao;
	}

	public CategoryDao getMyCategoryDao() {
		return myCategoryDao;
	}

	public void setMyCategoryDao(CategoryDao myCategoryDao) {
		this.myCategoryDao = myCategoryDao;
	}

	public AuthorDao getMyAuthorDao() {
		return myAuthorDao;
	}

	public void setMyAuthorDao(AuthorDao myAuthorDao) {
		this.myAuthorDao = myAuthorDao;
	}

	public BookListDao getMyBookListDao() {
		return myBookListDao;
	}

	public void setMyBookListDao(BookListDao myBookListDao) {
		this.myBookListDao = myBookListDao;
	}

	private ViewSearchBookDao myViewBookSearchDao;

	public ViewSearchBookDao getMyViewBookSearchDao() {
		return myViewBookSearchDao;
	}

	public void setMyViewBookSearchDao(ViewSearchBookDao myViewBookSearchDao) {
		this.myViewBookSearchDao = myViewBookSearchDao;
	}

	public List<BookList> findBookByLikeFromService(String a_strTitle) {
		List<BookList> l = myBookListDao.getBookListByTitle(a_strTitle);
		return l == null ? null : l;
	}

	public List<Author> findByAuthorNameLikeService(String a_strName) {
		List<Author> l = myAuthorDao.getAuthorListByName(a_strName);
		return l == null ? null : l;
	}

	public List<BookList> findBookByTitleService(String title) {
		List<BookList> l = myBookListDao.getBookListByTitle(title);
		return l.isEmpty() || l == null ? null : l;
	}

	public List<Category> getAllCategory() {
		List<Category> list = myCategoryDao.getAllCategory();
		return list.isEmpty() || list == null ? null : list;
	}

	public List<SubCategory> getBySubCategory(String categoryId) {
		List<SubCategory> l = mySubCategoryDao.getBySubcategory(categoryId);
		return l.isEmpty() || l == null ? null : l;
	}

	// to retrieve sub category list with category id

	public List getBySubcategory(Integer categoryId) {
		System.out.println("****SubcategoryService#getBySubcategory;param="
				+ categoryId);
		List<SubCategory> list = mySubCategoryDao
				.getBySubcategorybyid(categoryId);
		return list;
	}

	// added 10/03getByCategorySubcategory
	public List getByCategorySubcategory(String categoryId, String subcategoryId) {
		System.out
				.println("$$$$$$$$SubcategoryService#getBySubcategory;paramcategoryid="
						+ categoryId + "paramsubcategoryid" + subcategoryId);

		List<SubCategory> list = getBySubcategory(Integer.parseInt(categoryId));
		List<SubCategory> templist = new ArrayList<SubCategory>();

		if (categoryId.length() == 0) {
			System.out.println("Category Id is null, so we insert default 1");
			categoryId = "1";

		}
		if (subcategoryId == null) {
			System.out.println("Category Id is null, so we insert default 1");
			subcategoryId = "8";
		}
		if (subcategoryId.length() == 0) {
			System.out
					.println("SubCategory Id is null, so we insert default 1");
			subcategoryId = "8";
		}

		int catid;
		try {
			catid = Integer.valueOf(categoryId);
		} catch (NumberFormatException e) {

			Category category = myCategoryDao.getByCategoryName(categoryId);
			catid = category.getId();
		}
		int subcatid = Integer.parseInt(subcategoryId);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == subcatid) {
				templist.add(list.get(i));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() != subcatid) {
				templist.add(list.get(i));
			}
		}
		return templist;
	}// end of getByCategorySubcategory
		// Search by Title

	public List<ViewSearchBook> firstLoadSearchByTitle(SearchDetailForm myForm) {
		List<ViewSearchBook> l = myViewBookSearchDao.getBookListByTitle(myForm
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

	// Search By Author For Inner Search
	public List<ViewSearchBook> firstLoadSearchByAuthor(SearchDetailForm myForm) {
		List<ViewSearchBook> l = myViewBookSearchDao.getBookListByAuthor(myForm
				.getFrmAuthorName());

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

	// To show Book Information detail
	public void detailForSearch(SearchDetailForm myForm) {
		// TODO Auto-generated method stub
		ViewSearchBook myBook = myViewBookSearchDao.getBookListById(Integer
				.parseInt(myForm.getFrmDetailBookId()));

		myForm.setFrmViewBook(myBook);
	}

	// Search by Title & Author for Inner Search
	public List<ViewSearchBook> searchByTitleAuthor(SearchDetailForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("This is firstLoadSearchByTitleAuthor"
				+ myForm.getFrmAuthorName() + myForm.getFrmBookTitle());
		List<ViewSearchBook> l = myViewBookSearchDao.searchByTitleAuthor(
				myForm.getFrmBookTitle(), myForm.getFrmAuthorName());
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			System.out.println("This is dao For Title and Author " + l);
			// set the first page
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
		}
		return l;
	}

	// Search by All for Inner Search
	public List<ViewSearchBook> searchByAll(SearchDetailForm myForm) {
		// TODO Auto-generated method stub
		System.out.println("This is searchByAll testing");
		List<ViewSearchBook> l = myViewBookSearchDao.getBookListByAll(
				Integer.parseInt(myForm.getCategoryId()),
				Integer.parseInt(myForm.getSubcategoryId()));
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			System.out.println("This is dao For All " + l);

			// set the first page
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
		}
		return l;

	}

	// Search by Category & SubCategory for Inner Search
	public List<ViewSearchBook> getViewBookListByCategoryAndSubcategory(
			SearchDetailForm myForm) {
		System.out.println("This is searchByCategory and SubCategory testing");
		List<ViewSearchBook> l = myViewBookSearchDao
				.getViewBookListByCategoryAndSubCategory(
						myForm.getCategoryId(), myForm.getSubcategoryId());
		System.out.println("This is dao For Category and SubCategory " + l);
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
			System.out.println("This is dao For Category and SubCategory " + l);
		}
		return l;
	}

	// Search by Title & Category & SubCategory for Inner Search
	public List<ViewSearchBook> searchByTitleCategorySubCategory(
			SearchDetailForm myForm) {

		List<ViewSearchBook> l = myViewBookSearchDao
				.getViewBookListByTitleCategoryAndSubCategory(
						myForm.getFrmBookTitle(),
						Integer.parseInt(myForm.getCategoryId()),
						Integer.parseInt(myForm.getSubcategoryId()));
		System.out.println("This is dao For Category and SubCategory " + l);
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
			System.out
					.println("This is dao For Title,Category and SubCategory "
							+ l);
		}
		return l;
	}

	// Search by Author & Category & SubCategory for Inner Search
	public List<ViewSearchBook> searchByAuthorCategorySubCategory(
			SearchDetailForm myForm) {

		List<ViewSearchBook> l = myViewBookSearchDao
				.getViewBookListByAuthorCategoryAndSubCategory(
						myForm.getFrmAuthorName(),
						Integer.parseInt(myForm.getCategoryId()),
						Integer.parseInt(myForm.getSubcategoryId()));
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
			System.out
					.println("This is dao For Title,Category and SubCategory "
							+ l);
		}
		return l;
	}

	// Search by Title & Author & Category & SubCategory for Inner Search
	public List<ViewSearchBook> searchByAllCriteria(SearchDetailForm myForm) {

		List<ViewSearchBook> l = myViewBookSearchDao
				.getViewBookListByAllCriteria(myForm.getFrmBookTitle(),
						myForm.getFrmAuthorName(),
						Integer.parseInt(myForm.getCategoryId()),
						Integer.parseInt(myForm.getSubcategoryId()));
		if (l == null) {
			System.out.println("List is null in service ");
		} else {
			myForm.setFrmBookList(l);
			myForm.setActualPage(1);
			// set the maximum size of the result list
			myForm.setiMaxData(l.size());
			// set the maximum size to show the current page
			myForm.setiMaxShow(20);
			System.out
					.println("This is dao For Title,Category and SubCategory "
							+ l);
		}
		return l;
	}

	public void retrievePhoto(SearchDetailForm myForm) {
		// TODO Auto-generated method stub
		Photo myPhoto = myPhotoDao.getPhotoById((myForm.getFrmViewBook()
				.getPhotoId()));
		myForm.setFrmPhoto(myPhoto);

	}

}