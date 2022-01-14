package webnext.com.br.modulologin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "webnext.com.br")
@EnableJpaRepositories
@EnableTransactionManagement
public class ModuloLoginApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(ModuloLoginApplication.class);
		app.run();
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ModuloLoginApplication.class);
	}

}
