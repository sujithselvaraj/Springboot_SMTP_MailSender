package com.sujith.qrApp;

import java.io.IOException;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//
@Controller
public class SendEmailcontroller {
	
	@Autowired
	SpringbootMailSenderSmtpApplication sendingEmailApplication;

	@RequestMapping(value="/sendemail")
	public String send() throws AddressException, MessagingException, IOException {
	   //sendEmail();
		sendingEmailApplication.sendEmailWithAttachment();
		sendingEmailApplication.sendEmail();
	   return "Email sent successfully";   
	}
}