package com.ictti.library.presentation.action;

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

import org.apache.struts.util.LabelValueBean;

import com.ictti.library.business.entity.BookList;
import com.ictti.library.business.entity.Category;
import com.ictti.library.business.service.AdminService;
import com.ictti.library.presentation.form.AdminForm;
import com.ictti.library.util.ImageValidator;
import com.ictti.library.util.Util;

public class AdminBookRegisterAction extends BaseAction {

	private AdminService myAdminService;

	public AdminService getMyAdminService() {
		return myAdminService;
	}

	public void setMyAdminService(AdminService myAdminService) {
		this.myAdminService = myAdminService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		AdminForm myForm = (AdminForm) form;
		List<LabelValueBean> booklist = new ArrayList<LabelValueBean>();
		// load category list
		List<Category> blist = myAdminService.getAllCategory();
		System.out.println("This is Book Register Action" + blist.size());
		for (int i = 0; i < blist.size(); i++) {
			booklist.add(i, new LabelValueBean(blist.get(i).getCategoryName(),
					String.valueOf(blist.get(i).getId())));
			System.out.println("inside:" + booklist.get(i));
		}
		myForm.setCategoryChoice(booklist);
		System.out.println("CatId " + blist.get(0).getId());
		myForm.setCategoryID(blist.get(0).getId());
		request.setAttribute("myform", myForm);
		myForm.setFrmPubAddress("");
		myForm.setPublisherName("");

		myAdminService.fristLoadRegistration(myForm);

		myForm.setFrmRegFormControl(null);

		// To clean data for next time
		myForm.setAut1_init(null);
		myForm.setFrmOrgName(null);
		myForm.setFrmRegAuthor1(null);
		myForm.setFrmRegAuthor2(null);
		myForm.setFrmRegAuthor3(null);
		myForm.setFrmRegCopy(0);
		myForm.setFrmRegEdition(null);
		myForm.setFrmRegISBN(null);
		myForm.setFrmRegPage(0);
		myForm.setFrmOrgName(null);
		myForm.setFrmRegTitle(null);
		myForm.setFrmRegRemark(null);
		myForm.setFrmRegDate(null);
		myForm.setFrmRegResource(null);
		myForm.setFrmRegPublisher(null);

		return "gotoAdminRegister";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		// return null;
		HttpSession session = request.getSession(false);
		AdminForm myForm = (AdminForm) form;
		ActionErrors errors = new ActionErrors();

		if (request.getParameter("btnRegister") != null) {
			// for book register to get publisher name
			myAdminService.getPublisherName(myForm);
			// for book register to get category name
			myAdminService.getCategoryName(myForm);
			// for book register to get sub category name
			myAdminService.getSubCategoryName(myForm);
			// to check published date
			Date toDate = Util.isDate(myForm.getFrmRegDate());
			System.out.println("Publish date must be later today date!!!!!");
			if (toDate.after(new Date())) {
				System.out.println("Publish date must be earlier today date");

				errors.add("dateError", new ActionMessage("errors.date"));
				saveErrors(request, errors);
				return "gotoAdminRegister";
			}
			// to check ISBN must be unique
			BookList book = this.myAdminService.getByBookISBN(myForm
					.getFrmRegISBN());
			if (book != null) {
				System.out.println("This is action error for ISBN");

				errors.add("registerError",
						new ActionMessage("errors.register"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}
			// to check category ALL and sub category ALL
			String catId = myForm.getCategoryId();
			String subcatId = myForm.getSubCategoryId();
			if ((catId.equals("6")) && (subcatId.equals("21"))) {
				errors.add("CategoryError",
						new ActionMessage("errors.Category"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";

			}
			if ((catId.equals("6") || (subcatId.equals("21")))) {
				errors.add("CategoryError",
						new ActionMessage("errors.Category"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}
			if((catId.equals("6"))&&(subcatId.equals("")))
			{
				errors.add("SubcategoryError",
						new ActionMessage("errors.Subcategory"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}
			// to check ISBN No 10 and 13
			int isbn = myForm.getFrmRegISBN().length();

			if (isbn == 10 || isbn == 13) {
				System.out.println("Successfully test for isbn!!!");

			} else {
				System.out.println("Test for ISBN No 10 and No 13");

				errors.add("falseisbn", new ActionMessage("errors.falseisbn"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";

			}
			// Check no upload Photo
			if (myForm.getFrmUploadPhoto().getFileName() == ("")) {
				errors.add("NoPhoto", new ActionMessage("errors.NoPhoto"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}
			// Check wrong File type for Photo
			String image_type = myForm.getFrmUploadPhoto().getFileName();
			System.out.println("Image Type" + image_type);
			ImageValidator valid = new ImageValidator();
			boolean flag = valid.validate(image_type);
			if (!flag) {
				errors.add("PhotoTypeWrong", new ActionMessage(
						"errors.PhotoTypeWrong"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}
			// check large photo's size
			if (myForm.getFrmUploadPhoto().getFileName() != null) {
				String path = (getServlet().getServletContext().getRealPath("") + "/images/");
				myForm.setFrmPhotoPath(path);
				int size = myForm.getFrmUploadPhoto().getFileSize();
				if ((size / 1024) > 64) {
					errors.add("PhotoError", new ActionMessage(
							"errors.LargePhoto"));
					saveErrors(request, errors);
					myForm.setFrmRegFormControl(null);
					return "gotoAdminRegister";
				}

			}

			myForm.setFrmRegFormControl("data");
			return "gotoAdminRegister";
		}
		if (request.getParameter("btnSave") != null) {

			// To check Published date
			Date toDate = Util.isDate(myForm.getFrmRegDate());
			System.out.println("Publish date must be later today date!!!!!");
			if (toDate.after(new Date())) {
				System.out.println("Publish date must be earlier today date");

				errors.add("dateError", new ActionMessage("errors.date"));
				saveErrors(request, errors);
				return "gotoAdminRegister";

			}
			// to check ISBN must be unique
			BookList book = this.myAdminService.getByBookISBN(myForm
					.getFrmRegISBN());
			if (book != null) {
				System.out.println("This is action error for ISBN");

				errors.add("registerError",
						new ActionMessage("errors.register"));
				saveErrors(request, errors);
				myForm.setFrmRegFormControl(null);
				return "gotoAdminRegister";
			}

			myAdminService.saveNewAuthor(myForm);// Save for book author;
			myAdminService.saveNewBook(myForm);// Save for book list;
			myAdminService.saveNewPhoto(myForm);// Save for photo;

			System.out
					.println("This is testing for save new book!!!Save Successfully"
							+ myForm.getFrmRegPublisher());
			return "gotoSaveBook";
		}
		if (request.getParameter("btnRegisterCancel") != null) {
			myForm = (AdminForm) form;
			List<LabelValueBean> booklist = new ArrayList<LabelValueBean>();
			// load category list
			List<Category> blist = myAdminService.getAllCategory();
			System.out.println("This is Book Register Action" + blist.size());
			for (int i = 0; i < blist.size(); i++) {
				booklist.add(i,
						new LabelValueBean(blist.get(i).getCategoryName(),
								String.valueOf(blist.get(i).getId())));
				System.out.println("inside:" + booklist.get(i));
			}
			myForm.setCategoryChoice(booklist);
			System.out.println("CatId " + blist.get(0).getId());
			myForm.setCategoryID(blist.get(0).getId());
			request.setAttribute("myform", myForm);
			myForm.setFrmPubAddress("");
			myForm.setPublisherName("");
			myAdminService.fristLoadRegistration(myForm);
			myForm.setFrmRegFormControl(null);
			// To clean data for next time
			myForm.setAut1_init(null);
			myForm.setFrmOrgName(null);
			myForm.setFrmRegAuthor1(null);
			myForm.setFrmRegAuthor2(null);
			myForm.setFrmRegAuthor3(null);
			myForm.setFrmRegCopy(0);
			myForm.setFrmRegEdition(null);
			myForm.setFrmRegISBN(null);
			myForm.setFrmRegPage(0);
			myForm.setFrmOrgName(null);
			myForm.setFrmRegTitle(null);
			myForm.setFrmRegRemark(null);
			myForm.setFrmRegDate(null);
			myForm.setFrmRegResource(null);
			myForm.setFrmRegPublisher(null);

			return "gotoAdminRegister";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoAdminRegister";
		}

		return "gotoAdminRegister";

	}

}