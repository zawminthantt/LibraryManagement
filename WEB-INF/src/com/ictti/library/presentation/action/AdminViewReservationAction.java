package com.ictti.library.presentation.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.business.service.ViewReserveBookService;
import com.ictti.library.presentation.form.AdminViewReservationForm;

public class AdminViewReservationAction extends BaseAction {

	private ViewReserveBookService myViewReserveBookService;

	public ViewReserveBookService getMyViewReserveBookService() {
		return myViewReserveBookService;
	}

	public void setMyViewReserveBookService(
			ViewReserveBookService myViewReserveBookService) {
		this.myViewReserveBookService = myViewReserveBookService;
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}

		if (request.getParameter("btnSearch") != null) {
			AdminViewReservationForm myForm = (AdminViewReservationForm) form;
			ActionErrors errors = new ActionErrors();

			if (myForm.getFromDate().equals("")
					&& myForm.getToDate().equals("")) {
				errors.add("dateerror", new ActionMessage("errors.bothDate"));
				saveErrors(request, errors);
				return "gotoCalendar";
			}

			if (myForm.getFromDate().equals("")) {
				errors.add("dateerror", new ActionMessage("errors.fromDate"));
				saveErrors(request, errors);
				return "gotoCalendar";
			}

			if (myForm.getToDate().equals("")) {
				errors.add("dateerror", new ActionMessage("errors.toDate"));
				saveErrors(request, errors);
				return "gotoCalendar";
			}

			SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
			Date myD1 = myformat.parse(myForm.getFromDate());
			Date myD2 = myformat.parse(myForm.getToDate());

			if (myD1.after(myD2)) {
				errors.add("dateerror", new ActionMessage("errors.dateGreater"));
				saveErrors(request, errors);
				return "gotoCalendar";
			}

			else
				myViewReserveBookService.loadReserveList(myForm, myD1, myD2);
			System.out.println("This is test of Action");
			return "gotoCalendar";
		}
		AdminViewReservationForm myForm = (AdminViewReservationForm) form;
		ActionErrors errors = new ActionErrors();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date myD1 = myformat.parse(myForm.getFromDate());
		Date myD2 = myformat.parse(myForm.getToDate());
		List<Object> callnumberlist = new ArrayList<Object>();
		List<Object> bookReserveList = new ArrayList<Object>();
		List<Object> callnumbercodelist = new ArrayList<Object>();
		List<Object> userList = new ArrayList<Object>();
		List<Object> usernamelist = new ArrayList<Object>();
		List<Object> emailList = new ArrayList<Object>();
		String callNumberId = "";
		String bookReserveId = "";
		String callNumbercode = "";
		String userId = "";
		String userName = "";
		String email = "";
		int i = 0;
		if (request.getParameter("btnDelete") != null) {

			if (myForm.getSelectedItem() == null) {
				errors.add("noselectedItem", new ActionMessage(
						"errors.noselectedItem"));
				saveErrors(request, errors);
				return "gotoCalendar";
			} else {
				System.out.println("Selected Item "
						+ myForm.getSelectedItem().length);
				for (String str : myForm.getSelectedItem()) {

					String a[] = str.split(" ");
					// bookId=a[0];
					// callNumberId=str;
					bookReserveId = a[0];
					callNumberId = a[1];
					// userId = a[2];
					// callNumbercode = a[2];
					// userName = a[3];
					email = a[2];
					bookReserveList.add(i, bookReserveId);
					callnumberlist.add(i, callNumberId);
					// userList.add(i, userId);
					// callnumbercodelist.add(i, callNumbercode);
					// usernamelist.add(i, userName);
					emailList.add(i, email);
					i++;

				}
				System.out.println("Callnumberlist" + callnumberlist.size());
				System.out.println("BookReseveList" + bookReserveList.size());
				myViewReserveBookService.prepareForMail(myForm, emailList);
				myViewReserveBookService
						.updateBookByBookReserve(bookReserveList);
				myViewReserveBookService.updateBookByCallNumber(callnumberlist);
				myViewReserveBookService.loadReserveList(myForm, myD1, myD2);
			}
		
			System.out.println("This is test of Action");
			return "gotoCalendar";

		}
		// if next button, doNext
		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);
		// if prev button, doPrev
		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);
		return "gotoCalendar";

	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AdminViewReservationForm myForm = (AdminViewReservationForm) form;
		myForm.setFromDate(null);
		myForm.setToDate(null);
		myForm.setFrmAdminViewBookReserveList(null);
		return "gotoCalendar";
	}

}