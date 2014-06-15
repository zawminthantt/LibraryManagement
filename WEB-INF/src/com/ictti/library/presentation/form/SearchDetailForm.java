package com.ictti.library.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.ValidatorForm;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.Photo;
import com.ictti.library.business.entity.SubCategory;
import com.ictti.library.business.entity.ViewSearchBook;

import com.ictti.library.business.entity.ViewDetailBook;

public class SearchDetailForm extends ValidatorForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ViewSearchBook> frmBookList;
	public List<ViewSearchBook> getFrmBookList() {
		return frmBookList;
	}

	public void setFrmBookList(List<ViewSearchBook> frmBookList) {
		this.frmBookList = frmBookList;
	}

	private List<Photo> frmPhotoList;// photo variable;
	private int begin;// photo variable;
	private int end;// photo variable;
	private String frmPhotoId; // photo variable;
	private Photo frmPhoto;// photo variable;
	private String frmViewPhoto;// photo variable;
	private String frmPhotoType; // photo variable;
	private FormFile frmUploadFile; // photo variable;
	private int categoryID;

	public int getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public List<Photo> getFrmPhotoList() {
		return frmPhotoList;
	}

	public void setFrmPhotoList(List<Photo> frmPhotoList) {
		this.frmPhotoList = frmPhotoList;
	}

	public String getFrmPhotoId() {
		return frmPhotoId;
	}

	public void setFrmPhotoId(String frmPhotoId) {
		this.frmPhotoId = frmPhotoId;
	}

	public Photo getFrmPhoto() {
		return frmPhoto;
	}

	public void setFrmPhoto(Photo frmPhoto) {
		this.frmPhoto = frmPhoto;
	}

	public String getFrmViewPhoto() {
		return frmViewPhoto;
	}

	public void setFrmViewPhoto(String frmViewPhoto) {
		this.frmViewPhoto = frmViewPhoto;
	}

	public String getFrmPhotoType() {
		return frmPhotoType;
	}

	public void setFrmPhotoType(String frmPhotoType) {
		this.frmPhotoType = frmPhotoType;
	}

	public FormFile getFrmUploadFile() {
		return frmUploadFile;
	}

	public void setFrmUploadFile(FormFile frmUploadFile) {
		this.frmUploadFile = frmUploadFile;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private String frmPhotoName;

	public String getFrmPhotoName() {
		return frmPhotoName;
	}

	public void setFrmPhotoName(String frmPhotoName) {
		this.frmPhotoName = frmPhotoName;
	}

	

	public ViewDetailBook getTitleAuthor;

	public ViewDetailBook getGetTitleAuthor() {
		return getTitleAuthor;
	}

	public void setGetTitleAuthor(ViewDetailBook getTitleAuthor) {
		this.getTitleAuthor = getTitleAuthor;
	}

	private String frmAuthorName;
	private String frmBookTitle;
	private List<Category> categoryChoice;
	private String subcatOption;
	private String categoryId;
	private String subcategoryId;
	private List<BookList> frmBooksList;
	private String frmDetailFlag;// aye2sann

	public String getFrmDetailFlag() {
		return frmDetailFlag;
	}

	public void setFrmDetailFlag(String frmDetailFlag) {
		this.frmDetailFlag = frmDetailFlag;
	}

	private String searchError;

	public String getSearchError() {
		return searchError;
	}

	public void setSearchError(String searchError) {
		this.searchError = searchError;
	}

	public List<BookList> getFrmBooksList() {
		return frmBooksList;
	}

	public void setFrmBooksList(List<BookList> frmBooksList) {
		this.frmBooksList = frmBooksList;
	}

	private BookList frmBooksDetail;
	private String frmDetailBookId;
	private String frmControl;
	private String frmViewBookDetail;
	private ViewSearchBook frmViewBook;
	public ViewSearchBook getFrmViewBook() {
		return frmViewBook;
	}

	public void setFrmViewBook(ViewSearchBook frmViewBook) {
		this.frmViewBook = frmViewBook;
	}

	private String frmDetailBookByCallNumber;// 22Night
	private String frmRegCallnumber;

	public String getFrmRegCallnumber() {
		return frmRegCallnumber;
	}

	public void setFrmRegCallnumber(String frmRegCallnumber) {
		this.frmRegCallnumber = frmRegCallnumber;
	}

	public String getFrmDetailBookByCallNumber() {
		return frmDetailBookByCallNumber;
	}

	public void setFrmDetailBookByCallNumber(String frmDetailBookByCallNumber) {
		this.frmDetailBookByCallNumber = frmDetailBookByCallNumber;
	}

	public String getFrmViewBookDetail() {
		return frmViewBookDetail;
	}

	

	public void setFrmViewBookDetail(String frmViewBookDetail) {
		this.frmViewBookDetail = frmViewBookDetail;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

	public BookList getFrmBooksDetail() {
		return frmBooksDetail;
	}

	public void setFrmBooksDetail(BookList frmBooksDetail) {
		this.frmBooksDetail = frmBooksDetail;
	}

	public String getFrmDetailBookId() {
		return frmDetailBookId;
	}

	public void setFrmDetailBookId(String frmDetailBookId) {
		this.frmDetailBookId = frmDetailBookId;
	}

	public List<Category> getCategoryChoice() {
		return categoryChoice;
	}

	public void setCategoryChoice(List<Category> categoryChoice) {
		this.categoryChoice = categoryChoice;
	}

	public String getSubcatOption() {
		return subcatOption;
	}

	public void setSubcatOption(String subcatOption) {
		this.subcatOption = subcatOption;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(String subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getFrmBookTitle() {
		return frmBookTitle;
	}

	public void setFrmBookTitle(String frmBookTitle) {
		this.frmBookTitle = frmBookTitle;
	}

	public String getFrmAuthorName() {
		return frmAuthorName;
	}

	public void setFrmAuthorName(String frmAuthorName) {
		this.frmAuthorName = frmAuthorName;
	}

	private int actualPage;

	// scroll function;max data to show in the list
	private int iMaxShow = 1;

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

	// scroll function; max data that is retrieved from the list
	private int iMaxData;
	// scroll function;final page
	private int finalPage;
	// scroll function; next button
	private boolean nextBtn;

	// scroll function; prev button
	private boolean prevBtn;

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
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

	public String getBegin() {
		int iBegin = (actualPage - 1) * iMaxShow + 1;
		return Integer.valueOf(iBegin).toString();
	}

	public String getEnd() {
		int iEnd = actualPage * iMaxShow;
		if (iEnd > iMaxData) {
			iEnd = iMaxData;
		}
		return Integer.valueOf(iEnd).toString();
	}

	/*
	 * public void setFinalPageCalc(int iListSize){ finalPage=iListSize /
	 * iMaxShow; }
	 */
	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	//For check subcategory
	private List<SubCategory> subcategory;
	private String subcategoryName;
	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public List<SubCategory> getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(List<SubCategory> subcategory) {
		this.subcategory = subcategory;
	}
   

}
