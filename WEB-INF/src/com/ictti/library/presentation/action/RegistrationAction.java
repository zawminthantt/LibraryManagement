package com.ictti.library.presentation.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.business.service.UserService;

import com.ictti.library.presentation.form.UserForm;

public class RegistrationAction extends BaseAction {
	private UserService myRegisterService;

	public UserService getMyRegisterService() {
		return myRegisterService;
	}

	public void setMyRegisterService(UserService myRegisterService) {
		this.myRegisterService = myRegisterService;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		// return super.doInit(form, request, response, mapping);
		UserForm myForm = (UserForm) form;
		myRegisterService.firstLoadRegistration(myForm);
		return "gotoRegister";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		// return null;
		UserForm myForm = (UserForm) form;
		
		
		ActionErrors errors = new ActionErrors();
		if (request.getParameter("btnRegisterCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoRegister";
		}
		if (request.getParameter("btnSaveCancel") != null) {
			myForm.setFrmRegFormControl(null);
			return "gotoRegister";
		}

		if (request.getParameter("btnRegister") != null) {
			int flag = 0;
			// ActionErrors errors = new ActionErrors();
			//check user type
			if (myForm.getFrmRegUserTypeId().equals("0")) {
				errors.add("usertypeError",
						new ActionMessage("errors.usertype"));
				saveErrors(request, errors);
				flag = 1;
			}
			//check password
			if (!myForm.getFrmRegPassword().equals(
					myForm.getFrmRegConfPassword())) {
				errors.add("passwordError", new ActionMessage(
						"errors.matchPassword"));
				saveErrors(request, errors);
				flag = 1;
			}
			//check user at LDAP
			if(flag==0){
				myForm.setFrmRegLoginName(myForm.getFrmRegLoginName().trim());
            
				myRegisterService.checkLoginName(myForm);
				if(myForm.getFrmRegLoginNameError().equals("errors"))
				{
					errors.add("registerError",new ActionMessage("errors.register1"));
					saveErrors(request,errors);
					myForm.setFrmRegFormControl(null);
				}
				myRegisterService.checkUserAtLDAP(myForm);
				System.out.println("in REg action!!!!!"+ myForm.getFrmRegLoginName());
				if (myForm.getFrmRegAccountNameError().equals("errors")) {
					// System.out.println("Testing!!!"+myForm.getFrmRegEmail());
					//System.out.println("Testing!!!"+myForm.getFrmRegEmail());
					errors.add("accountError", new ActionMessage("errors.account"));
					saveErrors(request, errors);
					myForm.setFrmRegFormControl(null);
				}
				/*else if(myForm.getFrmRegLoginNameError().equals("errors"))
				{
					errors.add("registerError",new ActionMessage("errors.register"));
					saveErrors(request,errors);
					myForm.setFrmRegFormControl(null);
				}*/
				/*else
				{
					//errors.add("accountError", new ActionMessage("errors.account"));
					//saveErrors(request, errors);
					myForm.setFrmRegFormControl("data");
				}*/
				String name=myForm.getFrmRegLoginName();
				 System.out.println("Login Name in Action="+name);
				 String[] userName;
				 String splitor = "-";
				 boolean b=name.contains(splitor);
				 String id=myForm.getFrmRegUserTypeId();
				 System.out.println(id);
				 System.out.println(b);
				 if(b && myForm.getFrmRegUserTypeId().equals("9"))
				 {
					 errors.add("userTypeError",new ActionMessage("errors.misMatchUser"));
					 saveErrors(request,errors);
					 myForm.setFrmRegFormControl(null);
					 return "gotoRegister";
				 }
				 else if(!b && !myForm.getFrmRegUserTypeId().equals("9"))
				 {
					 errors.add("userTypeError",new ActionMessage("errors.misMatchUser"));
					 saveErrors(request,errors);
					 myForm.setFrmRegFormControl(null);
					 return "gotoRegister";
				 }
				 else{
					 userName=name.split("-");
					 String str="";
					 str+=userName[0];
					 System.out.println("Testing Mis Match"+str);
					 if(str.equals("ps9") && !myForm.getFrmRegUserTypeId().equals("1"))
					 {
						 errors.add("userTypeError",new ActionMessage("errors.misMatchUser"));
						 saveErrors(request,errors);
						 myForm.setFrmRegFormControl(null);
						 return "gotoRegister";
					 }
					 else if(str.equals("pn9") && !myForm.getFrmRegUserTypeId().equals("2")){
						 errors.add("userTypeError",new ActionMessage("errors.misMatchUser"));
						 saveErrors(request,errors);
						 myForm.setFrmRegFormControl(null);
						 return "gotoRegister";
					 }
				 }
				
				
				//get student code
				if(myForm.getFrmRegUserTypeId().equals("8") ||myForm.getFrmRegUserTypeId().equals("9")){
					return "gotoRegister";
				}
				else{
				String courseCode=myForm.getFrmRegLoginName();
				 String[] temp;
				 String delimiter = "-";
				 temp = courseCode.split(delimiter);
				 String st="";
				// for(int i =0; i < temp.length ; i++)					  
				      st+=temp[0];
				 System.out.println("course code string: " + st);
				 myRegisterService.checkExpireDate(st,myForm);
				 Date currentDate=new Date();
				 if(currentDate.compareTo(myForm.getFrmEndDate())>=0){
					 //error
					 errors.add("expiredError",new ActionMessage("errors.expired"));
					 saveErrors(request,errors);
					 myForm.setFrmRegFormControl(null);
					 return "gotoRegister";
				 }
				/* String name=myForm.getFrmRegLoginName();
				 System.out.println("Login Name in Action="+name);
				 String[] userName;
				 String splitor = "-";
				 boolean b=name.contains(splitor);
				 if(b && myForm.getFrmRegUserType().equals("9"))
				 {
					 errors.add("userTypeError",new ActionMessage("errors.misMatchUser"));
					 saveErrors(request,errors);
					 myForm.setFrmRegFormControl(null);
				 }
				 return "gotoRegister";*/
				}
			}			
		}//end of btnRegister
		if (request.getParameter("btnSave") != null) {
			myRegisterService.checkLoginName(myForm);
			if(myForm.getFrmRegLoginNameError().equals("errors"))
			{
				errors.add("registerError",new ActionMessage("errors.register1"));
				saveErrors(request,errors);
				myForm.setFrmRegFormControl(null);
			}else{
				if(myForm.getFrmRegUserTypeId().equals("8")||myForm.getFrmRegUserTypeId().equals("9")){
					myRegisterService.saveNewUser(myForm);
				    myRegisterService.prepareForMail(myForm);
					
				}else{
				String courseCode=myForm.getFrmRegLoginName();
				String[] temp;
				 String delimiter = "-";
				 temp = courseCode.split(delimiter);
				 String st="";
				 st+=temp[0];
				 
				 myRegisterService.checkExpireDate(st,myForm);
				 myRegisterService.saveNewUser(myForm);
			     myRegisterService.prepareForMail(myForm);
				}
				return "gotoLogin";
			}
			}
			/*if(myForm.getFrmRegUserTypeId().equals("8")||myForm.getFrmRegUserTypeId().equals("9")){
				myRegisterService.saveNewUser(myForm);
			    myRegisterService.prepareForMail(myForm);
				
			}else{
			String courseCode=myForm.getFrmRegLoginName();
			String[] temp;
			 String delimiter = "-";
			 temp = courseCode.split(delimiter);
			 String st="";
			 st+=temp[0];
			 
			 myRegisterService.checkExpireDate(st,myForm);
			 myRegisterService.saveNewUser(myForm);
		     myRegisterService.prepareForMail(myForm);
			}
			return "gotoLogin";
		}*/
	    return "gotoRegister";
	}	
}
