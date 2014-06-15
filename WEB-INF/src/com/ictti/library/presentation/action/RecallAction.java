

package com.ictti.library.presentation.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.ictti.library.util.MailSend;
import com.ictti.library.business.entity.ViewRecall;
import com.ictti.library.business.service.RecallService;
import com.ictti.library.presentation.form.RecallForm;

public class RecallAction extends BaseAction {
	/** Get message for mail */
	private static final String MAIL_MAILFILE = "mail_mailfile";
	private static final String MAIL_FROMNAME = "mail_fromname";
	private static final String MAIL_FROM = "mail_from";
	private static final String MAIL_SMTP = "mail_smtp";
	private static final String KEY_MESSAGE_MAILTITLE = "message.reserve.mailtitle";
	private static final String KEY_MESSAGE_MAILSUCCESS = "message.mail.success";
	// target of DI
	private RecallService myRecallService;

	public RecallService getMyRecallService() {
		return myRecallService;
	}

	public void setMyRecallService(RecallService myRecallService) {
		this.myRecallService = myRecallService;
	}

	/**
	 * @see BaseAction#doExecute
	 */
	public static boolean isDate(String a_strDate) {
		boolean bl = false;
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);
		sdf.applyPattern("yyyy/MM/dd");
		
		try {
			Date date = sdf.parse(a_strDate);
			bl = true;
		} catch (ParseException e) {
			
			bl = false;
		}
		return bl;
	}

	public int sendMail(List<ViewRecall> vrlist, List<Object> emaillist,
			String a_strSMTP, String a_strFrom, String a_strFromName,
			String a_strMailContext, String a_strTitle) {
		// generate mail class to send SMTP server
		System.out.println("a_strSMTP" + a_strSMTP + "a_strFrom" + a_strFrom
				+ "a_strFromName" + a_strFromName);
		MailSend myMail = new MailSend(a_strSMTP, a_strFrom, a_strFromName);
		// read mail text from a file
		String strText = myMail.readText(a_strMailContext);
		System.out.println("action ...." + strText);
		return myMail.sendMailReservation(emaillist, a_strTitle, strText);
	}


