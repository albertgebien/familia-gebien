package br.com.familiagebien.servico.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.PessoaDAO;

@Stateless
public class PessoaServicoEJB extends BaseServico<Pessoa>  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDAO pessoaDao; 
	
    protected ICrudDAO<Pessoa> getDAO() {
		return this.pessoaDao;
	}
}