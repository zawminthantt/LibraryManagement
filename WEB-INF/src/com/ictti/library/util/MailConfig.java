package com.ictti.library.util;

import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailConfig {
	private static final String SMTP_HOST_NAME = "192.168.48.13";

	// this function will send to one person
	public void sendToOne(String recipient, String subject, String message,
			String from) throws MessagingException {
		boolean debug = false;
		// Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		Session session = Session.getDefaultInstance(props);
		session.setDebug(debug);
		// create a message
		Message msg = new MimeMessage(session);
		// set the from and to address
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
				recipient));
		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}
}
