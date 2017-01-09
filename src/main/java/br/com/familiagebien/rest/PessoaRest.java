package br.com.familiagebien.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;

@Path("/pessoa")
@Produces({ "application/json;charset=ISO-8859-1"})
@Consumes({ "application/json;charset=ISO-8859-1"})
public class PessoaRest {
	
	// injetando ejb
	@Inject
	private PessoaServicoEJB pessoaServico;
	
	@POST
	@Path("/registrar")
	public Response cadastrar(Pessoa pessoa) {
		String msg = null;
		try{
			this.pessoaServico.registrar(pessoa);
		}catch (BaseException e) {
			msg = e.getMessage();
		}
		
		return Response.ok(msg).build();
	}
}
