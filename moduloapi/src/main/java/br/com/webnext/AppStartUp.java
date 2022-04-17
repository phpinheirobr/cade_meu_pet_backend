package br.com.webnext;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.webnext.modulocore.util.SpringUtils;

@SpringBootApplication(scanBasePackages = {
		 "br.com.webnext" 
		})

@EnableJpaRepositories(basePackages = {

		})

@EntityScan(basePackages = {
		
})

@ComponentScan(basePackages = {
		
})
@Configuration
@EnableTransactionManagement
public class AppStartUp extends SpringBootServletInitializer {
	
	@Autowired
	private SpringUtils springUtils;


	public static void main(String[] args) {
		SpringApplicationBuilder app = new SpringApplicationBuilder(AppStartUp.class);
		app.run();
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AppStartUp.class);
	}
	
	@PostConstruct
	private void init() {
		springUtils.obterControllersContexto();	
	}
}
