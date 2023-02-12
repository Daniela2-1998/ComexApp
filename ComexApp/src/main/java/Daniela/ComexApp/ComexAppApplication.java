package Daniela.ComexApp;

import Daniela.ComexApp.Frames.InicioSesion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ComexAppApplication /* implements CommandLineRunner */{

        InicioSesion inicioSesion = new InicioSesion();

	public static void main(String[] args) {
		
		SpringApplication.run(ComexAppApplication.class, args);
           
	}
/*
	@Override
	public void run(String... args) throws Exception {
		inicioSesion.setVisible(true);
	}
*/
       
}
