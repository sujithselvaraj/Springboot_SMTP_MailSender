package com.sujith.qrApp;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMailSenderSmtpApplication {
	
@Autowired
private JavaMailSender javaMailSender;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootMailSenderSmtpApplication.class, args);
	}
	
	
	

	void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sujithselva2020@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

	}

	void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("sujithselva2020@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

		// hardcoded a file path
        FileSystemResource file = new FileSystemResource(new File("/Users/sujiths/Desktop/sujith.jpeg"));

        helper.addAttachment("sujith.jpeg", file);

        javaMailSender.send(msg);

    }	

}
