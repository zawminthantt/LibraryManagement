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
import com.ictti.library.business.service.SearchService;
import com.ictti.library.presentation.form.SearchForm;

public class SearchAction extends BaseAction {
	


	// private SearchService myCategoryService;
	private SearchService mySearchService;

	public SearchService getMySearchService() {
		return mySearchService;
	}

	public void setMySearchService(SearchService mySearchService) {
		this.mySearchService = mySearchService;
	}

	
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		String strtitle = request.getParameter("title");
		// TODO Auto-generated method stub
		SearchForm myForm = (SearchForm) form;
		ActionErrors errors = new ActionErrors();
		// if next button, doNext
		if (null != request.getParameter("next")) {
			myForm.setActualPage(myForm.getActualPage() + 1);
			// if prev button, doPrev
			return "gotoDetail";
		}

		if (null != request.getParameter("prev")) {
			myForm.setActualPage(myForm.getActualPage() - 1);
			return "gotoDetail";

		}
		

		if (request.getParameter("btnSearch") != null) {
			List<BookList> bList = mySearchService.firstLoadSearch(myForm);
			

			if (myForm.getFrmBookTitle().equals("")) {
				errors.add("searchTitle", new ActionMessage("errors.title"));
				saveErrors(request, errors);
				
				return "gotoLogin";
			}

			else if (bList == null) {
				errors.add("searchError", new ActionMessage(
						"errors.chooseSearch"));
				saveErrors(request, errors);
				//myForm.setFrmBookTitle("");
				return "gotoLogin";
			}

			System.out.println("This is Button Search!"
					+ myForm.getFrmBookTitle());

			// mySearchService.firstLoadSearch(myForm);
			/*
			 * if(bList.size()==0) { errors.add("searchError", new
			 * ActionMessage("errors.chooseSearch")); saveErrors(request,
			 * errors); return "gotoLogin"; }
			 */
			myForm.setFrmBookList(bList);
			System.out.println("Title=" + myForm.getFrmBookTitle());
			myForm.setFrmBookTitle("");
			return "gotoDetail";

		}

		if (request.getParameter("btnOk") != null) {

			return "gotoBook";
		}

		return null;
	}
}