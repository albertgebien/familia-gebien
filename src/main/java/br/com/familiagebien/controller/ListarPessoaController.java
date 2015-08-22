package br.com.familiagebien.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;

@Named
@ViewScoped
public class ListarPessoaController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Pessoa> pessoas;
	
	@Inject
	private PessoaServicoEJB pessoaService;
	

	public String adicionar() {
		return "/paginas/cadastrar-pessoa.jsf?faces-redirect=true";
	}

	public String editar(Long idPessoa) {
		return "/paginas/cadastrar-pessoa.jsf?faces-redirect=true&idPessoa="+idPessoa;
	}
	
	public List<Pessoa> getPessoas() throws BaseException {
		if(pessoas == null){
			pessoas = pessoaService.listar();
		}
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
}
