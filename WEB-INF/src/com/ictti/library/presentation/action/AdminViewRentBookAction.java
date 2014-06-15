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
import com.ictti.library.business.entity.ViewMostRentBook;
import com.ictti.library.business.service.AdminViewRentBookService;
import com.ictti.library.presentation.form.AdminViewBookForm;
import com.ictti.library.presentation.form.AdminViewMemberInfoForm;
import com.ictti.library.presentation.form.AdminViewReservationForm;

public class AdminViewRentBookAction extends BaseAction {
	private AdminViewRentBookService myAdminViewRentBookService;

	public AdminViewRentBookService getMyAdminViewRentBookService() {
		return myAdminViewRentBookService;
	}

	public void setMyAdminViewRentBookService(
			AdminViewRentBookService myAdminViewRentBookService) {
		this.myAdminViewRentBookService = myAdminViewRentBookService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}

		AdminViewBookForm myForm = (AdminViewBookForm) form;
		myAdminViewRentBookService.fristLoad(myForm);
		myForm.setFrmViewRentBookList(null);

		return "gotoBookRent";

	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		AdminViewBookForm myForm = (AdminViewBookForm) form;
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnSearch") != null) {
			myForm.setFrmViewRentBookList(null);
			if (myForm.getFrmCategoryId().equals("ALL")) {
				myAdminViewRentBookService.loadBookInfoAll(myForm);
			}

			else if (!myForm.getFrmCategoryId().equals("")) {

				System.out.println("Title is  :" + myForm.getFrmCategoryId());
				List<ViewMostRentBook> mList = myAdminViewRentBookService
						.loadBookInfo(myForm);

				if (mList == null) {
					errors.add("searchBookError", new ActionMessage(
							"errors.chooseBook"));
					saveErrors(request, errors);
					return "gotoBookRent";
				}

				return "gotoBookRent";
			} else {
				myAdminViewRentBookService.loadBookInfo(myForm);
			}
		}

		// if next button, doNext
		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);
		// if prev button, doPrev
		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);
		return "gotoBookRent";
	}
}
