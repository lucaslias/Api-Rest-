package br.com.empresa.projeto.resource;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.empresa.projeto.model.Pessoa;
import br.com.empresa.projeto.repositorio.PessoaRepository;

//define a url 
@Path ("/pessoa")
public class PessoaResource {
	
	@Autowired
	protected PessoaRepository rpo;
	
	@GET
	@Path("inserir")
	@Consumes(MediaType.APPLICATION_JSON) //recebe um json
	@Produces(MediaType.APPLICATION_JSON) //vai retornar um json
	//response = resposta de http
	public Response insertPessoa(Pessoa pessoa) {
		
		//se pessoa for vazio da erro
		if(pessoa.getName()==null) {
			return Response.status(400).entity("insira o texto").build();
		}
		
		//se não for irá inserir e retornar a mensagem
		rpo.save(pessoa);
		return Response.status(200).entity("cadastro realizado").build();
	}
	
	@GET
	@Path("id/{id}")
	@Produces(MediaType.APPLICATION_JSON) //vai retornar um json
	public Response PesquisaId(@PathParam("id") Long Id) {
		
		Optional<Pessoa> p = rpo.findById(Id);
		return Response.status(200).entity(p).build();
	}
	
	
	@POST
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON) 
	public Response PesquisaTodos() {
		
		List lista = rpo.findAll();
		return Response.status(200).entity(lista).build();
	}
	
	
	
	
	
	
	
	
	

	
}