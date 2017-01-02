package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.familiagebien.entidades.TipoRelacionamento;
import br.com.familiagebien.persistencia.CrudDAO;

public class TipoRelacionamentoDAO extends CrudDAO<TipoRelacionamento> {

	private static final long serialVersionUID = 1L;

	public TipoRelacionamentoDAO() {
		super(TipoRelacionamento.class);
	}

	@SuppressWarnings("unchecked")
	public List<TipoRelacionamento> listar() {
		Query query = getEntityManager().createQuery(
				"from TipoRelacionamento order by nome");
		return query.getResultList();
	}
}
