package com.ipartek.badaboom.beans;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class Mailer {

	public Mailer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void sender(String address, String code){
	      
	      String to = address;
	     
	      String from = "comicsbadaboom@gmail.com";
	      final String username = "comicsbadaboom";
	      final String password = "wen1wen2";

	     
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Recuperacion de contraseña");
	         String resetAddress = "192.168.1.35:8080/Badaboom/";
	         // Now set the actual message
	         String msg ="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>"
	         		+ "<html xmlns='http://www.w3.org/1999/xhtml'><head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />"
	         		+ "<title>Badaboom comics: Recuperacion de contraseña</title><meta name='viewport' content='width=device-width, initial-scale=1.0'/>"
	         		+ "</head><body><table style=' border-collapse: collapse;border-spacing: 0;'><tr><td style='font-size: 18px'>Hola, Jon</td></tr>"
	         		+ "<tr><td style='font-size:15px'>Alguien ha solicitado recientemente un cambio de contraseña para tu cuenta de <span style='color: #a33838'>"
	         		+ "Badaboom comics</span>. Si fuiste tú, puedes definir una contraseña nueva Introduciendo el siguiente código <a href='" + resetAddress + "'>"
	         		+ "aquí</a>:</td></tr><tr><td>" + code + "</td></tr><tr><td>Si no quieres cambiar tu contraseña o no has realizado esta "
	         		+ "solicitud, haz caso omiso de este mensaje y bórralo.Para mantener a salvo tu cuenta, "
	         		+ "te rogamos que no reenvíes este mensaje a nadie.</td></tr></table></body>";
	         message.setContent(msg, "text/html");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }
}
