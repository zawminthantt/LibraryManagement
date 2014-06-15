package com.ictti.library.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.validator.ValidatorForm;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Photo;

public class AmazonBeanForm extends ActionForm {
	private String baseURL;
	private String frmIsbn10;
	private String frmIsbn13;
	private String frmTitle;

	private String frmManufacturer;
	private String frmPublicationDate;
	private String frmSearchIsbn;
	private String frmNoOfPages;
	private int frmPrice;
	private String frmSize;
	private String frmFormControl;
	private String frmErrorMsg;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getFrmIsbn10() {
		return frmIsbn10;
	}

	public void setFrmIsbn10(String frmIsbn10) {
		this.frmIsbn10 = frmIsbn10;
	}

	public String getFrmIsbn13() {
		return frmIsbn13;
	}

	public void setFrmIsbn13(String frmIsbn13) {
		this.frmIsbn13 = frmIsbn13;
	}

	public String getFrmTitle() {
		return frmTitle;
	}

	public void setFrmTitle(String frmTitle) {
		this.frmTitle = frmTitle;
	}

	public String getFrmManufacturer() {
		return frmManufacturer;
	}

	public void setFrmManufacturer(String frmManufacturer) {
		this.frmManufacturer = frmManufacturer;
	}

	public String getFrmPublicationDate() {
		return frmPublicationDate;
	}

	public void setFrmPublicationDate(String frmPublicationDate) {
		this.frmPublicationDate = frmPublicationDate;
	}

	public String getFrmSearchIsbn() {
		return frmSearchIsbn;
	}

	public void setFrmSearchIsbn(String frmSearchIsbn) {
		this.frmSearchIsbn = frmSearchIsbn;
	}

	public String getFrmNoOfPages() {
		return frmNoOfPages;
	}

	public void setFrmNoOfPages(String frmNoOfPages) {
		this.frmNoOfPages = frmNoOfPages;
	}

	public int getFrmPrice() {
		return frmPrice;
	}

	public void setFrmPrice(int frmPrice) {
		this.frmPrice = frmPrice;
	}

	public String getFrmSize() {
		return frmSize;
	}

	public void setFrmSize(String frmSize) {
		this.frmSize = frmSize;
	}

	public String getFrmPhotoPath() {
		return frmPhotoPath;
	}

	public void setFrmPhotoPath(String frmPhotoPath) {
		this.frmPhotoPath = frmPhotoPath;
	}

	public String getFrmFormControl() {
		return frmFormControl;
	}

	public void setFrmFormControl(String frmFormControl) {
		this.frmFormControl = frmFormControl;
	}

	public String getFrmErrorMsg() {
		return frmErrorMsg;
	}

	public void setFrmErrorMsg(String frmErrorMsg) {
		this.frmErrorMsg = frmErrorMsg;
	}

	// For register of amazon
	private String frmRegISBN;
	private String frmRegTitle;
	private String frmRegAuthor1;

	public String getFrmRegAuthor1() {
		return frmRegAuthor1;
	}

	public void setFrmRegAuthor1(String frmRegAuthor1) {
		this.frmRegAuthor1 = frmRegAuthor1;
	}

	private String frmRegPublisher;
	private String frmRegDate;
	/*
	 * private int frmRegPrice;
	 * 
	 * public int getFrmRegPrice() { return frmRegPrice; } public void
	 * setFrmRegPrice(int frmRegPrice) { this.frmRegPrice = frmRegPrice; }
	 */
	private String frmRegPrice;

	public String getFrmRegPrice() {
		return frmRegPrice;
	}

	public void setFrmRegPrice(String frmRegPrice) {
		this.frmRegPrice = frmRegPrice;
	}

	private String frmRegEdition;
	// For Category
	private List<LabelValueBean> categoryChoice;
	private String subcatOption;

	private String categoryId;
	private int subcategoryId;
	private String subCategoryId;// for check;
	private String subcategory;
	private String category;
	private int categoryID;
	private String categoryName;
	private String subcategoryName;
	private int frmRegCopy;
	private String frmRegPage;

	public String getFrmRegPage() {
		return frmRegPage;
	}

	public void setFrmRegPage(String frmRegPage) {
		this.frmRegPage = frmRegPage;
	}

	private String setFrmRegPrice;

	public String getSetFrmRegPrice() {
		return setFrmRegPrice;
	}

	public void setSetFrmRegPrice(String setFrmRegPrice) {
		this.setFrmRegPrice = setFrmRegPrice;
	}

	// For photo
	private FormFile frmUploadFile;
	private String frmPhotoPath;
	private String frmFileId;
	private Photo frmFile;
	private String frmFileType;
	private List<Photo> frmFileList;
	private String frmRegRemark;
	private BookList booklist;

	public BookList getBooklist() {
		return booklist;
	}

	public void setBooklist(BookList booklist) {
		this.booklist = booklist;
	}

	public String getFrmRegRemark() {
		return frmRegRemark;
	}

	public void setFrmRegRemark(String frmRegRemark) {
		this.frmRegRemark = frmRegRemark;
	}

	public String getFrmFileId() {
		return frmFileId;
	}

	public void setFrmFileId(String frmFileId) {
		this.frmFileId = frmFileId;
	}

	public Photo getFrmFile() {
		return frmFile;
	}

	public void setFrmFile(Photo frmFile) {
		this.frmFile = frmFile;
	}

	public String getFrmFileType() {
		return frmFileType;
	}

	public void setFrmFileType(String frmFileType) {
		this.frmFileType = frmFileType;
	}

	public List<Photo> getFrmFileList() {
		return frmFileList;
	}

	public void setFrmFileList(List<Photo> frmFileList) {
		this.frmFileList = frmFileList;
	}

	public String getFrmRegISBN() {
		return frmRegISBN;
	}

	public void setFrmRegISBN(String frmRegISBN) {
		this.frmRegISBN = frmRegISBN;
	}

	public String getFrmRegTitle() {
		return frmRegTitle;
	}

	public void setFrmRegTitle(String frmRegTitle) {
		this.frmRegTitle = frmRegTitle;
	}

	public String getFrmRegPublisher() {
		return frmRegPublisher;
	}

	public void setFrmRegPublisher(String frmRegPublisher) {
		this.frmRegPublisher = frmRegPublisher;
	}

	public String getFrmRegDate() {
		return frmRegDate;
	}

	public void setFrmRegDate(String frmRegDate) {
		this.frmRegDate = frmRegDate;
	}

	public String getFrmRegEdition() {
		return frmRegEdition;
	}

	public void setFrmRegEdition(String frmRegEdition) {
		this.frmRegEdition = frmRegEdition;
	}

	public List<LabelValueBean> getCategoryChoice() {
		return categoryChoice;
	}

	public void setCategoryChoice(List<LabelValueBean> categoryChoice) {
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

	public int getSubcategoryId() {
		return subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCategoryID() {
		return categoryID;
	}

	public FormFile getFrmUploadFile() {
		return frmUploadFile;
	}

	public void setFrmUploadFile(FormFile frmUploadFile) {
		this.frmUploadFile = frmUploadFile;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubcategoryName() {
		return subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public int getFrmRegCopy() {
		return frmRegCopy;
	}

	public void setFrmRegCopy(int frmRegCopy) {
		this.frmRegCopy = frmRegCopy;
	}

}