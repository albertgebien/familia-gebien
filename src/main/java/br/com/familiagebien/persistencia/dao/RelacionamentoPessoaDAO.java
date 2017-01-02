package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.persistencia.CrudDAO;

public class RelacionamentoPessoaDAO extends CrudDAO<RelacionamentoPessoa> {

	private static final long serialVersionUID = 1L;

	public RelacionamentoPessoaDAO() {
		super(RelacionamentoPessoa.class);
	}

	@SuppressWarnings("unchecked")
	public List<RelacionamentoPessoa> listar() {
		Query query = getEntityManager().createQuery(
				"from RelacionamentoPessoa order by nome");
		return query.getResultList();
	}
}
