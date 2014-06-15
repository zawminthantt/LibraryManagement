package com.ictti.library.presentation.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.RenewService;
import com.ictti.library.presentation.form.UserForm;

public class RenewAction extends BaseAction {
	private RenewService myRenewService;
	public RenewService getMyRenewService() {
		return myRenewService;
	}

	public void setMyRenewService(RenewService myRenewService) {
		this.myRenewService = myRenewService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		UserForm myForm=(UserForm)form;
		myForm.setFrmViewRentedHistory(null);
		ActionErrors errors=new ActionErrors();
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		UserForm loginForm = (UserForm) request.getSession().getAttribute("LoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		System.out.println("In Renew Action user id"+myForm.getLoginUser().getId());
		myRenewService.getRenewInfo(myForm);
		System.out.println("IN Action User flag ="+myForm.getFrmRenewFlag());
		if(myForm.getFrmRenewFlag()!=null)
		{
			errors.add("renewError",
					new ActionMessage("errors.renew"));
			saveErrors(request, errors);
			return "gotoViewRent";
		}
		if(myForm.getFrmOverRenewFlag()!=null)
		{
			errors.add("renewoverError",
					new ActionMessage("errors.renewover"));
			saveErrors(request, errors);
			return "gotoViewRent";
		}
		if(myForm.getFrmOverDueFlag()!=null){
			errors.add("overdueError",
					new ActionMessage("errors.overdue"));
			saveErrors(request, errors);
			return "gotoViewRent";
		}
		return "gotoRenew";
	}
	
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm myForm=(UserForm)form;
		//myForm.setFrmUserFlag(null);
		if(request.getParameter("btnRenew")!=null){
			myRenewService.saveRenewInfo(myForm);
		}
		return "gotoSuccessRenew";
	}

}