package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.UserType;
import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.business.entity.ViewRentedHistory;

public class CheckOutForm extends ValidatorForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String frmCallNumber;
	private String frmReserveFlag;
	private String frmBookOnLoanFlag;
	private String frmUserFlag;
	private String frmUserInfoFlag;
	private Date IDate;

	public Date getIDate() {
		return IDate;
	}
	public void setIDate(Date iDate) {
		IDate = iDate;
	}
	public String getFrmUserInfoFlag() {
		return frmUserInfoFlag;
	}
	public void setFrmUserInfoFlag(String frmUserInfoFlag) {
		this.frmUserInfoFlag = frmUserInfoFlag;
	}
	public String getFrmUserFlag() {
		return frmUserFlag;
	}
	public void setFrmUserFlag(String frmUserFlag) {
		this.frmUserFlag = frmUserFlag;
	}
	public String getFrmBookOnLoanFlag() {
		return frmBookOnLoanFlag;
	}
	public void setFrmBookOnLoanFlag(String frmBookOnLoanFlag) {
		this.frmBookOnLoanFlag = frmBookOnLoanFlag;
	}
	private String frmLoginName;
	private String frmUserType;
	private String frmIsbn;
	private String frmAuthor;
	private String frmRegUserTypeId;
	private String frmCheckoutFormControl;
	private User frmUserInfo;
	private BookOnLoan frmBookOnLaonInfo;
	private String frmCheckoutMessage;
	private int frmCheckOutCallNo;
	
	public int getFrmCheckOutCallNo() {
		return frmCheckOutCallNo;
	}
	public void setFrmCheckOutCallNo(int frmCheckOutCallNo) {
		this.frmCheckOutCallNo = frmCheckOutCallNo;
	}
	public String getFrmCheckoutMessage() {
		return frmCheckoutMessage;
	}
	public void setFrmCheckoutMessage(String frmCheckoutMessage) {
		this.frmCheckoutMessage = frmCheckoutMessage;
	}
	public BookOnLoan getFrmBookOnLaonInfo() {
		return frmBookOnLaonInfo;
	}
	public void setFrmBookOnLaonInfo(BookOnLoan frmBookOnLaonInfo) {
		this.frmBookOnLaonInfo = frmBookOnLaonInfo;
	}
	public User getFrmUserInfo() {
		return frmUserInfo;
	}
	public void setFrmUserInfo(User frmUserInfo) {
		this.frmUserInfo = frmUserInfo;
	}
	public String getFrmCheckoutFormControl() {
		return frmCheckoutFormControl;
	}
	public void setFrmCheckoutFormControl(String frmCheckoutFormControl) {
		this.frmCheckoutFormControl = frmCheckoutFormControl;
	}
	private List<UserType> frmRegUserTypeList;
	private User myUser;
	private BookOnLoan myBookOnLoan;
	private String issue_date;
	private String due_date;
	private BookList myBookList;
	private BookReserve myBookReserve;
	private List<CallNumber> myCallNumber;
	
	public List<CallNumber> getMyCallNumber() {
		return myCallNumber;
	}
	public void setMyCallNumber(List<CallNumber> myCallNumber) {
		this.myCallNumber = myCallNumber;
	}
	public BookReserve getMyBookReserve() {
		return myBookReserve;
	}
	public void setMyBookReserve(BookReserve myBookReserve) {
		this.myBookReserve = myBookReserve;
	}
	public BookList getMyBookList() {
		return myBookList;
	}
	public void setMyBookList(BookList myBookList) {
		this.myBookList = myBookList;
	}
	public String getIssue_date() {
		return issue_date;
	}
	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}
	public String getDue_date() {
		return due_date;
	}
	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}
	public BookOnLoan getMyBookOnLoan()
	{
		return myBookOnLoan;
	}
	public void setMyBookOnLoan(BookOnLoan myBookOnLoan)
	{
		this.myBookOnLoan=myBookOnLoan;
	}
	public User getMyUser() {
		return myUser;
	}
	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}
	public String getFrmRegUserTypeId() {
		return frmRegUserTypeId;
	}
	public void setFrmRegUserTypeId(String frmRegUserTypeId) {
		this.frmRegUserTypeId = frmRegUserTypeId;
	}
	public List<UserType> getFrmRegUserTypeList() {
		return frmRegUserTypeList;
	}
	public void setFrmRegUserTypeList(List<UserType> frmRegUserTypeList) {
		this.frmRegUserTypeList = frmRegUserTypeList;
	}
	public String getFrmIsbn() {
		return frmIsbn;
	}
	public void setFrmIsbn(String frmIsbn) {
		this.frmIsbn = frmIsbn;
	}
	public String getFrmAuthor() {
		return frmAuthor;
	}
	public void setFrmAuthor(String frmAuthor) {
		this.frmAuthor = frmAuthor;
	}
	public String getFrmUserType() {
		return frmUserType;
	}
	public void setFrmUserType(String frmUserType) {
		this.frmUserType = frmUserType;
	}
	public String getFrmLoginName() {
		return frmLoginName;
	}
	public void setFrmLoginName(String frmLoginName) {
		this.frmLoginName = frmLoginName;
	}
	public String getFrmReserveFlag() {
		return frmReserveFlag;
	}
	public void setFrmReserveFlag(String frmReserveFlag) {
		this.frmReserveFlag = frmReserveFlag;
	}
	public String getFrmCallNumber() {
		return frmCallNumber;
	}
	public void setFrmCallNumber(String frmCallNumber) {
		this.frmCallNumber = frmCallNumber;
	}
	private String frmUserName;//checkin variable
	private String frmTitle;//checkin variable
	private Date dDate;//check in variable
	private Date rDate;//check in variable
	private int l_fees;//check in variable
	private ViewRentedHistory myViewRentedHistory;//check in variable
	public ViewRentedHistory getMyViewRentedHistory() {
		return myViewRentedHistory;
	}
	public void setMyViewRentedHistory(ViewRentedHistory myViewRentedHistory) {
		this.myViewRentedHistory = myViewRentedHistory;
	}
	public Date getdDate() {
		return dDate;
	}
	public void setdDate(Date dDate) {
		this.dDate = dDate;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public int getL_fees() {
		return l_fees;
	}
	public void setL_fees(int l_fees) {
		this.l_fees = l_fees;
	}
	public String getFrmTitle() {
		return frmTitle;
	}
	public void setFrmTitle(String frmTitle) {
		this.frmTitle = frmTitle;
	}
	public String getFrmUserName() {
		return frmUserName;
	}
	public void setFrmUserName(String frmUserName) {
		this.frmUserName = frmUserName;
	}
	private String frmUpdateFormControl;//for book update variable
	private List<ViewDetailBook> myViewDetailBook;//for book up
	private ViewDetailBook frmViewDetailBook;
	private int noOfcopies;
	public int getNoOfcopies() {
		return noOfcopies;
	}
	public void setNoOfcopies(int noOfcopies) {
		this.noOfcopies = noOfcopies;
	}
	public List<ViewDetailBook> getMyViewDetailBook() {
		return myViewDetailBook;
	}
	public void setMyViewDetailBook(List<ViewDetailBook> myViewDetailBook) {
		this.myViewDetailBook = myViewDetailBook;
	}
	public ViewDetailBook getFrmViewDetailBook() {
		return frmViewDetailBook;
	}
	public void setFrmViewDetailBook(ViewDetailBook frmViewDetailBook) {
		this.frmViewDetailBook = frmViewDetailBook;
	}
	public String getFrmUpdateFormControl() {
		return frmUpdateFormControl;
	}
	public void setFrmUpdateFormControl(String frmUpdateFormControl) {
		this.frmUpdateFormControl = frmUpdateFormControl;
	}
	private String[] selectedItem;
	public String[] getSelectedItem() {
		return selectedItem;
	}
	public void setSelectedItem(String[] selectedItem) {
		this.selectedItem = selectedItem;
	}
	private String frmCallNumberFlag;

	public String getFrmCallNumberFlag() {
		return frmCallNumberFlag;
	}
	public void setFrmCallNumberFlag(String frmCallNumberFlag) {
		this.frmCallNumberFlag = frmCallNumberFlag;
	}
	private String frmBookInfoFlag;

	public String getFrmBookInfoFlag() {
		return frmBookInfoFlag;
	}
	public void setFrmBookInfoFlag(String frmBookInfoFlag) {
		this.frmBookInfoFlag = frmBookInfoFlag;
	}
	private String frmCallNumberFlag2;

	public String getFrmCallNumberFlag2() {
		return frmCallNumberFlag2;
	}
	public void setFrmCallNumberFlag2(String frmCallNumberFlag2) {
		this.frmCallNumberFlag2 = frmCallNumberFlag2;
	}
}