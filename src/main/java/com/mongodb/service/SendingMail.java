package com.mongodb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendingMail {
	@Autowired
	private JavaMailSender mailSender;
	
	public Boolean sendMailByMe(String to,String sub,String msg) throws MessagingException {
		boolean f=false;
		MimeMessage mess=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mess,true, "UTF-8");
		SimpleMailMessage message=new SimpleMailMessage();
		String[] bcc={"crickonfire@gmail.com","ajaysinghrajput352@gmail.com"};
		try {
			helper.setFrom("rajputajay207245@gmail.com");
		//	helper.setTo(to);
			helper.setText(msg,true);
			helper.setSubject(sub);
			helper.setBcc(bcc);
			mailSender.send(mess);
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return f;
	}
}
