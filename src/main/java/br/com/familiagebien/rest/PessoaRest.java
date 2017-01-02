package br.com.familiagebien.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.familiagebien.entidades.Pessoa;

@Path("/pessoa")
@Produces({ "application/json;charset=ISO-8859-1"})
public class PessoaRest {
	
	@POST
	@Path("/form")
	public void cadastrar(Pessoa pessoa){
	}
	
	@GET
	@Path("/listar")
	public Pessoa listar(){
		Pessoa p = new Pessoa();
		return p;
	}
	
	
}
