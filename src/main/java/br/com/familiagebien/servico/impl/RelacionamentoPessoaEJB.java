package br.com.familiagebien.servico.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.RelacionamentoPessoaDAO;

@Stateless
public class RelacionamentoPessoaEJB extends BaseServico<RelacionamentoPessoa>  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RelacionamentoPessoaDAO relacionamentoPessoaDao; 
	
    protected ICrudDAO<RelacionamentoPessoa> getDAO() {
		return this.relacionamentoPessoaDao;
	}
}