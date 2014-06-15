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

import com.ictti.library.business.entity.User;
import com.ictti.library.business.entity.ViewMemberInfo;
import com.ictti.library.business.entity.ViewReserveBook;
import com.ictti.library.business.entity.ViewSearchBook;
import com.ictti.library.business.service.AdminViewMemberInfoService;
import com.ictti.library.presentation.form.AdminViewMemberInfoForm;
import com.ictti.library.presentation.form.AdminViewReservationForm;

public class AdminViewMemberInfoAction extends BaseAction {
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
		AdminViewMemberInfoForm myForm = (AdminViewMemberInfoForm) form;
		
		ActionErrors errors = new ActionErrors();
		SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
		Date mydate = new Date();
		String myNewDate = myformat.format(mydate);
		// Integer my_date = Integer.parseInt(myNewDate);
		System.out.println("Date now in action" + myNewDate);
		List<Object> userlist = new ArrayList<Object>();
		List<Object> emailList = new ArrayList<Object>();
		List<Object> dateList = new ArrayList<Object>();
		String userId = "";
		String email = "";
		String date = "";
		int i = 0;
		
		if (request.getParameter("btnView") != null) {
			myForm.setFrmViewMemberList(null);
			myForm.setSelectedItem(null);
			
			if (myForm.getFrmUserTypeId().equals("0")) {
				errors.add("usertypeError",
						new ActionMessage("errors.usertype"));
				saveErrors(request, errors);
				return "gotoMember";
			}
			if (!myForm.getFrmUserTypeId().equals("0")) {
				
			
				System.out.println("Title is  :" + myForm.getFrmUserTypeId());
				List<ViewMemberInfo> mList = myAdminViewMemberService
						.loadMemberInfo(myForm);
				

				if (mList == null) {
					if(myForm.getFrmUserTypeId().equals("Teacher")){
						System.out.println("This is testing of teacher type");						
						return "gotoTeacherMember";				
					}
					errors.add("searchMemberError", new ActionMessage(
							"errors.chooseMember"));
					saveErrors(request, errors);
					return "gotoMember";
				}

				return "gotoMember";
			}
			

			else
				myAdminViewMemberService.loadMemberInfo(myForm);
		
			return "gotoMember";

		}

		if (request.getParameter("btnDelete") != null) {

			if (myForm.getSelectedItem() == null) {

				errors.add("noselectedItem", new ActionMessage(
						"errors.noselectedItem"));
				saveErrors(request, errors);
				return "gotoMember";
			}
			else {
				for (String str : myForm.getSelectedItem()) {

					String a[] = str.split(" ");
					// bookId=a[0];
					// callNumberId=str;
					userId = a[0];
					email = a[1];
					date = a[2];
					userlist.add(i, userId);
					emailList.add(i, email);
					dateList.add(i, date);
					i++;

				}
				System.out.println("userlist" + userlist.size());
				System.out.println("dateList" + dateList.size());
				for (int j = 0; j < dateList.size(); j++) {
					String expiredate = dateList.get(j).toString();
					if (expiredate.compareTo(myNewDate) > 0) {
						System.out.println("This is date that cann't delete");
						errors.add("expiredateerror", new ActionMessage(
								"errors.expireDate"));
						saveErrors(request, errors);
						return "gotoMember";
					} else
						myAdminViewMemberService.prepareForMail(myForm,
								emailList);
					myAdminViewMemberService.updateUserByUserId(userlist);
				}
			}

			myAdminViewMemberService.loadMemberInfo(myForm);
		
			System.out.println("This is test of Action");
			return "gotoMember";

		}

		if (null != request.getParameter("next"))
			myForm.setActualPage(myForm.getActualPage() + 1);
		// if prev button, doPrev
		if (null != request.getParameter("prev"))
			myForm.setActualPage(myForm.getActualPage() - 1);
		
		return "gotoMember";
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AdminViewMemberInfoForm myForm = (AdminViewMemberInfoForm) form;

		myAdminViewMemberService.fristLoad(myForm);
		myForm.setFrmViewMemberList(null);
		
		return "gotoMember";

	}
}
