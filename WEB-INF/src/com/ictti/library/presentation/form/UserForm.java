package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.validator.ValidatorForm;

import com.ictti.library.business.entity.BookOnLoan;
import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.UserType;
import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.business.entity.ViewRentedHistory;

public class UserForm extends ValidatorForm{
	private String frmLoginName;
	private String frmSearchBook;
	private String frmRegUserFlag;
	
	public String getFrmRegUserFlag() {
		return frmRegUserFlag;
	}
	public void setFrmRegUserFlag(String frmRegUserFlag) {
		this.frmRegUserFlag = frmRegUserFlag;
	}
	public String getFrmSearchBook() {
		return frmSearchBook;
	}
	public void setFrmSearchBook(String frmSearchBook) {
		this.frmSearchBook = frmSearchBook;
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
	public User getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}
	private String frmPassword;
	private User loginUser;
	private static final long serialVersionUID = 1L;
	private String frmRegLoginName;
	private String frmRegPassword;
	private String frmRegConfPassword;
	private  String frmRegGender;
	private String frmRegAccountNameError;
	public String getFrmRegAccountNameError() {
		return frmRegAccountNameError;
	}
	public void setFrmRegAccountNameError(String frmRegAccountNameError) {
		this.frmRegAccountNameError = frmRegAccountNameError;
	}
	public String getFrmRegGender() {
		return frmRegGender;
	}
	public void setFrmRegGender(String frmRegGender) {
		this.frmRegGender = frmRegGender;
	}
	private String frmRegEmail;
	private String frmRegUserTypeId;
	private List<UserType> frmRegUserTypeList;
	private String frmRegNRC;
	private String frmRegPhone;
	private String frmRegLoginNameError;
	private String frmRegAddress;
	private String frmRegFormControl;
	private String frmRegUserTypeName;
	private String frmRegDate;
	private String frmRegUserType;
	private String frmRegName;
	public String getFrmRegName() {
		return frmRegName;
	}

	public void setFrmRegName(String frmRegName) {
		this.frmRegName = frmRegName;
	}

	public String getFrmRegUserType() {
		return frmRegUserType;
	}

