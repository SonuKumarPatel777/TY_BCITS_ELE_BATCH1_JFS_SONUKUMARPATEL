package com.bcits.discomusecase.emailsender;

import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.bcits.discomusecase.beans.CurrentBillBean;

public class MyMailGenerator {
	
	public boolean sendMail(CurrentBillBean currentBill,String email) {

		System.out.println("Sending Mail...");

		final String username = "sonu.patel112114@gmail.com";
		final String password = "sonu@77718";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dueDate = dateFormat.format(currentBill.getDueDate());

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Testing Gmail TLS");
			message.setText("Dear Consumer," + "\n\n This  Month you have Consumed   " + currentBill.getConsumption()
					+ "\n\n So the total Bill will be rupees  " + currentBill.getBillAmount()
					+ "\n\n The Due Date will be " + dueDate + "\n\n" + "\n\n" + "Statmented On "
					+ "\n\nHappy To Help");

			Transport.send(message);

			System.out.println("send");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
       return false;
	}//end of sendMail()

}//end of class
