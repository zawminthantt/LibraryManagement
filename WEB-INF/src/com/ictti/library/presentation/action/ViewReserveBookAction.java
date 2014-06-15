package com.ictti.library.presentation.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.entity.BookReserve;
import com.ictti.library.business.entity.CallNumber;
import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.business.service.ViewReserveBookService;
import com.ictti.library.presentation.form.ViewReserveBookForm;

public class ViewReserveBookAction extends BaseAction {
	private ViewReserveBookService myViewReserveBookService;

	public ViewReserveBookService getMyViewReserveBookService() {
		return myViewReserveBookService;
	}

	public void setMyViewReserveBookService(
			ViewReserveBookService myViewReserveBookService) {
		this.myViewReserveBookService = myViewReserveBookService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		ActionErrors errors = new ActionErrors();
		System.out.println("This is test" + session.getAttribute("userId"));
		Integer id = (Integer) session.getAttribute("userId");
		System.out.println("This is test of Object" + id);

		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		ViewReserveBookForm myForm = (ViewReserveBookForm) form;
		if (myForm.getFrmControl().equals("1")) {
			System.out.println("Title is  :" + myForm.getFrmControl());
			List<ViewReserveBook> bList = myViewReserveBookService
					.firstLoadReserve(myForm, id);
			System.out.println("Book size is  :" + bList);
			if (bList.get(0)==null) {
				errors.add("noRecordError", new ActionMessage(
						"errors.norecordbook"));
				saveErrors(request, errors);
				return "gotoReserve";
			}
		}
			if (myForm.getFrmControl().equals("2")) {
				String callNumberId = "";
				String bookReserveId = "";
				int i = 0;

				for (String str : myForm.getFrmCancelReserveId()) {

					String a[] = str.split(" ");
					bookReserveId = a[0];
					callNumberId = a[1];
					i++;

				}
				CallNumber myCallNumber = myViewReserveBookService
						.getCallNumberById(Integer.parseInt(callNumberId));
				System.out.println("this is test of database"
						+ myForm.getFrmCancelCallId());
				myCallNumber.setIssuseStatus(0);
				BookReserve newBookReserve = myViewReserveBookService
						.getAllDataById(Integer.parseInt(bookReserveId));
				newBookReserve.setReserveStatus(1);
				myViewReserveBookService.saveOrUpdate(newBookReserve);
				System.out.println("this is test of bookReserve status:"
						+ newBookReserve.getReserveStatus());
				System.out.println("this is test at action of update:"
						+ myCallNumber.getIssuseStatus());
				myViewReserveBookService.saveOrUpdate(myCallNumber);
				System.out.println("this is test at action after service");
				myViewReserveBookService.loadUpdate(myForm, id);
				return "gotoCancel";
			} else
							
				System.out.println("This is test of Action");
			return "gotoReserve";
		
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		ViewReserveBookForm myForm = (ViewReserveBookForm) form;
		HttpSession session = request.getSession(false);

		if (request.getParameter("btnOk") != null) {
			return "gotoLogin";
		}
		// if next button, doNext
		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);
		// if prev button, doPrev
		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);

		return "gotoReserve";
	}

}
