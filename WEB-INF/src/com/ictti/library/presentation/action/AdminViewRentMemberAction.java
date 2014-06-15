package com.ictti.library.presentation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.service.AdminViewMemberInfoService;
import com.ictti.library.presentation.form.AdminViewMemberInfoForm;

public class AdminViewRentMemberAction extends BaseAction {

	private AdminViewMemberInfoService myAdminViewMemberService;

	public AdminViewMemberInfoService getMyAdminViewMemberService() {
		return myAdminViewMemberService;
	}

	public void setMyAdminViewMemberService(
			AdminViewMemberInfoService myAdminViewMemberService) {
		this.myAdminViewMemberService = myAdminViewMemberService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {

		if (request.getParameter("btnSearch") != null) {

			AdminViewMemberInfoForm myForm = (AdminViewMemberInfoForm) form;
			myForm.setFrmViewRentMemberList(null);

			ActionErrors errors = new ActionErrors();
			if (myForm.getFrmUserTypeId().equals("0")) {
				errors.add("usertypeError",
						new ActionMessage("errors.usertype"));
				saveErrors(request, errors);
				return "gotoRentMember";
			}
			if (!myForm.getFrmUserTypeId().equals("0")) {
				System.out.println("Title is  :" + myForm.getFrmUserTypeId());
				List<ViewMemberInfo> mList = myAdminViewMemberService
						.loadRentMemberInfo(myForm);

				if (mList == null) {
					errors.add("searchMemberError", new ActionMessage(
							"errors.chooseMember"));
					saveErrors(request, errors);
					return "gotoRentMember";
				}

				return "gotoRentMember";
			} else
				myAdminViewMemberService.loadRentMemberInfo(myForm);

		}
		AdminViewMemberInfoForm myForm = (AdminViewMemberInfoForm) form;
		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);

		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);
		return "gotoRentMember";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AdminViewMemberInfoForm myForm = (AdminViewMemberInfoForm) form;
		/*
		 * if (myForm.getFrmControl().equals("2")) { User myUser =
		 * myAdminViewMemberService.getUserById(myForm);
		 * myUser.setUserStatus("inactive");
		 * myAdminViewMemberService.saveOrUpdate(myUser); }
		 */

		myAdminViewMemberService.fristLoad(myForm);
		myForm.setFrmViewRentMemberList(null);
		return "gotoRentMember";

	}

}