	public void setFrmRegUserType(String frmRegUserType) {
		this.frmRegUserType = frmRegUserType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFrmRegDate() {
		return frmRegDate;
	}

	public void setFrmRegDate(String frmRegDate) {
		this.frmRegDate = frmRegDate;
	}

	public String getFrmRegUserTypeName() {
		return frmRegUserTypeName;
	}

	public void setFrmRegUserTypeName(String frmRegUserTypeName) {
		this.frmRegUserTypeName = frmRegUserTypeName;
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

	public String getFrmRegLoginNameError() {
		return frmRegLoginNameError;
	}

	public void setFrmRegLoginNameError(String frmRegLoginNameError) {
		this.frmRegLoginNameError = frmRegLoginNameError;
	}

	public String getFrmRegLoginName() {
		return frmRegLoginName;
	}

	public void setFrmRegLoginName(String frmRegLoginName) {
		this.frmRegLoginName = frmRegLoginName;
	}

	public String getFrmRegPassword() {
		return frmRegPassword;
	}

	public void setFrmRegPassword(String frmRegPassword) {
		this.frmRegPassword = frmRegPassword;
	}

	public String getFrmRegConfPassword() {
		return frmRegConfPassword;
	}

	public void setFrmRegConfPassword(String frmRegConfPassword) {
		this.frmRegConfPassword = frmRegConfPassword;
	}

	
	public String getFrmRegEmail() {
		return frmRegEmail;
	}

	public void setFrmRegEmail(String frmRegEmail) {
		this.frmRegEmail = frmRegEmail;
	}

	public String getFrmRegNRC() {
		return frmRegNRC;
	}

	public void setFrmRegNRC(String frmRegNRC) {
		this.frmRegNRC = frmRegNRC;
	}

	public String getFrmRegPhone() {
		return frmRegPhone;
	}

	public void setFrmRegPhone(String frmRegPhone) {
		this.frmRegPhone = frmRegPhone;
	}

	public String getFrmRegAddress() {
		return frmRegAddress;
	}

	public void setFrmRegAddress(String frmRegAddress) {
		this.frmRegAddress = frmRegAddress;
	}

	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}

	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
	}
	private String frmDetailBookId;//aye2sann
	private List<ViewDetailBook> frmViewDetailBook;//aye2sann
	private ViewDetailBook myViewBookList;//aye2sann
	private String frmUserFlag;//aye2sann
	private int frmusr_id;//aye2sann
	private Date frmEndDate;//aye2sann
	private List<ViewRentedHistory> myViewRentedHistory;//aye2sann book's renew 
	private ViewRentedHistory frmViewRentedHistory;//aye2sann book's renew
	private BookReserve frmMyBookReserve;//aye2sann book's renew
	private Date frmRenewDate;//aye2sann book's renew
	private List<CallNumber> myCallNumber;//aye2sann
	//private String frmRegUserFlag; //aye2sann
	private String frmResFormControl;//aye2sann
	private List<BookOnLoan> myBookOnLoan;//aye2sann
	private Date a_Date;//aye2sann,to store available date in book_reserve table
	private Date i_Date;//aye2sann for book_renew
	private Date d_Date;//aye2sann for book_renew
	private String frmRenewFormControl;//aye2sann for book_renew
	private int callNo;//to store call number in book_resrve table
	private User reserveUser;//to store reserve user_id;
	private String frmViewPhoto;//aye2sann's photo variable;
	private String frmReserveError;//aye2sann's reserve's error;
	private String callNumberCode;
	public String getCallNumberCode() {
		return callNumberCode;
	}
	public void setCallNumberCode(String callNumberCode) {
		this.callNumberCode = callNumberCode;
	}
	public String getFrmReserveError() {
		return frmReserveError;
	}
	public void setFrmReserveError(String frmReserveError) {
		this.frmReserveError = frmReserveError;
	}
	public String getFrmViewPhoto() {
		return frmViewPhoto;
	}
	public void setFrmViewPhoto(String frmViewPhoto) {
		this.frmViewPhoto = frmViewPhoto;
	}
	public String getFrmDetailBookId() {
		return frmDetailBookId;
	}
	public void setFrmDetailBookId(String frmDetailBookId) {
		this.frmDetailBookId = frmDetailBookId;
	}
	public List<ViewDetailBook> getFrmViewDetailBook() {
		return frmViewDetailBook;
	}
	public void setFrmViewDetailBook(List<ViewDetailBook> frmViewDetailBook) {
		this.frmViewDetailBook = frmViewDetailBook;
	}
	public ViewDetailBook getMyViewBookList() {
		return myViewBookList;
	}
	public void setMyViewBookList(ViewDetailBook myViewBookList) {
		this.myViewBookList = myViewBookList;
	}
	public String getFrmUserFlag() {
		return frmUserFlag;
	}
	public void setFrmUserFlag(String frmUserFlag) {
		this.frmUserFlag = frmUserFlag;
	}
	public int getFrmusr_id() {
		return frmusr_id;
	}
	public void setFrmusr_id(int frmusr_id) {
		this.frmusr_id = frmusr_id;
	}
	public Date getFrmEndDate() {
		return frmEndDate;
	}
	public void setFrmEndDate(Date frmEndDate) {
		this.frmEndDate = frmEndDate;
	}
	public List<ViewRentedHistory> getMyViewRentedHistory() {
		return myViewRentedHistory;
	}
	public void setMyViewRentedHistory(List<ViewRentedHistory> myViewRentedHistory) {
		this.myViewRentedHistory = myViewRentedHistory;
	}
	public ViewRentedHistory getFrmViewRentedHistory() {
		return frmViewRentedHistory;
	}
	public void setFrmViewRentedHistory(ViewRentedHistory frmViewRentedHistory) {
		this.frmViewRentedHistory = frmViewRentedHistory;
	}
	public BookReserve getFrmMyBookReserve() {
		return frmMyBookReserve;
	}
	public void setFrmMyBookReserve(BookReserve frmMyBookReserve) {
		this.frmMyBookReserve = frmMyBookReserve;
	}
	public Date getFrmRenewDate() {
		return frmRenewDate;
	}
	public void setFrmRenewDate(Date frmRenewDate) {
		this.frmRenewDate = frmRenewDate;
	}
	public List<CallNumber> getMyCallNumber() {
		return myCallNumber;
	}
	public void setMyCallNumber(List<CallNumber> myCallNumber) {
		this.myCallNumber = myCallNumber;
	}
	public String getFrmResFormControl() {
		return frmResFormControl;
	}
	public void setFrmResFormControl(String frmResFormControl) {
		this.frmResFormControl = frmResFormControl;
	}
	public List<BookOnLoan> getMyBookOnLoan() {
		return myBookOnLoan;
	}
	public void setMyBookOnLoan(List<BookOnLoan> myBookOnLoan) {
		this.myBookOnLoan = myBookOnLoan;
	}
	public Date getA_Date() {
		return a_Date;
	}
	public void setA_Date(Date a_Date) {
		this.a_Date = a_Date;
	}
	public Date getI_Date() {
		return i_Date;
	}
	public void setI_Date(Date i_Date) {
		this.i_Date = i_Date;
	}
	public Date getD_Date() {
		return d_Date;
	}
	public void setD_Date(Date d_Date) {
		this.d_Date = d_Date;
	}
	public String getFrmRenewFormControl() {
		return frmRenewFormControl;
	}
	public void setFrmRenewFormControl(String frmRenewFormControl) {
		this.frmRenewFormControl = frmRenewFormControl;
	}
	public int getCallNo() {
		return callNo;
	}
	public void setCallNo(int callNo) {
		this.callNo = callNo;
	}
	public User getReserveUser() {
		return reserveUser;
	}
	public void setReserveUser(User reserveUser) {
		this.reserveUser = reserveUser;
	}
	private int finalPage;
	// scroll function;actual page
	private int actualPage;
	// scroll function;max data to show in the list
	private int iMaxShow = 1;
	// scroll function; max data that is retrieved from the list
	private int iMaxData;
	// scroll function; next button
	private boolean nextBtn;
	// scroll function; prev button
	private boolean prevBtn;

	
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
	public void setFinalPageCalc(int iListSize){
	       finalPage=iListSize / iMaxShow;
	}
	
