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

public class LoginAction extends BaseAction {
	private UserService myUserService;

	public UserService getMyUserService() {
		return myUserService;
	}

	public void setMyUserService(UserService myUserService) {
		this.myUserService = myUserService;
	}

	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		UserForm myForm = (UserForm) form;
		myUserService.checkLoginUser(myForm);
		ActionErrors errors = new ActionErrors();

		if (myForm.getLoginUser() == null) {
			// user does not exist at table(login unsuccessfully)
			errors.add("loginerror", new ActionMessage("errors.login"));
			saveErrors(request, errors);
			return "gotoLogin";
		} else {
			// login successfully
			HttpSession session=request.getSession(true);
			request.getSession(true);
			request.getSession().setAttribute("id",	request.getSession().getId());
			session.setAttribute("userId", myForm.getLoginUser().getId());
			return "gotoHome";
		}
	}
}
