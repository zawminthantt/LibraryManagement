package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.AdminService;
import com.ictti.library.presentation.form.AdminForm;



public class AdminLoginAction extends BaseAction{
private AdminService myAdminService;
	public AdminService getMyAdminService() {
	return myAdminService;
}
public void setMyAdminService(AdminService myAdminService) {
	this.myAdminService = myAdminService;
}
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		AdminForm myForm=(AdminForm)form;
		
		myAdminService.checkLoginAdmin(myForm);
		ActionErrors errors = new ActionErrors();
		if(myForm.getLoginAdmin()==null)
		{
			errors.add("loginerror", new 
					ActionMessage("errors.loginfail"));
			saveErrors(request,errors);
			return "gotoLogin";
		}
		else{
			request.getSession(true);
			request.getSession().setAttribute("id", 
					request.getSession().getId());
			return "gotoHome";
		}
	}
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		AdminForm myForm = (AdminForm) form;
		myForm.setFrmLoginName(null);
		myForm.setFrmPassword(null);
		return "gotoLogin";
	}

}
