/**
 * 
 */
package co.edu.udea.iw.bl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import co.edu.udea.iw.exception.ExceptionHandler;
/**
 * Send an email through gmail  
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class SendMailTLS {
	/**
	 * Send a email given a email and message
	 * @param correo email to send a message
	 * @param content message to send
	 * @throws ExceptionHandler manage the error occurred sending an email
	 */
	public void sendEmail(String correo, String content) throws ExceptionHandler{
		final String username = "estudianteingwebudea@gmail.com";
		final String password = "ingweb2017";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("estudianteingwebudea@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,	InternetAddress.parse(correo));
			message.setSubject("Respuesta Solicitud");
			message.setContent(content, "text/html; charset=utf-8");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new ExceptionHandler("CANNOT SEND THE MESSAGE",e);
		}
	}
}
