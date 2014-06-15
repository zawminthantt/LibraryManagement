package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import com.ictti.library.business.service.AdminService;
import com.ictti.library.business.service.PublisherService;
import com.ictti.library.presentation.form.AdminForm;

public class PublisherAction extends BaseAction {
	private PublisherService myPublisherService;
	private AdminService myAdminService;

	public PublisherService getMyPublisherService() {
		return myPublisherService;
	}

	public AdminService getMyAdminService() {
		return myAdminService;
	}

	public void setMyAdminService(AdminService myAdminService) {
		this.myAdminService = myAdminService;
	}

	public void setMyPublisherService(PublisherService myPublisherService) {
		this.myPublisherService = myPublisherService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		// return super.doInit(form, request, response, mapping);
		AdminForm myForm = (AdminForm) form;
		myPublisherService.firstLoadPublisher(myForm);

		return "gotoPublisher";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		AdminForm myForm = (AdminForm) form;
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("btnRegister") != null) {
			// publisher name
			if (myForm.getPublisherName().equals("")) {
				errors.add("PubError", new ActionMessage("errors.pub"));
				saveErrors(request, errors);

				return "gotoPublisher";
			}

			// publisher address
			if (myForm.getFrmPubAddress().equals("")) {
				errors.add("PubAddressError", new ActionMessage(
						"errors.pubaddress"));
				saveErrors(request, errors);

				return "gotoPublisher";
			}

			myForm.setFrmRegFormControl("data");
			return "gotoPublisher";
		}

		if (request.getParameter("btnSave") != null) {

			myPublisherService.saveNewPublisher(myForm);
			myAdminService.fristLoadRegistration(myForm);
			return "gotoAdminRegister";
		}
		if (request.getParameter("btnRegisterCancel") != null) {

			return "gotoPublisher";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoPublisher";
		}
		return "gotoPublisher";
	}
}