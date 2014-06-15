package com.ictti.library.presentation.action;



import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;


import com.ictti.library.business.entity.Category;

import com.ictti.library.business.entity.ViewSearchBook;
import com.ictti.library.business.service.SearchDetailService;
import com.ictti.library.presentation.form.SearchDetailForm;

class SearchDetailAction extends BaseAction {
	private SearchDetailService myCategoryService;

	public SearchDetailService getMyCategoryService() {
		return myCategoryService;
	}

	public void setMyCategoryService(SearchDetailService myCategoryService) {
		this.myCategoryService = myCategoryService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		SearchDetailForm myForm = (SearchDetailForm) form;

		// load category list
		myForm.setCategoryId("");
		List booklist = new LinkedList();
		List<Category> blist = myCategoryService.getAllCategory();
		for (int i = 0; i < blist.size(); i++) {
			booklist.add(new LabelValueBean(blist.get(i).getCategoryName(),
					String.valueOf(blist.get(i).getId())));
		}
		myForm.setCategoryChoice(booklist);
		myForm.getCategoryChoice();

		System.out.println("CatId " + blist.get(0).getId());
		myForm.setCategoryID(blist.get(0).getId());

		request.setAttribute("myform", myForm);
		myForm.setFrmBookTitle("");
		myForm.setFrmAuthorName("");
		return "gotoAuto";

	}

	// Search Button For Inner Search
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		ActionErrors errors = new ActionErrors();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		SearchDetailForm myForm = (SearchDetailForm) form;
		String catID = myForm.getCategoryId();
		String subcatID = myForm.getSubcategoryId();
		if (catID.equals("6")) {
			myForm.setCategoryId("");
		}
		if (subcatID.equals("21")) {
			myForm.setSubcategoryId("");
		}

		if (request.getParameter("btnSearch") != null) {

			// For search with Title,Author,Category and SubCategory
			if (!(myForm.getFrmBookTitle().equals(""))
					&& !(myForm.getFrmAuthorName().equals(""))
					&& !(myForm.getCategoryId().equals(""))
					&& !(myForm.getSubcategoryId().equals(""))) {
				List<ViewSearchBook> bList = myCategoryService
						.searchByAllCriteria(myForm);
				System.out
						.println("This is Title,Author,Category and Subcategory!"
								+ myForm.getFrmBookTitle()
								+ myForm.getFrmAuthorName()
								+ myForm.getCategoryId()
								+ myForm.getSubcategoryId());
				System.out
						.println("Title,Author,Category and SubCategory List is  :"
								+ bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";
			}

			// For search with Title,Category and SubCategory
			if ((!myForm.getFrmBookTitle().equals(""))
					&& (!myForm.getCategoryId().equals(""))
					&& (!myForm.getSubcategoryId().equals("")))

			{
				List<ViewSearchBook> bList = myCategoryService
						.searchByTitleCategorySubCategory(myForm);
				System.out.println("This is Title,Category and Subcategory!"
						+ myForm.getFrmBookTitle() + myForm.getCategoryId()
						+ myForm.getSubcategoryId());
				System.out.println("Title,Category and SubCategory List is  :"
						+ bList);

				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";

			}

			// For search with Author,Category and SubCategory
			if (!myForm.getFrmAuthorName().equals("")
					&& (!myForm.getCategoryId().equals(""))
					&& (!myForm.getSubcategoryId().equals(""))) {
				List<ViewSearchBook> bList = myCategoryService
						.searchByAuthorCategorySubCategory(myForm);
				System.out.println("This is Author,Category and Subcategory!"
						+ myForm.getFrmAuthorName() + myForm.getCategoryId()
						+ myForm.getSubcategoryId());
				System.out.println("Author,Category and SubCategory List is  :"
						+ bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch1"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";
			}

			// For search with Title and Author
			if ((!myForm.getFrmAuthorName().equals(""))
					&& (!myForm.getFrmBookTitle().equals("")
							&& (myForm.getCategoryId().equals("")) && (myForm
							.getSubcategoryId().equals("")))) {

				List<ViewSearchBook> bList = myCategoryService
						.searchByTitleAuthor(myForm);

				System.out.println("Author and Title List is  :" + bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";
			}

			// For search With Title only

			if (!myForm.getFrmBookTitle().equals("")) {
				System.out.println("Title is  :" + myForm.getFrmBookTitle());
				List<ViewSearchBook> bList = myCategoryService
						.firstLoadSearchByTitle(myForm);
				System.out.println("Book List for title search is  :" + bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);

				return "gotoSearch";
			}

			// For search With Author only
			if (!myForm.getFrmAuthorName().equals("")
					&& (myForm.getFrmBookTitle().equals(""))
					&& (myForm.getSubcategoryId().equals(""))
					&& (myForm.getCategoryId().equals(""))) {
				System.out.println("This is Author Search!"
						+ myForm.getFrmAuthorName());
				List<ViewSearchBook> bList = myCategoryService
						.firstLoadSearchByAuthor(myForm);
				System.out.println("Book List for author search is  :" + bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch1"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";

			}

			// set value categoryId and subcategoryId for All,All because
			// categoryId and subcategoryId value is null
			if (myForm.getCategoryId().equals("")) {
				myForm.setCategoryId("6");
			}
			if (myForm.getSubcategoryId().equals("")) {
				myForm.setSubcategoryId("21");
			}

			// Search For All and All(category and sub category)
			Integer strcatid = Integer.parseInt(myForm.getCategoryId());
			Integer strsubid = Integer.parseInt(myForm.getSubcategoryId());

			if ((strcatid == 6) && (strsubid == 21)) {

				System.out
						.println("This is All for category and subcategory testing");
				List<ViewSearchBook> bList = myCategoryService
						.searchByAll(myForm);
				System.out.println("Book List For All and All  :" + bList);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				request.setAttribute("SearchFormBean", myForm);
				return "gotoSearch";
			}

			// For Category and subCategory
			System.out.println("This is Category and subCategory Search!");
			if (myForm.getFrmBookTitle().equals("")
					&& myForm.getFrmAuthorName().equals("")
					&& !myForm.getCategoryId().equals("")
					&& !myForm.getSubcategoryId().equals("")) {
				List<ViewSearchBook> bList = myCategoryService
						.getViewBookListByCategoryAndSubcategory(myForm);
				if (bList == null) {
					errors.add("searchError", new ActionMessage(
							"errors.chooseSearch"));
					saveErrors(request, errors);
					return "gotoAuto";
				}
				myForm.setFrmBookList(bList);
				System.out.println("Category is " + myForm.getCategoryId()
						+ " SubCategory is" + myForm.getSubcategoryId());
				request.setAttribute("AutoFormBean", myForm);
				return "gotoSearch";
			}
		}

		// for prev and next button
		if (null != request.getParameter("next")) {
			myForm.setActualPage(myForm.getActualPage() + 1);
			return "gotoSearch";
		}

		if (null != request.getParameter("prev")) {
			myForm.setActualPage(myForm.getActualPage() - 1);
			return "gotoSearch";

		}
		return "gotoTitle";
	}
}