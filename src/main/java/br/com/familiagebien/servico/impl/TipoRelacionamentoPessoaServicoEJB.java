package br.com.familiagebien.servico.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.TipoRelacionamentoPessoa;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.TipoRelacionamentoPessoaDao;

@Stateless
public class TipoRelacionamentoPessoaServicoEJB extends BaseServico<TipoRelacionamentoPessoa> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoRelacionamentoPessoaDao tipoRelacionamentoPessoaDao; 
	
    protected ICrudDAO<TipoRelacionamentoPessoa> getDAO() {
		return this.tipoRelacionamentoPessoaDao;
	}

}