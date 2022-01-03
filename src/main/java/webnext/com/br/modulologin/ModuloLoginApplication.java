package webnext.com.br.modulologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class ModuloLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuloLoginApplication.class, args);
	}

}
