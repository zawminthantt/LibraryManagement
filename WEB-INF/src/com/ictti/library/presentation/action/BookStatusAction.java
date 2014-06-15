package com.ictti.library.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.ViewBookOnloan;
import com.ictti.library.business.entity.ViewSearchBook;
import com.ictti.library.business.service.BookStatusService;
import com.ictti.library.presentation.form.BookStatusForm;

public class BookStatusAction extends BaseAction {
	private BookStatusService myBookStatusService;

	public BookStatusService getMyBookStatusService() {
		return myBookStatusService;
	}

	public void setMyBookStatusService(BookStatusService myBookStatusService) {
		this.myBookStatusService = myBookStatusService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		//return super.doInit(form, request, response, mapping);
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
	
		BookStatusForm myForm= (BookStatusForm) form;
		myBookStatusService.firstLoadCallnumber(myForm);
		return "gotoSearch";
}

	

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		// return null;
		HttpSession session = request.getSession(false);
		BookStatusForm myForm = (BookStatusForm) form;
		myBookStatusService.checkInCallnumber(myForm);
		ActionErrors errors = new ActionErrors();

		if (request.getParameter("btnSearch") != null) {
			myBookStatusService.checkInCallnumber(myForm);
			
			
			
		if (myForm.getFrmRegCallNumber().equals("")) {
			errors.add("callnumbrError", new ActionMessage("errors.callnumber"));
			saveErrors(request, errors);
			return "gotoSearch";
			}
		
		else if (myForm.getCallnumber() == null) {

				System.out.println("Callnumber Does not exist AT TAble");
				errors.add("callnumbrNotExit", new ActionMessage(
						"errors.callnumbernotexit"));
				saveErrors(request, errors);
				return "gotoSearch";
				}
			
		} 
		

			
			/*
			ViewBookOnloan book = myBookStatusService.getByCallNumber(myForm.getFrmRegCallNumber());
				if (book != null) 
				{
					{
						errors.add("callnumbrNotExit", new ActionMessage("errors.callnumbernotexit"));
						saveErrors(request, errors);
						return "gotoSearch";
					
					}
			*/
				
		
	
	

		if (request.getParameter("btnNextSearch") != null) {
			myBookStatusService.firstLoadCallnumber(myForm);
			return "gotoSearch";
		}
		return "gotoSearch";

	}

}
