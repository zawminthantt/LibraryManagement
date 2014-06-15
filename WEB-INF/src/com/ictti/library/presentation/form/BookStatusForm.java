package com.ictti.library.presentation.form;

import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.ictti.library.business.entity.ViewBookOnloan;

public class BookStatusForm extends ActionForm  {
	private String frmRegCallNumber;
	private String frmCallnumber;
	private String frmRegFormControl;
	private String frmRegISBN;
	private String frmRegTitle;
	private String frmRegAuthor;
	private String frmRegReserveUserName;
	private String frmRegCheckUserName;
	private Integer frmLoanStatus;
	private Integer frmReserveStatus;
	private Integer frmadminBookStatus;// For Use Service
	private ViewBookOnloan Callnumber;
	private List<ViewBookOnloan> Callnumber1;
	public List<ViewBookOnloan> getCallnumber1() {
		return Callnumber1;
	}

	public void setCallnumber1(List<ViewBookOnloan> callnumber1) {
		Callnumber1 = callnumber1;
	}

	private Date frmIssueDate;
	private Date frmDueDate;
	private Date frmReserved;
	
	

	public ViewBookOnloan getCallnumber() {
		return Callnumber;
	}

	public void setCallnumber(ViewBookOnloan callnumber) {
		Callnumber = callnumber;
	}

	public Integer getFrmadminBookStatus() {
		return frmadminBookStatus;
	}

	public void setFrmadminBookStatus(Integer frmadminBookStatus) {
		this.frmadminBookStatus = frmadminBookStatus;
	}

	public String getFrmRegCallNumber() {
		return frmRegCallNumber;
	}

	public void setFrmRegCallNumber(String frmRegCallNumber) {
		this.frmRegCallNumber = frmRegCallNumber;
	}

	public String getFrmCallnumber() {
		return frmCallnumber;
	}

	public void setFrmCallnumber(String frmCallnumber) {
		this.frmCallnumber = frmCallnumber;
	}

	public String getFrmRegFormControl() {
		return frmRegFormControl;
	}

	public void setFrmRegFormControl(String frmRegFormControl) {
		this.frmRegFormControl = frmRegFormControl;
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

	public String getFrmRegAuthor() {
		return frmRegAuthor;
	}

	public void setFrmRegAuthor(String frmRegAuthor) {
		this.frmRegAuthor = frmRegAuthor;
	}

	public String getFrmRegReserveUserName() {
		return frmRegReserveUserName;
	}

	public void setFrmRegReserveUserName(String frmRegReserveUserName) {
		this.frmRegReserveUserName = frmRegReserveUserName;
	}

	public String getFrmRegCheckUserName() {
		return frmRegCheckUserName;
	}

	public void setFrmRegCheckUserName(String frmRegCheckUserName) {
		this.frmRegCheckUserName = frmRegCheckUserName;
	}

	public Date getFrmIssueDate() {
		return frmIssueDate;
	}

	public void setFrmIssueDate(Date frmIssueDate) {
		this.frmIssueDate = frmIssueDate;
	}

	public Date getFrmDueDate() {
		return frmDueDate;
	}

	public void setFrmDueDate(Date frmDueDate) {
		this.frmDueDate = frmDueDate;
	}

	public Date getFrmReserved() {
		return frmReserved;
	}

	public void setFrmReserved(Date frmReserved) {
		this.frmReserved = frmReserved;
	}

	public Integer getFrmLoanStatus() {
		return frmLoanStatus;
	}

	public void setFrmLoanStatus(Integer frmLoanStatus) {
		this.frmLoanStatus = frmLoanStatus;
	}

	public Integer getFrmReserveStatus() {
		return frmReserveStatus;
	}

	public void setFrmReserveStatus(Integer frmReserveStatus) {
		this.frmReserveStatus = frmReserveStatus;
	}

}
