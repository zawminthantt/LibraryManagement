package com.ictti.library.presentation.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.CheckInService;
import com.ictti.library.presentation.form.CheckOutForm;

public class CheckInAction extends BaseAction {
	private CheckInService myCheckInService;

	public CheckInService getMyCheckInService() {
		return myCheckInService;
	}

	public void setMyCheckInService(CheckInService myCheckInService) {
		this.myCheckInService = myCheckInService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		CheckOutForm myForm = (CheckOutForm) form;
		myForm.setFrmCallNumberFlag(null);
		myForm.setFrmCallNumberFlag2(null);
		myForm.setFrmIsbn(null);
		myForm.setFrmLoginName(null);
		return "gotoCheckIn";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		CheckOutForm myForm = (CheckOutForm) form;
		myForm.setFrmCallNumberFlag(null);
		myForm.setFrmCallNumberFlag2(null);
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnSearch") != null) {
			myCheckInService.getCheckInfo(myForm);
			if (myForm.getFrmCallNumberFlag() != null) {
				errors.add("checkinbookserror", new ActionMessage(
						"errors.checkinbook"));
				saveErrors(request, errors);
         
				/*if (myForm.getFrmCallNumberFlag2() == null) {
					errors.add("checkinerror2", new ActionMessage(
							"errors.checkinbookexit2"));
					saveErrors(request, errors);
					return "gotoCheckIn";
				}*/
				return "gotoCheckIn";
			}
			
			else {
				if (myForm.getFrmCallNumberFlag2() != null) {
					errors.add("checkinerror2", new ActionMessage(
							"errors.checkinbookexit2"));
					saveErrors(request, errors);
					return "gotoCheckIn";
					/*myCheckInService.getCallStatus(myForm);
					if (myForm.getFrmCallNumberFlag() != null) {
						errors.add("checkinerror", new ActionMessage(
								"errors.checkinbookexit"));
						saveErrors(request, errors);
						return "gotoCheckIn";*/
				//}
				/*myCheckInService.getCallStatus(myForm);
				if (myForm.getFrmCallNumberFlag() != null) {
					errors.add("checkinerror", new ActionMessage(
							"errors.checkinbookexit"));
					saveErrors(request, errors);
					return "gotoCheckIn";*/
				//}
				}
			}
			return "gotoCheckInDetail";
		}

		if (request.getParameter("btnCheckIn") != null) {
			myCheckInService.saveBookLoanInfo(myForm);
			myCheckInService.saveCallNoInfo(myForm);
			return "gotoCheckInSuccess";
		}
		return "gotoHome";
	}

}