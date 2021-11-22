package br.com.empresa.projeto;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.com.empresa.projeto.resource.PessoaResource;

@Component
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig(){
	
		register(PessoaResource.class);	

	}
	


}
