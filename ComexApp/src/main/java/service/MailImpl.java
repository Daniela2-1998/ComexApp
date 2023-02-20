package service;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniela
 */
public class MailImpl {
    
    
    public void envioDeMensajes(String correoDeOrigen, String correoDeDestino, 
            String asunto, String mensaje, String contraseña16Digitos) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correoDeOrigen);
            p.setProperty("mail.smtp.auth", "true");
            
            Session s = Session.getDefaultInstance(p);
            
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress(correoDeOrigen));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = s.getTransport("smtp");
            t.connect(correoDeOrigen, contraseña16Digitos);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado");

        } catch (MessagingException e) {
            System.err.println("No es posible mandar mail " + e);
        }
    }
    
    public void envioDeMensajesConAdjunto(String correoDeOrigen, String correoDeDestino, 
            String asunto, String mensaje, String contraseña16Digitos) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", correoDeOrigen);
            p.setProperty("mail.smtp.auth", "true");
            
            Session s = Session.getDefaultInstance(p);
            
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource("")));
            adjunto.setFileName("");
            // FALTA
            
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress(correoDeOrigen));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDeDestino));
            message.setSubject(asunto);
            message.setText(mensaje);

            Transport t = s.getTransport("smtp");
            t.connect(correoDeOrigen, contraseña16Digitos);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            JOptionPane.showMessageDialog(null, "Mensaje enviado");

        } catch (MessagingException e) {
            System.err.println("No es posible mandar mail " + e);
        }
    }
    
    
    
    
}
