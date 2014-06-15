package com.ictti.library.presentation.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ictti.library.business.service.AmazonService;
import com.ictti.library.presentation.form.AmazonBeanForm;
import com.ictti.library.util.ImageValidator;
import com.ictti.library.util.SignedRequestsHelper;

public class AmazonAction extends BaseAction {
	private AmazonService myAmazonService;

	public AmazonService getMyAmazonService() {
		return myAmazonService;
	}

	public void setMyAmazonService(AmazonService myAmazonService) {
		this.myAmazonService = myAmazonService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		// Session Control Here
		AmazonBeanForm myForm = (AmazonBeanForm) form;
		List<LabelValueBean> booklist = new ArrayList<LabelValueBean>();
		// load category list
		List<Category> blist = myAmazonService.getAllCategory();
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
		myForm.setFrmSearchIsbn(null);
		myForm.setFrmFormControl(null);
		myForm.setFrmErrorMsg(null);
		return "gotoAmazon";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// Session Control Here
		// Setting the Required Host IP and Port
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		AmazonBeanForm myForm = (AmazonBeanForm) form;
		ActionErrors errors = new ActionErrors();

		System.setProperty("proxySet", WebConstants.PROXY_SET);
		System.setProperty("proxyHost", WebConstants.PROXY_HOST);
		System.setProperty("proxyPort", WebConstants.PROXY_PORT);
		// Generating the key
		SignedRequestsHelper srh = SignedRequestsHelper.getInstance(
				WebConstants.END_POINT, WebConstants.KEY_ID,
				WebConstants.SECRET_KEY);

		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", WebConstants.SERVICE);
		params.put("Version", WebConstants.VERSION);
		params.put("Operation", WebConstants.OPERATION);
		params.put("ItemId", myForm.getFrmSearchIsbn().trim());
		params.put("ResponseGroup", WebConstants.RESPONSE_GROUP);
		String baseURL = srh.sign(params);
		myForm.setBaseURL(baseURL);
		myAmazonService.getAmazonInformation(myForm);
		if (request.getParameter("btnAmazon") != null) {

			myForm = (AmazonBeanForm) form;
			List<LabelValueBean> booklist = new ArrayList<LabelValueBean>();
			// load category list
			List<Category> blist = myAmazonService.getAllCategory();
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

		}
		if (request.getParameter("btnRegisterCancel") != null) {

			return "gotoAmazon";

		}
		if (request.getParameter("btnRegister") != null) {
			// to check book's edition
			if (myForm.getFrmRegEdition().equals("")) {
				errors.add("EditionError", new ActionMessage("errors.Edition"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// For Category and SubCategory action errors
			String catId = myForm.getCategoryId();
			String subcatId = myForm.getSubCategoryId();
			if ((catId.equals("6")) && (subcatId.equals("21"))) {
				errors.add("CategoryError",
						new ActionMessage("errors.Category"));
				saveErrors(request, errors);
				return "gotoAmazon";

			}
			if ((catId.equals("6") || (subcatId.equals("21")))) {
				errors.add("CategoryError",
						new ActionMessage("errors.Category"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// to check number of copies no type
			if (myForm.getFrmRegCopy() == 0) {
				errors.add("CopyError", new ActionMessage("errors.Copy"));
				saveErrors(request, errors);
				return "gotoAmazon";

			}
			// to check number of copies for minus
			if (myForm.getFrmRegCopy() < 0) {
				errors.add("negativecopy", new ActionMessage("errors.Nagative"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// to check number of copies for greater than 100
			if (myForm.getFrmRegCopy() > 100) {
				errors.add("copymax", new ActionMessage("errors.maxcopy"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}

			// to check remark no type
			if (myForm.getFrmRegRemark().equals("")) {
				errors.add("RemarkError", new ActionMessage("errors.Remark"));
				saveErrors(request, errors);
				return "gotoAmazon";

			}

			// to check ISBN must be unique
			BookList book = this.myAmazonService.getByBookISBN(myForm
					.getFrmRegISBN());
			if (book != null) {
				System.out.println("This is action error for ISBN");

				errors.add("registerError",
						new ActionMessage("errors.register"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// Check no upload Photo
			if (myForm.getFrmUploadFile().getFileName() == ("")) {
				errors.add("NoPhoto", new ActionMessage("errors.NoPhoto"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// Check wrong File type for Photo
			String image_type = myForm.getFrmUploadFile().getFileName();
			System.out.println("Image Type" + image_type);
			ImageValidator valid = new ImageValidator();
			boolean flag = valid.validate(image_type);
			if (!flag) {
				errors.add("PhotoTypeWrong", new ActionMessage(
						"errors.PhotoTypeWrong"));
				saveErrors(request, errors);
				return "gotoAmazon";
			}
			// check large photo's size
			if (myForm.getFrmUploadFile().getFileName() != null) {
				String path = (getServlet().getServletContext().getRealPath("") + "/images/");
				myForm.setFrmPhotoPath(path);
				int size = myForm.getFrmUploadFile().getFileSize();
				if ((size / 1024) > 64) {
					errors.add("PhotoError", new ActionMessage(
							"errors.LargePhoto"));
					saveErrors(request, errors);
					return "gotoAmazon";
				}

				myAmazonService.saveNewAuthor(myForm);// Save for book author
				myAmazonService.savePublisher(myForm);// Save for publisher
				myAmazonService.saveNewBook(myForm);// Save for book list
				myAmazonService.saveNewPhoto(myForm);// Save for photo
				myForm.setFrmFormControl(null);
				return "gotoAmazonSuccess";

			}

		}
		return "gotoAmazon";
	}
}