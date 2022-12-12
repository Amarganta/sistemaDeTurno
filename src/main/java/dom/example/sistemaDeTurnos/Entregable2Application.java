package dom.example.sistemaDeTurnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.*;
@SpringBootApplication
public class Entregable2Application {

	//PropertyConfigurator.configure("log4j.porperties");
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(Entregable2Application.class, args);
	}

}
