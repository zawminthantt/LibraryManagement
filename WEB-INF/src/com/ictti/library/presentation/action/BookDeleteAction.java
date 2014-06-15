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

import com.ictti.library.business.entity.ViewDetailBook;
import com.ictti.library.business.service.BookDeleteService;
import com.ictti.library.presentation.form.CheckOutForm;

public class BookDeleteAction extends BaseAction {

	private BookDeleteService myBookDeleteService;

	public BookDeleteService getMyBookDeleteService() {
		return myBookDeleteService;
	}

	public void setMyBookDeleteService(BookDeleteService myBookDeleteService) {
		this.myBookDeleteService = myBookDeleteService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		return "gotoBookDeleteSearch";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		CheckOutForm myForm = (CheckOutForm) form;
		ActionErrors errors = new ActionErrors();
		
		if (request.getParameter("btnSearch") != null) {
			List<ViewDetailBook> list = myBookDeleteService.getBookInfo(myForm);
			myForm.setMyViewDetailBook(list);
			if (list == null) {
				request.getSession().setAttribute("rlist", null);
				request.getSession().setAttribute("list", null);
			} else {
				request.getSession().setAttribute("rlist", list);
				request.getSession().setAttribute("list", null);
			}
			return "gotoBookDelete";
		}
		if (request.getParameter("btnDelete") != null) {
			
			if (myForm.getSelectedItem() == null) {
				errors.add("noselectedItem", new ActionMessage(
						"errors.noselectedItem"));
				saveErrors(request, errors);
				return "gotoBookDelete";
			} 
			return "gotoBookDeleteConfirm";
		}
		if(request.getParameter("btnOk")!=null){
			List<ViewDetailBook> list = myBookDeleteService.getBookInfo(myForm);
			myForm.setMyViewDetailBook(list);
			List<Object> callnumberlist = new ArrayList<Object>();
			//List<Object> booklist = new ArrayList<Object>();
			String callNumberId = "";
			String bookId = "";
			int i = 0;
			if (myForm.getSelectedItem() == null) {
				errors.add("noselectedItem", new ActionMessage(
						"errors.noselectedItem"));
				saveErrors(request, errors);
				return "gotoBookDelete";
			} else {
				System.out.println("Selected Item "
						+ myForm.getSelectedItem().length);
				for (String str : myForm.getSelectedItem()) {
					
					String a[]=str.split(" ");
					//bookId=a[0];
					//callNumberId=str;
					callNumberId=a[0];
					bookId=a[1];
					callnumberlist.add(i, callNumberId);
					//booklist.add(i,bookId);
					i++;

				}
				System.out.println("Callnumberlist"+callnumberlist.size());
				myBookDeleteService.deleteBookByCallNumber(callnumberlist);
				myBookDeleteService.deleteCopyByBookId(myForm);
				return "gotoBookDeleteSuccess";
			}
		}
		if(request.getParameter("btnCancel")!=null){
			return "gotoBookDelete";
		}
			
		//}
		return "gotoBookDelete";
	}
}