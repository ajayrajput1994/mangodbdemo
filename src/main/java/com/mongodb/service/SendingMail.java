package com.mongodb.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.mongodb.config.ConfigJavaMail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class SendingMail {
	@Autowired
	private ConfigJavaMail sender;
	@Autowired
	private  AmazonSimpleEmailService amazonSimpleEmailService;
	
	public Boolean sendMailByMe(String to,String sub,String msg) throws MessagingException {
		boolean f=false;
		JavaMailSender mailSender=sender.getJavaMailSender();
		MimeMessage mess=mailSender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(mess,true, "UTF-8");
		//SimpleMailMessage message=new SimpleMailMessage();
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
	
	public void sendAWSMail(SimpleMailMessage simpleMail) {
		Destination destination=new Destination();
		destination.setToAddresses(Arrays.asList(simpleMail.getTo()));
		
		Content content=new Content();
		content.setData(simpleMail.getText());
		
		Body body=new Body();
		body.setHtml(content);
		
		Content subject=new Content();
		subject.setData(simpleMail.getSubject());
		
		Message msg=new Message();
		msg.setBody(body);
		msg.setSubject(subject);
		
		SendEmailRequest emailRequest=new SendEmailRequest();
		emailRequest.setDestination(destination);
		emailRequest.setMessage(msg);
		emailRequest.setSource(simpleMail.getFrom());
		amazonSimpleEmailService.sendEmail(emailRequest);
	}
}
