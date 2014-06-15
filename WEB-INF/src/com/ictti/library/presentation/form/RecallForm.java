package com.ictti.library.presentation.form;
import java.util.Date;
import java.util.List;
import org.apache.struts.validator.ValidatorForm;
import com.ictti.library.business.entity.ViewRecall;
public class RecallForm extends ValidatorForm {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private Integer bookloanId;


// list for combo box Accession Code
private List<ViewRecall> listViewrecall;
private String ISBN;
private Date dueDate;
private String email;
private String title;
private String userId;
private String Call_Number;
private String message;
private String frmRegFormControl;
private String Date;
private String sendDate;
private String userType;

public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}
public String getSendDate() {
	return sendDate;
}
public void setSendDate(String sendDate) {
	this.sendDate = sendDate;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public String getFrmRegFormControl() {
	return frmRegFormControl;
}
public void setFrmRegFormControl(String frmRegFormControl) {
	this.frmRegFormControl = frmRegFormControl;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public Integer getBookloanId() {
	return bookloanId;
}
public void setBookloanId(Integer bookloanId) {
	this.bookloanId = bookloanId;
}
public List<ViewRecall> getListViewrecall() {
	return listViewrecall;
}
public void setListViewrecall(List<ViewRecall> listViewrecall) {
	this.listViewrecall = listViewrecall;
}
public String getISBN() {
	return ISBN;
}
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
public Date getDueDate() {
	return dueDate;
}
public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getCall_Number() {
	return Call_Number;
}
public void setCall_Number(String callNumber) {
	Call_Number = callNumber;
}
public String[] getSelectedItems() {
	return selectedItems;
}
public void setSelectedItems(String[] selectedItems) {
	this.selectedItems = selectedItems;
}
public String getErrmsg() {
	return errmsg;
}
public void setErrmsg(String errmsg) {
	this.errmsg = errmsg;
}
private String[] selectedItems;
private String errmsg;








}


