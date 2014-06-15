package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.library.business.entity.ViewReserveBook;

public class ViewReserveBookForm extends ActionForm {
	private Integer viewId;
	private Integer bookReserveId;
	private Integer userId;
	private String userName;
	private String title;
	private Integer userType;
	private String isbn;
	private String authorName;
	private Integer callNumberId;
	private String callNumberCode;
	private Integer reserveStatus;
	private Integer callStatus;

	public Integer getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(Integer reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	public Integer getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(Integer callStatus) {
		this.callStatus = callStatus;
	}

	private Date dueDate;
	private Date reserveDate;
	private List<ViewReserveBook> frmViewBookReserveList;
	private List<ViewReserveBook> frmCancelReserveList;
	private String[] frmCancelReserveId;

	public void setFrmCancelReserveId(String[] frmCancelReserveId) {
		this.frmCancelReserveId = frmCancelReserveId;
	}

	private String frmCancelCallId;

	public String getFrmCancelCallId() {
		return frmCancelCallId;
	}

	public void setFrmCancelCallId(String frmCancelCallId) {
		this.frmCancelCallId = frmCancelCallId;
	}

	private String frmControl;

	private int actualPage;
	private int iMaxShow = 1;
	private int iMaxData;
	private int finalPage;
	private boolean nextBtn;
	private boolean prevBtn;

	public int getBegin() {
		int iBegin = (actualPage - 1) * iMaxShow + 1;
		return Integer.valueOf(iBegin);
	}

	public void setBegin(int begin) {
	}

	public int getEnd() {
		int iEnd = actualPage * iMaxShow;
		if (iEnd > iMaxData)
			iEnd = iMaxData;
		return Integer.valueOf(iEnd);
	}

	public void setEnd(int end) {
	}

	public Integer getViewId() {
		return viewId;
	}

	public void setViewId(Integer viewId) {
		this.viewId = viewId;
	}

	public Integer getBookReserveId() {
		return bookReserveId;
	}

	public void setBookReserveId(Integer bookReserveId) {
		this.bookReserveId = bookReserveId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getCallNumberId() {
		return callNumberId;
	}

	public void setCallNumberId(Integer callNumberId) {
		this.callNumberId = callNumberId;
	}

	public String getCallNumberCode() {
		return callNumberCode;
	}

	public void setCallNumberCode(String callNumberCode) {
		this.callNumberCode = callNumberCode;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<ViewReserveBook> getFrmCancelReserveList() {
		return frmCancelReserveList;
	}

	public void setFrmCancelReserveList(
			List<ViewReserveBook> frmCancelReserveList) {
		this.frmCancelReserveList = frmCancelReserveList;
	}

	public List<ViewReserveBook> getFrmViewBookReserveList() {
		return frmViewBookReserveList;
	}

	public void setFrmViewBookReserveList(
			List<ViewReserveBook> frmViewBookReserveList) {
		this.frmViewBookReserveList = frmViewBookReserveList;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public String[] getFrmCancelReserveId() {
		return frmCancelReserveId;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

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

	public void setFinalPageCalc(int iListSize) {
		finalPage = iListSize / iMaxShow;
	}

	public int getFinalPage() {
		finalPage = (int) Math.ceil((double) iMaxData / iMaxShow);
		return finalPage;
	}

	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}

}
