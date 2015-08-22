package br.com.familiagebien.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;
import br.com.familiagebien.servico.impl.RelacionamentoPessoaServicoEJB;
import br.com.familiagebien.servico.impl.TipoRelacionamentoPessoaServicoEJB;

@Named
@ViewScoped
public class RelacionamentoCadastroController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Pessoa> pessoas;
	private List<RelacionamentoPessoa> relacionamentos;
	
	@Inject
	private PessoaServicoEJB pessoaService;
	
	@Inject
	private TipoRelacionamentoPessoaServicoEJB tipoRelacionamentoPessoaService;
	
	@Inject
	private RelacionamentoPessoaServicoEJB relacionamentoPessoaService;
	
	@Inject
	private PessoaCadastroController pessoaCadastroController;
	

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
	
	public List<RelacionamentoPessoa> getRelacionamentos() {
		if(relacionamentos == null){
			relacionamentos = relacionamentoPessoaService.obterRelacionamentosPorIdPessoa(pessoaCadastroController.getPessoa().getId());
		}
		return relacionamentos;
	}

	public void setRelacionamentos(List<RelacionamentoPessoa> relacionamentos) {
		this.relacionamentos = relacionamentos;
	}
	
	
	
}
