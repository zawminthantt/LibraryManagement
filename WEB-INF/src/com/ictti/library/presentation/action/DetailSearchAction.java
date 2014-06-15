package com.ictti.library.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.ictti.library.business.service.SearchDetailService;
import com.ictti.library.presentation.form.SearchDetailForm;

public class DetailSearchAction extends BaseAction {
	private SearchDetailService myCategoryService;

	public SearchDetailService getMyCategoryService() {
		return myCategoryService;
	}

	public void setMyCategoryService(SearchDetailService myCategoryService) {
		this.myCategoryService = myCategoryService;
	}

	//Detail Link For Inner Search
	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		//return super.doInit(form, request, response, mapping);
		//For Detail Link 
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		SearchDetailForm myForm = (SearchDetailForm) form;
		myForm.setFrmBookTitle("");
		myForm.setFrmAuthorName("");
		if(myForm.getFrmControl().equals("1"))
		{
			myCategoryService.detailForSearch(myForm);
			System.out.println("Here for Detail show");
			//return "gotoDisplay";
			
		myCategoryService.retrievePhoto(myForm);
		try{
			String photoPath=getServlet().getServletContext().getRealPath("")+"/images/"+myForm.getFrmPhoto().getPhotoName();
			BufferedOutputStream outStream =new BufferedOutputStream(new FileOutputStream(photoPath));
			InputStream in=myForm.getFrmPhoto().getPhotoData().getBinaryStream();
			byte[] buffer=new byte[1000];
			int n=0;
			while((n=in.read(buffer))!=-1){
				outStream.write(buffer,0,n);
			}
			in.close();
			outStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
			//myForm.setFrmViewPhoto("images/"+myForm.getFrmDetailBookId()+".jpg");
		myForm.setFrmViewPhoto("images/"+myForm.getFrmPhoto().getPhotoName());
		
	System.out.println("This is photo!");
	}
		return "gotoDisplay";
			
	}

	//Ok button For Inner Search
	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception 
		{
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		// TODO Auto-generated method stub
		if (request.getParameter("btnOk") != null) 
		{
			return "gotoBack";
		}
		
		return "gotoBack";
		}
	

}
