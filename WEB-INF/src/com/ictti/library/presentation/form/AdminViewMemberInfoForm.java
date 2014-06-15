package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.library.business.entity.UserType;
import com.ictti.library.business.entity.ViewMemberInfo;

public class AdminViewMemberInfoForm extends ActionForm {

	private Integer id;
	private Integer userTypeId;
	private String frmUserTypeId;
	private int actualPage;
	private int iMaxShow = 1;
	private int iMaxData;
	private int finalPage;
	private boolean nextBtn;
	private boolean prevBtn;
	private String frmControl;
	private String userTypeName;
	private String userEmail;
	private String userStatus;
	private Date expireDate;
	private String userAddress;
	private String phoneNumber;
	private int frmDeleteId;
	private String[] selectedItem;

	public String[] getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String[] selectedItem) {
		this.selectedItem = selectedItem;
	}

	public String getFrmControl() {
		return frmControl;
	}

	public void setFrmControl(String frmControl) {
		this.frmControl = frmControl;
	}

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

	public String getFrmUserTypeId() {
		return frmUserTypeId;
	}

	public void setFrmUserTypeId(String frmUserTypeId) {
		this.frmUserTypeId = frmUserTypeId;
	}

	private String frmUserTypeName;
	private List<ViewMemberInfo> frmViewMemberList;
	private List<ViewMemberInfo> frmViewRentMemberList;

	public List<ViewMemberInfo> getFrmViewRentMemberList() {
		return frmViewRentMemberList;
	}

	public void setFrmViewRentMemberList(
			List<ViewMemberInfo> frmViewRentMemberList) {
		this.frmViewRentMemberList = frmViewRentMemberList;
	}

	public List<ViewMemberInfo> getFrmViewMemberList() {
		return frmViewMemberList;
	}

	public void setFrmViewMemberList(List<ViewMemberInfo> frmViewMemberList) {
		this.frmViewMemberList = frmViewMemberList;
	}

	private List<UserType> frmUserTypeList;

	public List<UserType> getFrmUserTypeList() {
		return frmUserTypeList;
	}

	public void setFrmUserTypeList(List<UserType> frmUserTypeList) {
		this.frmUserTypeList = frmUserTypeList;
	}

	public String getFrmUserTypeName() {
		return frmUserTypeName;
	}

	public void setFrmUserTypeName(String frmUserTypeName) {
		this.frmUserTypeName = frmUserTypeName;
	}

	private String userName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getFrmDeleteId() {
		return frmDeleteId;
	}

	public void setFrmDeleteId(int frmDeleteId) {
		this.frmDeleteId = frmDeleteId;
	}

}
