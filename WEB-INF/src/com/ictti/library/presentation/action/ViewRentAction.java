package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.ViewRentService;
import com.ictti.library.presentation.form.UserForm;

public class ViewRentAction extends BaseAction  {
	 private ViewRentService myViewRentService;
	public ViewRentService getMyViewRentService() {
		return myViewRentService;
	}

	public void setMyViewRentService(ViewRentService myViewRentService) {
		this.myViewRentService = myViewRentService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		UserForm myForm=(UserForm)form;
		ActionErrors errors=new ActionErrors();
		UserForm loginForm = (UserForm) request.getSession().getAttribute("LoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		System.out.println("In Action user id"+myForm.getLoginUser().getId());
		//myViewRentService.checkLoginUser(myForm);
		/*if(myForm.getFrmUserFlag()!=null)
		{
			errors.add("reserveError",
					new ActionMessage("errors.reserve"));
			saveErrors(request, errors);
			System.out.println("No User Information!!!!!");
			return "gotoViewRent";
			
		}
		else {
			System.out.println("In Action!!!!!"+myForm.getFrmusr_id());
			myViewRentService.getBookLoanInfo(myForm);
			return "gotoViewRent";
		}*/
		//System.out.println("In Action!!!!!"+myForm.getFrmusr_id());
		myViewRentService.getBookLoanInfo(myForm);
		if(myForm.getFrmViewRentFlag()!=null){
			errors.add("norecordError",
					new ActionMessage("errors.norecord"));
			saveErrors(request, errors);
			System.out.println("No User Information!!!!!");
			return "gotoViewRent";
		}
		return "gotoViewRent";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		UserForm myForm=(UserForm)form;
		//ActionErrors errors=new ActionErrors();
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		// if next button, doNext
		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);
		// if prev button, doPrev
		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);

		return "gotoViewRent";
	}

}
