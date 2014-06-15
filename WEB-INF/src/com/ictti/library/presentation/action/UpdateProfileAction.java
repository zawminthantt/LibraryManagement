package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.UserService;



import com.ictti.library.presentation.form.UserForm;

public class UpdateProfileAction extends BaseAction {
	private UserService myUpdateProfileService;
	public UserService getMyUpdateProfileService() {
		return myUpdateProfileService;
	}

	public void setMyUpdateProfileService(UserService myUpdateProfileService) {
		this.myUpdateProfileService = myUpdateProfileService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		// return super.doInit(form, request, response, mapping);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		UserForm myForm = (UserForm) form;
		UserForm loginForm = (UserForm) request.getSession().getAttribute("LoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		myUpdateProfileService.fristLoadUpdateProfile(myForm);
		return "gotoUpdate";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm myForm = (UserForm) form;
		if (request.getParameter("btnUpdateCancel") != null) {
			return "gotoHome";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoUpdate";
		}
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("btnUpdate") != null) {
			if (!myForm.getFrmRegPassword().equals(
					myForm.getFrmRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
			} else
				myForm.setFrmRegFormControl("data");
			return "gotoUpdate";
		}
		if (request.getParameter("btnSave") != null) {
			myUpdateProfileService.saveUpdateUser(myForm);
			return "gotoHome";
		}
		return null;
		
	}

}
