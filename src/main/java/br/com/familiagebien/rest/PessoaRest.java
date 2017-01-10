package br.com.familiagebien.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;
import br.com.familiagebien.vo.RetornoVO;

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
		RetornoVO retornoVO = new RetornoVO();
		retornoVO.setSucesso(true);
		
		String msg = null;
		try{
			Pessoa p = this.pessoaServico.registrar(pessoa);
			retornoVO.getDados().put("PESSOA", p);
		}catch (BaseException e) {
			retornoVO.setSucesso(false);
			msg = e.getMessage();
		}
		
		retornoVO.setMensagemErro(msg);
		return Response.ok(retornoVO).build();
	}
	
	@GET
	@Path("/buscar")
	public RetornoVO teste() {
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(1L);
		pessoa.setNome("teste");
		
		RetornoVO retornoVO = new RetornoVO();
		retornoVO.getDados().put("PESSOA", pessoa);
		
		return retornoVO;
	}
	
	
}
