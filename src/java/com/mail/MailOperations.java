/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailOperations {
	
	private static Session getSession() {
		
		Properties pro=new Properties();
		
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", "true");
		pro.put("mail.smtp.host","smtp.gmail.com");
		pro.put("mail.smtp.port", "587");
		
		Session sess=Session.getInstance(pro, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ekutuphane.servis@gmail.com", "yaz1l1mPr0je2021");
			}
			
		});
		
		return sess;
	}
	
	private static Message prepareVerifyMessage(Session session, String recepient, int verifyCode) throws Exception {
			
		Message mes=new MimeMessage(session);
		
		mes.setFrom(new InternetAddress("ekutuphane.servis@gmail.com"));
		mes.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
		
		mes.setSubject("E-Posta Doğrulama");
		mes.setText("Doğrulama kodunuz: "+verifyCode);
		
		return mes;
	}
	
	public static void sendVerifyMail(String USER_MAIL, int verifyCode) throws Exception {
		
		Session sess=getSession();
		
		Message message=prepareVerifyMessage(sess, USER_MAIL, verifyCode);
		
		Transport.send(message);
	}
}
