package com.ictti.library.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MailSend {
	private static Log log = LogFactory.getLog(MailSend.class);
	String strJDBCURL = "jdbc:mysql://localhost/library";
	String strJDBCUser = "root";
	String strJDBCPassword = "root";
	String strJDBCDriver = "com.mysql.jdbc.Driver";
	String strSMTPHost;
	String strFrom;
	String StrFromName;
	static final String SMTP_HOST = "mail.smtp.host";
	final String emailFromAddress = "admin@ictti.site";
	final String[] emailToAddresses = {};

	/**
	 * Constructor
	 * 
	 * @param strSMTPHost
	 * @param strFrom
	 * @param strFromName
	 */
	public MailSend(String strSMTPHost, String strFrom, String strFromName) {
		this.strSMTPHost = strSMTPHost;
		this.strFrom = strFrom;
		this.StrFromName = strFromName;
	}

	public MailSend() {};

	
	public String readText(String strFilePath) {
		StringBuffer strMailText = new StringBuffer();
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(strFilePath));
			String s = "";
			while ((s= bf.readLine()) != null) {
				strMailText.append(s + System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return strMailText.toString();
	}

	/**
	 * Send mail with specified recipient, text and subject
	 * 
	 * @param strEmail
	 * @param strSubject
	 * @param strText
	 * @return true if no error
	 */
	public int sendMailReservation(List<Object> strEmail, String strSubject,
			String strText) {
		int iResult = 0;
		try {
			Properties props = System.getProperties();
			props.put(SMTP_HOST, getStrSMTPHost());
			Session session = Session.getDefaultInstance(props, null);
			MimeMessage mimeMessage = new MimeMessage(session);
			// set mail from;
			mimeMessage.setFrom(new InternetAddress(getStrFrom(),
					getStrFromName()));
			// set RCPT to;
			InternetAddress addressFrom = new InternetAddress(emailFromAddress);
			mimeMessage.setFrom(addressFrom);
			InternetAddress[] addressTo = new InternetAddress[strEmail.size()];
			for (int i = 0; i < strEmail.size(); i++) {
				addressTo[i] = new InternetAddress(strEmail.get(i).toString());
			}
			mimeMessage.setRecipients(Message.RecipientType.TO, addressTo);
			// set subject
			mimeMessage.setSubject(strSubject);
			// set content
			mimeMessage.setText(strText);
			// set date
			mimeMessage.setSentDate(new Date());
			// send mail
			Transport.send(mimeMessage);
			if (log.isInfoEnabled()) {
				log.info("Message sent successfully.");
			}
		} catch (SendFailedException e) {
			iResult = 8;
			e.printStackTrace();
		} catch (Exception e) {
			iResult = 9;
			e.printStackTrace();
		}
		return iResult;
	}

	/**
	 * Insert a log into email log table
	 * 
	 * @param email_id
	 * @param remind_date
	 * @param user_id
	 * @param book_loan_id
	 */
	public void insertEmailLog(Integer userId, Integer bookloanId) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(strJDBCDriver);
			con = DriverManager.getConnection(strJDBCURL, strJDBCUser,strJDBCPassword);
			stmt = con.createStatement();
			Calendar today = Calendar.getInstance();
			String strDate = today.get(Calendar.YEAR) + "/"
					+ Integer.toString(today.get(Calendar.MONTH) + 1) + "/"
					+ today.get(Calendar.DAY_OF_MONTH);
			String strSQL = "insert into email_log values(null, " + "now()" +",1" + "," + bookloanId + "," + userId + ")";
			System.out.println("query :" + strSQL);
			int rowCount = stmt.executeUpdate(strSQL);
			if (log.isInfoEnabled()) {
				log.info("Row affected :" + rowCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public String getStrFrom() {
		return strFrom;
	}

	public void setStrFrom(String strFrom) {
		this.strFrom = strFrom;
	}

	public String getStrFromName() {
		return StrFromName;
	}

	public void setStrFromName(String strFromName) {
		StrFromName = strFromName;
	}

	public String getStrSMTPHost() {
		return strSMTPHost;
	}

	public void setStrSMTPHost(String strSMTPHost) {
		this.strSMTPHost = strSMTPHost;
	}
}