	public void setPrevBtn(boolean prevBtn) {
		this.prevBtn = prevBtn;
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

	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

	public int getActualPage() {
		return actualPage;
	}

	public void setActualPage(int actualPage) {
		this.actualPage = actualPage;
	}

	public int getIMaxShow() {
		return iMaxShow;
	}

	public void setIMaxShow(int maxShow) {
		iMaxShow = maxShow;
	}

	public int getIMaxData() {
		return iMaxData;
	}
	public void setIMaxData(int maxData) {
	       iMaxData = maxData;
	}
	private String frmCallNumberFlag;
	public String getFrmCallNumberFlag() {
		return frmCallNumberFlag;
	}
	public void setFrmCallNumberFlag(String frmCallNumberFlag) {
		this.frmCallNumberFlag = frmCallNumberFlag;
	}
	private String frmRenewFlag;

	public String getFrmRenewFlag() {
		return frmRenewFlag;
	}
	public void setFrmRenewFlag(String frmRenewFlag) {
		this.frmRenewFlag = frmRenewFlag;
	}
	private String frmOverRenewFlag;

	public String getFrmOverRenewFlag() {
		return frmOverRenewFlag;
	}
	public void setFrmOverRenewFlag(String frmOverRenewFlag) {
		this.frmOverRenewFlag = frmOverRenewFlag;
	}
	private String frmViewRentFlag;

	public String getFrmViewRentFlag() {
		return frmViewRentFlag;
	}
	public void setFrmViewRentFlag(String frmViewRentFlag) {
		this.frmViewRentFlag = frmViewRentFlag;
	}
	private String frmOverDueFlag;

	public String getFrmOverDueFlag() {
		return frmOverDueFlag;
	}
	public void setFrmOverDueFlag(String frmOverDueFlag) {
		this.frmOverDueFlag = frmOverDueFlag;
	}
	private String frmreserveFlag;

	public String getFrmreserveFlag() {
		return frmreserveFlag;
	}
	public void setFrmreserveFlag(String frmreserveFlag) {
		this.frmreserveFlag = frmreserveFlag;
	}
}