/*
	protected String doInit(ActionForm form, HttpServletRequest request,
			ActionMapping mapping) {
		// get all Accession code from DB
		RecallForm myform = (RecallForm) form;
		//myRecallService.firstLoadRecall(myform);
		List list = myRecallService.findAll();
		// System.out.println("recall :" + list.size());
		
		myform.setListViewrecall(list);
		myform.setSelectedItems(null);
		// System.out.println(myform.getListViewrecall().size());
		request.setAttribute("message", null);
		request.getSession().setAttribute("clean",null);
		return "gotoRecall";
	}*/

	protected boolean isRequiredLogin(HttpServletRequest request) {
		return true;
	}

	@Override
	protected String doInit(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping) {
		// TODO Auto-generated method stub
		RecallForm form1=(RecallForm) form;
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		
		request.setAttribute("message", null);
		request.getSession().setAttribute("clean",null);
		form1.setSelectedItems(null);
		return "gotoRecall";
	}

	@Override
	protected String doExecute(ActionForm form, HttpServletRequest request,
			HttpServletResponse response, ActionMapping mapping)
			throws Exception {
		// TODO Auto-generated method stub
		
		RecallForm form1 = (RecallForm) form;
		
		HttpSession session = request.getSession(false);
		if (session.getAttribute("id") == null) {
			return "gotoLogin";
		}
		if (null != request.getParameter("btnSearch")) {
		if(form1.getDate().equals(""))
		{
			ActionErrors errors = new ActionErrors();
			errors.add("nowritetitle", new ActionMessage(
					"errors.nowritetitle"));
			saveErrors(request, errors);
			
			return "gotoRecall";
		}
		}	
		
		List<ViewRecall> vrlist = form1.getListViewrecall();
		
		List<Object> emaillist = new ArrayList<Object>();
		List<Object> useridlist = new ArrayList<Object>();
		List<Object> bookloanidlist = new ArrayList<Object>();
		System.out.println(emaillist.size());
		String mail = "";
		String userid = "";
		String bookloanid = "";
		/*if(request.getParameter("date").compareTo("")==0 ){
			String date = request.getParameter("date");
			ActionErrors errors = new ActionErrors();
			errors.add("date", new ActionMessage("errors.date"));
			saveErrors(request, errors);
			request.getSession().setAttribute("message", null);
			request.getSession().setAttribute("rlist", null);
			return "gotoRecall";
	}*/
		if (null != request.getParameter("btnSend")) {
			if (form1.getSelectedItems() == null) {
				ActionErrors errors = new ActionErrors();
				errors.add("noselectedItem", new ActionMessage(
						"errors.noselectedItem"));
				saveErrors(request, errors);
				
				return "gotoRecall";

			}
			
				
			int i = 0;
			for (String str : form1.getSelectedItems()) {
				System.out.println("Str from Form ;" + str);
				int count = 0;
				int p = 0;
				int len = str.length();
				while (count < 3) {
					if (str.charAt(p) == ' ') {
						if (count == 0) {
							
							mail = str.substring(0, p);
							str = str.substring(p + 1, len);
							p = 0;
							count++;
						} else if (count == 1) {
							userid = str.substring(0, p);
							str = str.substring(p + 1, str.length());
							p = 0;
							count++;
						}
					}
					
					if (count == 2) {
						bookloanid = str.substring(0, str.length());
						count++;
						p = 0;
					
					}
					p++;
					
				}
				emaillist.add(i, mail);
				useridlist.add(i, userid);
				bookloanidlist.add(i, bookloanid);
				i++;
			}
			
			for (int j = 0; j < emaillist.size(); j++) {
				System.out.println(emaillist.get(j));
			}
			String strSmtp = mapping.getProperty(MAIL_SMTP);
			String strFrom = mapping.getProperty(MAIL_FROM);
			String strFromName = mapping.getProperty(MAIL_FROMNAME);
			String strMailContext = mapping.getProperty(MAIL_MAILFILE);
			String strTitle = getResources(request).getMessage(KEY_MESSAGE_MAILTITLE);
			
			int userId = 0;
			int bookloanId = 0;
			int iResult = sendMail(vrlist, emaillist, strSmtp, strFrom,strFromName, strMailContext, strTitle);
			
			MailSend myMail = new MailSend();
			
			if (iResult == 0) {
				for (int k = 0; k < useridlist.size(); k++) {
					userId = Integer.parseInt(useridlist.get(k).toString());
					bookloanId = Integer.parseInt(bookloanidlist.get(k).toString());
					myMail.insertEmailLog(userId, bookloanId);
				}
				
			
			} else {
			}
			
			
			Date d = (Date) session.getAttribute("date");
			if(d==null){
				d = new Date();
			}
			
			List<ViewRecall> list = myRecallService.findAll(d);
			form1.setSelectedItems(null);
			request.getSession().setAttribute("message", "message");
			request.getSession().setAttribute("rlist", list);
			return "gotoRecall1";
		}
		
		
		String d = (String) request.getParameter("date");
		/*SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);
		sdf.applyPattern("yyyy/MM/dd");*/
		Date date = new Date();
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		try {
			date=df.parse(d);
		} catch (ParseException e) {
			System.out.println("Error");
		}
		// get form
		if (request.getParameter("btnSearch")!=null){
		RecallForm myform = (RecallForm) form;
		myform.setDueDate(date);
		List<ViewRecall> list = myRecallService.findAll(date);		
		myform.setListViewrecall(list);
		session.setAttribute("date", date);
		
		request.getSession().setAttribute("rlist", list);
		request.getSession().setAttribute("message", null);
		Calendar cal = Calendar.getInstance();
		request.getSession().setAttribute("clean","clean");}
		return "gotoRecall";
	
		
	}

	
}

