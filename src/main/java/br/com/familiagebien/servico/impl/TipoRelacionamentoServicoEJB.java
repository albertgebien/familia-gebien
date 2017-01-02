package br.com.familiagebien.servico.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.TipoRelacionamento;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.TipoRelacionamentoDAO;

@Stateless
public class TipoRelacionamentoServicoEJB extends BaseServico<TipoRelacionamento>  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TipoRelacionamentoDAO tipoRelacionamentoDao; 
	
    protected ICrudDAO<TipoRelacionamento> getDAO() {
		return this.tipoRelacionamentoDao;
	}
}