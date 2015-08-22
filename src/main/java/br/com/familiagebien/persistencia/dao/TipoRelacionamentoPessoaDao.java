package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.familiagebien.entidades.TipoRelacionamentoPessoa;
import br.com.familiagebien.persistencia.CrudDAO;

public class TipoRelacionamentoPessoaDao extends CrudDAO<TipoRelacionamentoPessoa> {

	private static final long serialVersionUID = 1L;

	public TipoRelacionamentoPessoaDao() {
		super(TipoRelacionamentoPessoa.class);
	}

	public List<TipoRelacionamentoPessoa> listar() {
		Query query = getEntityManager().createQuery(
				"from TipoRelacionamentoPessoa order by nomeTipoRelacionamento");
		return query.getResultList();
	}
}
