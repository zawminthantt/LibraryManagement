package com.ictti.library.presentation.form;

import java.util.List;

import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.apache.struts.validator.ValidatorForm;


import com.ictti.library.business.entity.Admin;
import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.entity.Photo;
import com.ictti.library.business.entity.Publisher;

public class AdminForm extends ValidatorForm{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//for Admin login
	private String frmLoginName;
	private String frmPassword;
	private Admin loginAdmin;
	
	//for Book register
	private String frmRegTitle;
	private String frmRegISBN;
	//For author name
	private String frmRegAuthor1;
	private String frmRegAuthor2;
	private String frmRegAuthor3;
	
	//For author initial
	private String aut1_init;
	private String aut2_init;
	private String aut3_init;
	private BookList booklist;
	
	
	public BookList getBooklist() {
		return booklist;
	}
	public void setBooklist(BookList booklist) {
		this.booklist = booklist;
	}
	public String getAut1_init() {
		return aut1_init;
	}
	public void setAut1_init(String aut1_init) {
		this.aut1_init = aut1_init;
	}
	public String getAut2_init() {
		return aut2_init;
	}
	public void setAut2_init(String aut2_init) {
		this.aut2_init = aut2_init;
	}
	public String getAut3_init() {
		return aut3_init;
	}
	public void setAut3_init(String aut3_init) {
		this.aut3_init = aut3_init;
	}
	private String frmRegEdition;
	private String frmRegPublisher;
	//private Date frmRegDate;
	private String frmRegDate;
	 private int frmRegPage;
	 public String getFrmRegTitle() {
		return frmRegTitle;
	}
	public void setFrmRegTitle(String frmRegTitle) {
		this.frmRegTitle = frmRegTitle;
	}
	public String getFrmRegISBN() {
		return frmRegISBN;
	}
	public void setFrmRegISBN(String frmRegISBN) {
		this.frmRegISBN = frmRegISBN;
	}
	
	public String getFrmRegAuthor1() {
		return frmRegAuthor1;
	}
	public void setFrmRegAuthor1(String frmRegAuthor1) {
		this.frmRegAuthor1 = frmRegAuthor1;
	}
	public String getFrmRegAuthor2() {
		return frmRegAuthor2;
	}
	public void setFrmRegAuthor2(String frmRegAuthor2) {
		this.frmRegAuthor2 = frmRegAuthor2;
	}
	public String getFrmRegAuthor3() {
		return frmRegAuthor3;
	}
	public void setFrmRegAuthor3(String frmRegAuthor3) {
		this.frmRegAuthor3 = frmRegAuthor3;
	}
	public String getFrmRegEdition() {
		return frmRegEdition;
	}
	public void setFrmRegEdition(String frmRegEdition) {
		this.frmRegEdition = frmRegEdition;
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
	public int getFrmRegPage() {
		return frmRegPage;
	}

	public int getFrmRegCopy() {
		return frmRegCopy;
	}
	public void setFrmRegCopy(int frmRegCopy) {
		this.frmRegCopy = frmRegCopy;
	}
	public int getFrmRegPrice() {
		return frmRegPrice;
	}
	
	public String getFrmRegResource() {
		return frmRegResource;
	}
	public void setFrmRegResource(String frmRegResource) {
		this.frmRegResource = frmRegResource;
	}
	public String getFrmRegRemark() {
		return frmRegRemark;
	}
	public void setFrmRegRemark(String frmRegRemark) {
		this.frmRegRemark = frmRegRemark;
	}
	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}
	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	private int frmRegCopy;
	 private int frmRegPrice;
	 private String frmRegResource;
	 private String frmRegRemark;
	 private String  frmRegFormControl;
	
	public void setFrmRegPage(int frmRegPage) {
		this.frmRegPage = frmRegPage;
	}
	public void setFrmRegPrice(int frmRegPrice) {
		this.frmRegPrice = frmRegPrice;
	}
	
