package br.com.familiagebien.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;
 
@Named
@ViewScoped
public class PessoaCadastroController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa;
	private Boolean bolFalecida;
	
	@Inject
	private PessoaServicoEJB pessoaService;
	
	public void inicializar(Integer idPessoa) throws BaseException{
		if (idPessoa == null) {
			this.pessoa = new Pessoa();
        } else {
            this.pessoa = pessoaService.obter(idPessoa);
        }
	}
	
	public void salvar() throws BaseException{
		String mensagem = "";
		if(pessoa != null && pessoa.getId() != null){
			mensagem = "Dados da pessoa alterados com sucesso!";
			pessoaService.alterar(pessoa);
		 } else {
			mensagem = "Pessoa cadastrada com sucesso!";
			pessoaService.incluir(pessoa);
		 }
		 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, ""));
	}
	
	public String adicionarRelacionamentos(){
		return "/paginas/cadastroRelacionamento.jsf?faces-redirect=true&idPessoa="+getPessoa().getId();
	}
	
	public void limpar(){
		pessoa = new Pessoa();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getBolFalecida() {
		return bolFalecida;
	}

	public void setBolFalecida(Boolean bolFalecida) {
		this.bolFalecida = bolFalecida;
	}
}
