package br.com.familiagebien.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.vo.PessoaVO;

@Path("/pessoa")
@Produces({ "application/json;charset=ISO-8859-1"})
@Consumes({ "application/json;charset=ISO-8859-1"})
public class PessoaRest {
	
	@POST
	@Path("/form")
	public Response cadastrar(PessoaVO pessoa){
		System.out.println(pessoa.getNome());
		return Response.ok().build();
	}
//	
	@GET
	@Path("/listar")
	public Pessoa listar(){
		System.out.println("teste");
		Pessoa p = new Pessoa();
		return p;
	}
	
	@POST
	@Path("/add")
	public Response add(){
		System.out.println("teste");
		return Response.ok().build();
	}
	
	
//	@GET
//	@Path("/obter/{id}")
//	public Pessoa obter(@PathParam("id") String id){
//		System.out.println(id);
//		Pessoa p = new Pessoa();
//		p.setNome("albert");
//		return p;
//	}
	
}
