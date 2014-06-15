package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.BookUpdateService;
import com.ictti.library.presentation.form.CheckOutForm;


public class BookUpdateAction extends BaseAction {
	private BookUpdateService myBookUpdateService;
	public BookUpdateService getMyBookUpdateService() {
		return myBookUpdateService;
	}

	public void setMyBookUpdateService(BookUpdateService myBookUpdateService) {
		this.myBookUpdateService = myBookUpdateService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoBookUpdateSearch";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		CheckOutForm myForm=(CheckOutForm)form;
		ActionErrors errors=new ActionErrors();
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		if(request.getParameter("btnSearch")!=null)
		{
			myBookUpdateService.getBookInfo(myForm);
			//myBookUpdateService.firstLoadBookUpdate(myForm);
			if(myForm.getFrmViewDetailBook()==null){
				errors.add("noupdatebook",new ActionMessage("errors.noupdatebook"));
				saveErrors(request,errors);
				return "gotoUpdate";
			}
			else{
				myBookUpdateService.firstLoadBookUpdate(myForm);
				return "gotoBookUpdate";
			}
			
		}
		
		if(request.getParameter("btnUpdate")!=null){
			//myBookUpdateService.saveBookListInfo(myForm);
			if(myForm.getNoOfcopies()>0 && myForm.getNoOfcopies()<=99){
				return "gotoBookUpdateConfirm";
			}
			else if(myForm.getNoOfcopies()>99){
				errors.add("copyadd",new ActionMessage("errors.maxcopyadd"));
				saveErrors(request,errors);
				return "gotoBookUpdate";
			}
			else{
				errors.add("copynegative",new ActionMessage("errors.copynegative"));
				saveErrors(request,errors);
				return "gotoBookUpdate";
			}
			
		}
		if(request.getParameter("btnUpdateCancel")!=null){
			return "gotoHome";
		}
		if(request.getParameter("btnSave")!=null){
			
			myBookUpdateService.saveBookUpdateInfo(myForm);
			myBookUpdateService.saveBookListInfo(myForm);
			return "gotoBookUpdateSuccess";
		}
		if(request.getParameter("btnSaveCancel")!=null){
			
			return "gotoBookUpdate";
		}
	   return "gotoHome";
	}

}
