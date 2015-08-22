package br.com.familiagebien.servico.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.RelacionamentoPessoaDao;

@Stateless
public class RelacionamentoPessoaServicoEJB extends BaseServico<RelacionamentoPessoa> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RelacionamentoPessoaDao relacionamentoPessoaDao; 
	
    protected ICrudDAO<RelacionamentoPessoa> getDAO() {
		return this.relacionamentoPessoaDao;
	}

	public List<RelacionamentoPessoa> obterRelacionamentosPorIdPessoa(Integer id) {
		return relacionamentoPessoaDao.obterRelacionamentosPorIdPessoa(id);
	}

}