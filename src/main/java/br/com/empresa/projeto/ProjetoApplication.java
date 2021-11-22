package br.com.empresa.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ProjetoApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		//SpringApplication.run(ProjetoApplication.class, args);
		
		new ProjetoApplication().configure(new SpringApplicationBuilder(ProjetoApplication.class)).run(args);
		
	}

}
