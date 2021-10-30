package usa.edu.ciclo3.Reto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"usa.edu.ciclo3.Reto3.Model"})
public class GrupoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrupoApplication.class, args);
	} 

}
 