package service;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Daniela
 */
public class EnvioMailImpl {
    
    private String userName = "comexappj@gmail.com";

	
	public void enviarEmail(boolean envioHtml, String usuarioMail, String contraseña, 
                String listaDestinatarios, String nombreRemitente, String asunto, 
                String textoMail) {
	// Olhe as configurações smtp do seu email
	try {
		Properties properties = new Properties();
		properties.put("mail.smtp.ssl.trust", "*"); // faz o projeto autenticar com segurança ssl
		properties.put("mail.smtp.auth", "true"); // autorização
		properties.put("mail.smtp.starttls", "true");// autenticação
		properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do gmail do Google
		properties.put("mail.smtp.port", "465"); // porta do servidor
		properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser conectada pelo socket
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de conexão// ao SMTP
			
		//session do javamail depedencia colocada no pom.xml
        Session session = Session.getInstance(properties, new Authenticator() {
        	@Override
        	protected PasswordAuthentication getPasswordAuthentication() {
        		
        		return new PasswordAuthentication(usuarioMail, contraseña);
        	}
		});
        //array de adrees pode mandar pra varios email users , pra quem vai ser enviado aqui
        Address[] toUser = InternetAddress.parse(listaDestinatarios); 
		
        Message message = new MimeMessage(session); //session do usuario que vai enviar os email
        message.setFrom(new InternetAddress(usuarioMail, nombreRemitente)); //quem está enviando o email pode mudar o nome ao lado pra empresa ou algo que está enviando
        message.setRecipients(Message.RecipientType.TO, toUser); //email de destino os array de email
        message.setSubject(asunto); //assunto do email titulo qnd envia
        
        if (envioHtml) { //se enviar com html
        	message.setContent(textoMail, "text/html; charset=utf-8");
        }else {
        message.setText(textoMail);//texto do envio do email
        }
        
        Transport.send(message); //objeto de mensagem pra ser enviado
        
       
        
	} catch (Exception e) {
		e.printStackTrace();
	}
        JOptionPane.showMessageDialog(null, "Mensaje enviado", "Envio de mails", 0);

}
	
	public void enviarEmailAnexo(boolean envioHtml, String usuarioMail, String contraseña, 
                String listaDestinatarios, String nombreRemitente, String asunto, 
                String textoMail, String nombreAdjunto, String espacio1, 
            String espacio2)  throws Exception{
		// Olhe as configurações smtp do seu email
		
			Properties properties = new Properties();
			properties.put("mail.smtp.ssl.trust", "*"); // faz o projeto autenticar com segurança ssl
			properties.put("mail.smtp.auth", "true"); // autorização
			properties.put("mail.smtp.starttls", "true");// autenticação
			properties.put("mail.smtp.host", "smtp.gmail.com");// servidor do gmail do Google
			properties.put("mail.smtp.port", "465"); // porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465");// Expecifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// classe socket de conexão// ao SMTP
				
			//session do javamail depedencia colocada no pom.xml
	        Session session = Session.getInstance(properties, new Authenticator() {
	        	@Override
	        	protected PasswordAuthentication getPasswordAuthentication() {
	        		
	        		return new PasswordAuthentication(usuarioMail, contraseña);
	        	}
			});
	        //array de adrees pode mandar pra varios email users , pra quem vai ser enviado aqui
	        Address[] toUser = InternetAddress.parse(listaDestinatarios); 
			
	        Message message = new MimeMessage(session); //session do usuario que vai enviar os email
	        message.setFrom(new InternetAddress(usuarioMail, nombreRemitente )); //quem está enviando o email pode mudar o nome ao lado pra empresa ou algo que está enviando
	        message.setRecipients(Message.RecipientType.TO, toUser); //email de destino os array de email
	        message.setSubject(asunto); //assunto do email titulo qnd envia
	        
	        
	        //parte 1 do email que é texto e descrição do e-mail
	        
	        MimeBodyPart corpoEmail = new MimeBodyPart();

	        if (envioHtml) { //se enviar com html
	        	corpoEmail.setContent(textoMail, "text/html; charset=utf-8");
	        }else {
	        	corpoEmail.setText(textoMail);//texto do envio do email
	        }
	        
	        List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
	        
	        //pode vir do banco de dados etc
	        arquivos.add(PDFArmado(nombreAdjunto, espacio1, espacio2));
                
                
	        /* LISTA DE EJEMPLOS
                arquivos.add(simuladorDePDF());//nota fiscal //certificado
	        arquivos.add(simuladorDePDF());//documento texto
	        arquivos.add(simuladorDePDF());//Imagem
                */
	        
	        //juntando a parte 1 e dois corpo email e anexoemail
	        Multipart multipart = new  MimeMultipart(); 
	        multipart.addBodyPart(corpoEmail);
           
            int index = 0;
	        
	        for (FileInputStream fileInputStream : arquivos) {
	        	
	        
	        //parte 2 dos email que são os anexo em PDF
	        MimeBodyPart anexoEmail = new MimeBodyPart();
	        
	        //onde é passado  o simulador de pdf você passa o seu aquivo gravado  no banco de dados ou qlq outro local
	        anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(PDFArmado(nombreAdjunto, espacio1, espacio2),"application/pdf"))); //aqui pode mudar pra doc text pdf de acordo com o arquivo que fosse enviar
	        anexoEmail.setFileName(nombreAdjunto + ".pdf");
	      
	        multipart.addBodyPart(anexoEmail);
	        
	        index++;
	        
                }
               message.setContent(multipart);
               
                Transport.send(message); //objeto de mensagem pra ser enviado
                JOptionPane.showMessageDialog(null, "Mensaje enviado", "Envio de mails", 0);

	}	 	
	
	  
	
	 //esse método simula o pdf ou qualquer arquivo que possa ser enviado por anexo no email
    //pode pegar o aquivo no banco de dados tb ou uma pasta ,base64, byte[],  Stream de arquivo
	//Retorna um pdf em branco ou  com o texto do Paragrafo de exemplo
    private FileInputStream simuladorDePDF() throws Exception {
    	 
    	Document document  = new Document();
    	File file = new File("demoArchivoAnexoAMail.pdf");
    	file.createNewFile();
    	PdfWriter.getInstance(document, new FileOutputStream(file));
    	document.open();
    	document.add(new Paragraph("Contenido del PDF anexo en el mail"));
    	document.close();
    	
    	return new FileInputStream(file);
    }

    
    private FileInputStream PDFArmado(String nombreAdjunto, String espacio1, 
            String espacio2) throws Exception {
    	 
        Document document  = new Document();
    	File file = new File(nombreAdjunto);
    	file.createNewFile();
    	PdfWriter.getInstance(document, new FileOutputStream(file));
    	document.open();
    	document.add(new Paragraph(espacio1));
        document.add(new Paragraph("\n\n"));
        document.add(new Paragraph(espacio2));
    	document.close();
    	
    	return new FileInputStream(file);
    }
}
