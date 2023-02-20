package Daniela.ComexApp;

import Daniela.ComexApp.Frames.InicioSesion;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.springframework.boot.Banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ComexAppApplication {

        InicioSesion inicioSesion = new InicioSesion();

	public static void main(String[] args) {
            SpringApplicationBuilder builder = new SpringApplicationBuilder(ComexAppApplication.class);
            builder.headless(false);
            ConfigurableApplicationContext context = builder.run(args);    
                
            ApplicationContext contexto = new SpringApplicationBuilder(ComexAppApplication.class)
                .web(WebApplicationType.NONE)
                .headless(false)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
           
	}

	
	public void run(String... args) throws Exception {
	    SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            inicioSesion.setVisible(true);
        });
            
	}

       
}
