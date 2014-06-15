package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.ViewMostRentBook;

public class AdminViewBookForm extends ActionForm {
	private int id;
	private String isbn;
	private String title;
	private int callNUmberId;
	private int categoryId;
	private String categoryName;
	private String subCategoryName;
	private String authorName;
	private Date pubDate;
	private Date registerDate;
	private String publisherName;
	private int rentTimes;
	private String frmCategoryId;

	public String getFrmCategoryId() {
		return frmCategoryId;
	}

	public void setFrmCategoryId(String frmCategoryId) {
		this.frmCategoryId = frmCategoryId;
	}

	public List<ViewMostRentBook> getFrmViewRentBookList() {
		return frmViewRentBookList;
	}

	private List<Category> frmCategoryList;

	public List<Category> getFrmCategoryList() {
		return frmCategoryList;
	}

	public void setFrmCategoryList(List<Category> frmCategoryList) {
		this.frmCategoryList = frmCategoryList;
	}

	private List<ViewMostRentBook> frmViewRentBookList;

	public void setFrmViewRentBookList(
			List<ViewMostRentBook> frmViewRentBookList) {
		this.frmViewRentBookList = frmViewRentBookList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCallNUmberId() {
		return callNUmberId;
	}

	public void setCallNUmberId(int callNUmberId) {
		this.callNUmberId = callNUmberId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public int getRentTimes() {
		return rentTimes;
	}

	public void setRentTimes(int rentTimes) {
		this.rentTimes = rentTimes;
	}

	private int actualPage;
	private int iMaxShow = 1;
	private int iMaxData;
	private int finalPage;
	private boolean nextBtn;
	private boolean prevBtn;

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public int getiMaxShow() {
		return iMaxShow;
	}

	public void setiMaxShow(int iMaxShow) {
		this.iMaxShow = iMaxShow;
	}

	public int getiMaxData() {
		return iMaxData;
	}

	public void setiMaxData(int iMaxData) {
		this.iMaxData = iMaxData;
	}

	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

	public boolean isNextBtn() {
		if (getActualPage() == getFinalPage()) {
			nextBtn = false;
		} else {
			nextBtn = true;
		}
		return nextBtn;
	}

	public void setNextBtn(boolean nextBtn) {
		this.nextBtn = nextBtn;
	}

	public boolean isPrevBtn() {
		if (getActualPage() == 1) {
			prevBtn = false;
		} else {
			prevBtn = true;
		}
		return prevBtn;
	}

	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
	}

	public void setFinalPageCalc(int iListSize) {
		finalPage = iListSize / iMaxShow;
	}
	public String getEnd() {
		int iEnd = actualPage * iMaxShow;
		if (iEnd > iMaxData) {
			iEnd = iMaxData;
		}
		return Integer.valueOf(iEnd).toString();
	}
	public String getBegin() {
		int iBegin = (actualPage - 1) * iMaxShow + 1;
		return Integer.valueOf(iBegin).toString();
	}
}
