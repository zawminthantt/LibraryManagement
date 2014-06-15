package com.ictti.library.presentation.form;

import java.util.List;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.ictti.library.business.entity.Photo;

public class PhotoForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Photo> frmPhotoList;// photo variable;
	private int begin;// photo variable;
	private int end;//photo variable;
	private String frmPhotoId; //photo variable;
	private FormFile frmPhoto;// photo variable;
	public FormFile getFrmPhoto() {
		return frmPhoto;
	}
	public void setFrmPhoto(FormFile frmPhoto) {
		this.frmPhoto = frmPhoto;
	}
	private String frmViewPhoto;// photo variable;
	private String frmPhotoType; // photo variable;
	private FormFile frmUploadPhoto; // photo variable;
	public FormFile getFrmUploadPhoto() {
		return frmUploadPhoto;
	}
	public void setFrmUploadPhoto(FormFile frmUploadPhoto) {
		this.frmUploadPhoto = frmUploadPhoto;
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
	
	 
}
