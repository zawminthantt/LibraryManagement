package com.ictti.library.presentation.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.ReserveService;
import com.ictti.library.presentation.form.UserForm;

public class ReserveAction extends BaseAction {
	ReserveService myReserveService;
	public ReserveService getMyReserveService() {
		return myReserveService;
	}

	public void setMyReserveService(ReserveService myReserveService) {
		this.myReserveService = myReserveService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		//ReserveForm my=(ReserveForm)form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		UserForm myForm=(UserForm)form;
		myForm.setFrmCallNumberFlag(null);
		System.out.println("in Action!!!!"+myForm.getFrmDetailBookId());
		myReserveService.getAllBookInfo(myForm);
		//myReserveService.retrievePhoto(myForm);
		//myReserveService.saveUploadPhoto(myForm);
		/*try{
			//String photoPath=getServlet().getServletContext().getRealPath("")+"/images/"+myForm.getFrmPhoto().getPhotoName();
			String photoPath=getServlet().getServletContext().getRealPath("")+"\\images\\"+"5.jpg";
			BufferedOutputStream outStream =new BufferedOutputStream(new FileOutputStream(photoPath));
			InputStream in=myForm.getFrmPhoto().getPhotoData().getBinaryStream();
			//InputStream in=myForm.getFrmPhoto().getPhotoData().getBinaryStream();
			byte[] buffer=new byte[1000];
			int n=0;
			while((n=in.read(buffer))!=-1){
				outStream.write(buffer,0,n);
			}
			in.close();
			outStream.close();
		}catch(Exception e){
			e.printStackTrace();
		}*/
		//myForm.setFrmViewPhoto("images/"+myForm.getFrmPhoto().getPhotoName());
		myForm.setFrmViewPhoto("images/"+myForm.getFrmDetailBookId()+".jpg");
		//return "gotoDownload";
		return "gotoReserveDetail";
		//return "gotoUploadPhoto";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		ActionErrors errors=new ActionErrors();
		HttpSession session=request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		UserForm myForm = (UserForm) form;
		myForm.setFrmCallNumberFlag(null);
		myForm.setFrmreserveFlag(null);
		UserForm loginForm = (UserForm) request.getSession().getAttribute("LoginFormBean");
		myForm.setLoginUser(loginForm.getLoginUser());
		if(request.getParameter("btnReserve")!=null)
		{
			myReserveService.checkLoginUserId(myForm);
			if(myForm.getFrmUserFlag()!=null)
			{
				
				errors.add("reserveError",
						new ActionMessage("errors.reserve"));
				saveErrors(request, errors);
				
				System.out.println("Aleardy Reserved");
				return "gotoReserveDetail";
				
			}
			else {
				myReserveService.getAvailableDate(myForm);
				if(myForm.getFrmreserveFlag()!=null){
					errors.add("reserveError2",
							new ActionMessage("errors.reserve2"));
					saveErrors(request, errors);
					
					System.out.println("This book is reserved by other member!!!!");
					return "gotoReserveDetail";
				}
				if(myForm.getFrmCallNumberFlag()!=null){

					errors.add("reserveError1",
							new ActionMessage("errors.reserve1"));
					saveErrors(request, errors);
					
					System.out.println("This book exits at Library");
					return "gotoReserveDetail";
				}
				return "gotoReserveConfirm";
			}
	}
	//Photo Upload Action
		/*if (request.getParameter("btnUpload") != null) {
			//UserForm myForm = (UserForm) form;
			myReserveService.saveUploadPhoto(myForm);
			return "gotoReserve";
		}*/
	if(request.getParameter("btnSave")!=null){
		myReserveService.saveReserveInfo(myForm);
		myReserveService.changeCallNumberStatus(myForm);
		myReserveService.prepareForMail(myForm);
		//myReserveService.sendReservationMail(myForm);
		return "gotoHome";
	}
		return "gotoHome";  
}
}