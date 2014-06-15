package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;


import com.ictti.library.business.service.PhotoService;
import com.ictti.library.presentation.form.PhotoForm;



public class PhotoAction extends BaseAction{
	private PhotoService myPhotoService;

	public PhotoService getMyPhotoService() {
		return myPhotoService;
	}
	public void setMyPhotoService(PhotoService myPhotoService) {
		this.myPhotoService = myPhotoService;
	}
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		//return null;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
		       return "gotoLogin";
		}
		if (request.getParameter("btnUpload") != null) {
		       PhotoForm myForm = (PhotoForm) form;
		       myPhotoService.saveUploadPhoto(myForm);
		       return "gotoUpload";
		}
		
		return null;
	}
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
		       return "gotoLogin";
		}
		PhotoForm myForm=(PhotoForm) form;
		myPhotoService.loadAllPhoto(myForm);
		return "gotoUpload";
		
		
	}
}
