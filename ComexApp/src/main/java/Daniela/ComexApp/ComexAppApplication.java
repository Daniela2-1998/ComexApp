package Daniela.ComexApp;

import Daniela.ComexApp.Frames.InicioSesion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ComexAppApplication /* implements CommandLineRunner */{

        InicioSesion inicioSesion = new InicioSesion();
	//private final static Logger logger = LoggerFactory.getLogger(ComexAppApplication.class);
	public static void main(String[] args) {
		//logger.info("Mensaje A");
		SpringApplication.run(ComexAppApplication.class, args);
           
		//logger.info("Mensaje B");
		//JOptionPane.showMessageDialog(null, "Programa");
	}
/*
	@Override
	public void run(String... args) throws Exception {
		inicioSesion.setVisible(true);
	}
*/
       
}