	public String getFrmLoginName() {
		return frmLoginName;
	}
	public void setFrmLoginName(String frmLoginName) {
		this.frmLoginName = frmLoginName;
	}
	
	
	public String getFrmPassword() {
		return frmPassword;
	}
	public void setFrmPassword(String frmPassword) {
		this.frmPassword = frmPassword;
	}
	public Admin getLoginAdmin() {
		return loginAdmin;
	}
	public void setLoginAdmin(Admin loginAdmin) {
		this.loginAdmin = loginAdmin;
	}
	
	//For Book Registration
	private List<LabelValueBean> categoryChoice;
	private String subcatOption;
	private String categoryId;
	private int subcategoryId;
	private String subCategoryId;//for check;
	
	public String getSubCategoryId() {
		return subCategoryId;
	}
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}
	//Publisher for Option Collection For Book Registration
	private List<Publisher> publisherChoice;
	private Publisher publisher;
	private String publisherName;
	private String publisherId;//zmy
	
	
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public List<Publisher> getPublisherChoice() {
		return publisherChoice;
	}
	public void setPublisherChoice(List<Publisher> publisherChoice) {
		this.publisherChoice = publisherChoice;
	}
	public int getSubcategoryId() {
		return subcategoryId;
	}
	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}
	private String subcategory;
	private String category;
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	
	//zmy
	private int categoryID;
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	//For Photo
	private List<Photo> frmPhotoList;// photo variable;
	private int begin;// photo variable;
	private int end;//photo variable;
	private String frmPhotoId; //photo variable;
	private FormFile frmPhoto;// photo
	private String frmViewPhoto;// photo variable;
	private String frmPhotoType; // photo variable;
	private FormFile frmUploadPhoto; // photo variable;***
	private String filePath;
	private String frmPhotoPath;
	
	public String getFrmPhotoPath() {
		return frmPhotoPath;
	}
	public void setFrmPhotoPath(String frmPhotoPath) {
		this.frmPhotoPath = frmPhotoPath;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public List<Photo> getFrmPhotoList() {
		return frmPhotoList;
	}
	public void setFrmPhotoList(List<Photo> frmPhotoList) {
		this.frmPhotoList = frmPhotoList;
	}
	public int getBegin() {
		return begin;
	}
	public void setBegin(int begin) {
		this.begin = begin;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public String getFrmPhotoId() {
		return frmPhotoId;
	}
	public void setFrmPhotoId(String frmPhotoId) {
		this.frmPhotoId = frmPhotoId;
	}
	public FormFile getFrmPhoto() {
		return frmPhoto;
	}
	public void setFrmPhoto(FormFile frmPhoto) {
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
	

	public FormFile getFrmUploadPhoto() {
		return frmUploadPhoto;
	}
	public void setFrmUploadPhoto(FormFile frmUploadPhoto) {
		this.frmUploadPhoto = frmUploadPhoto;
	}
	
	//for organization
	private String frmOrgName;

	public String getFrmOrgName() {
		return frmOrgName;
	}
	public void setFrmOrgName(String frmOrgName) {
		this.frmOrgName = frmOrgName;
	}
	//For publisher
	private int frmPublisherId;

	public int getFrmPublisherId() {
		return frmPublisherId;
	}
	public void setFrmPublisherId(int frmPublisherId) {
		this.frmPublisherId = frmPublisherId;
	}
	
	//for accession code
	private String frmAccessionCode;

	public String getFrmAccessionCode() {
		return frmAccessionCode;
	}
	public void setFrmAccessionCode(String frmAccessionCode) {
		this.frmAccessionCode = frmAccessionCode;
	}
	//for accession number
	private int frmAccessionNo;

	public int getFrmAccessionNo() {
		return frmAccessionNo;
	}
	public void setFrmAccessionNo(int frmAccessionNo) {
		this.frmAccessionNo = frmAccessionNo;
	}

	//for category and subcategory name
	private String categoryName;
	private String subcategoryName;

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
	//for new publisher
	private String frmPubAddress;

	public String getFrmPubAddress() {
		return frmPubAddress;
	}
	public void setFrmPubAddress(String frmPubAddress) {
		this.frmPubAddress = frmPubAddress;
	}
	//For Category and Subcategory test
	  private String frmControl;


	public String getFrmControl() {
		return frmControl;
	}
	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}
	
}
