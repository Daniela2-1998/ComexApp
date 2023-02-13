package Daniela.ComexApp;

import Daniela.ComexApp.Frames.InicioSesion;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {InicioSesion.class})
class ComexAppApplicationTests {

	@Test
	void contextLoads() {
            
	}

}
