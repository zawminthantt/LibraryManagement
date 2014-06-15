package com.ictti.library.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.CheckOutService;
import com.ictti.library.presentation.form.CheckOutForm;
import com.ictti.library.util.Util;

public class CheckOutActionOld extends BaseAction {
	private CheckOutService myCheckOutService;

	public CheckOutService getMyCheckOutService() {
		return myCheckOutService;
	}

	public void setMyCheckOutService(CheckOutService myCheckOutService) {
		this.myCheckOutService = myCheckOutService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		CheckOutForm myForm = (CheckOutForm) form;
		// myCheckOutService.firstLoadCheckOut(myForm);*/
		myForm.setFrmUserFlag(null);
		myForm.setFrmBookOnLoanFlag(null);
		myForm.setFrmReserveFlag(null);
		myForm.setFrmUserInfoFlag(null);
		return "gotoCheckOut";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		CheckOutForm myForm = (CheckOutForm) form;
		//String checkCallCode = myForm.getFrmCheckOutCallNo().toString();
		myForm.setFrmUserFlag(null);
		myForm.setFrmBookOnLoanFlag(null);
		myForm.setFrmReserveFlag(null);
		myForm.setFrmUserInfoFlag(null);
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (request.getParameter("btnSearch") != null) {
			myCheckOutService.checkLoginUser(myForm);
			if (myForm.getFrmUserInfoFlag() != null) {
				errors.add("checkoutUserError", new ActionMessage(
						"errors.checkoutUser"));
				saveErrors(request, errors);
				// return "gotoCheckOut";
			} else {
				if (myForm.getFrmUserFlag() != null) {
					errors.add("checkoutError", new ActionMessage(
							"errors.checkout"));
					saveErrors(request, errors);
				}
				else {
					if (myForm.getFrmBookOnLoanFlag() != null) {
						errors.add("bookonLoanError", new ActionMessage(
								"errors.bookonloan"));
						saveErrors(request, errors);
					} else {
						// myCheckOutService.getBookIdByIsbn(myForm);
						//myCheckOutService.getBookIdByCallNo(myForm);
						if (myForm.getFrmViewDetailBook() == null) {
							errors.add("nobookerror", new ActionMessage(
									"errors.noBook"));
							saveErrors(request, errors);
						} else {
							myForm.setFrmCheckoutFormControl("data");
							myCheckOutService.getReserveByUserId(myForm);
							if (myForm.getMyBookReserve() != null) {

								// user reserved or not?

								myForm.setFrmCheckoutFormControl("mybook");
								///myForm.setFrmCheckOutCallNo(checkCallCode);

								System.out.println("Check Out Call Number="
										+ myForm.getFrmCheckOutCallNo());

							} else {
								myCheckOutService.getReserveByCallId(myForm);
								// myForm.setMyBookReserve(null);

								if (myForm.getMyBookReserve() != null) {
									errors.add(
											"checkoutbookreserror",
											new ActionMessage(
													"errors.checkoutbookReserve"));
									saveErrors(request, errors);
									myForm.setFrmCheckoutFormControl(null);

								}
								// no reserve
								//myCheckOutService
									//	.getCallNumberListByCallCode(myForm);
								if (myForm.getMyCallNumber() != null) {
									errors.add("checkoutbookerror",
											new ActionMessage(
													"errors.checkoutBook"));
									saveErrors(request, errors);
									myForm.setFrmCheckoutFormControl(null);
								} else {
									myForm.setFrmCheckoutFormControl("avail");
									// myForm.setFrmCheckOutCallNo(myForm.getMyCallNumber().get(0).toString());
									//myForm.setFrmCheckOutCallNo(checkCallCode);
								}
							}

							Date today = new Date();
							SimpleDateFormat myFormat = new SimpleDateFormat(
									"yyyy-MM-dd");
							myForm.setIssue_date(myFormat.format(today));
							int loan_period = myForm.getFrmUserInfo().getUserType().getLoanPeriod();
							System.out.println("Loan Period in action"+loan_period);
							if(loan_period<30){
							System.out.println("Loan Period in action"+loan_period);
							long period = (loan_period * (24 * 3600000));
							long issue_date = today.getTime();
							long due_date = period + issue_date;
							Date due_date1 = new Date(due_date);
							System.out.println("Due Date "+due_date1);
							myForm.setIDate(today);
							myForm.setdDate(due_date1);
							myForm.setDue_date(myFormat.format(due_date));
							}
							else{
								myForm.setIDate(today);
								SimpleDateFormat sdf = new SimpleDateFormat();
                                sdf.applyPattern("yyyy-MM-dd");
                                 Date due_date=Util.isDate(Util.addToDate( loan_period));
                                 System.out.println("due date in else"+due_date);
                                 myForm.setdDate(due_date);
                                 myForm.setDue_date(sdf.format(due_date));
							}
							myForm.setFrmIsbn(myForm.getFrmViewDetailBook()
									.getIsbn());
							myForm.setFrmAuthor(myForm.getFrmViewDetailBook()
									.getAuthorName());
						}
					}
				}
			}
		}

		if (request.getParameter("btnCheckOut") != null) {
			//myForm.setFrmCheckoutFormControl("data");
			// save book on loan and update call number status
			System.out.println("Check Out Form Control"+ myForm.getFrmCheckoutFormControl());
			if (myForm.getFrmCheckoutFormControl().equals("avail")) {
				myCheckOutService.saveCheckOutInfo(myForm);
			}
			if (myForm.getFrmCheckoutFormControl().equals("mybook")) {
				myCheckOutService.saveCheckOutInfo(myForm);
				myCheckOutService.updateBookReserveInfo(myForm);
			}
            return "gotoHome";
		}
		return "gotoCheckOut";
	}
}
