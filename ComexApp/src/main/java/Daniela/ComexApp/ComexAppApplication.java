package Daniela.ComexApp;

import Daniela.ComexApp.Frames.InicioSesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ComexAppApplication {

        InicioSesion inicioSesion = new InicioSesion();

	public static void main(String[] args) {
		
		SpringApplication.run(InicioSesion.class, args);
                InicioSesion inicioSesion = new InicioSesion();
                
           
	}

	
	public void run(String... args) throws Exception {
		inicioSesion.setVisible(true);
	}

       
}
