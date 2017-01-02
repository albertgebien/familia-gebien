package br.com.familiagebien.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.familiagebien.entidades.Pessoa;

@Path("/pessoa")
@Produces({ "application/json;charset=ISO-8859-1"})
public class PessoaController {
	
	@POST
	@Path("/form")
	public void cadastrar(Pessoa pessoa){
		System.out.println(pessoa.getId());
		System.out.println(pessoa.getNome());
	}
	
	@GET
	@Path("/listar")
	public Pessoa listar(){
		Pessoa p = new Pessoa();
		p.setId(1L);
		p.setNome("Albert");
		return p;
	}
	
	
}
