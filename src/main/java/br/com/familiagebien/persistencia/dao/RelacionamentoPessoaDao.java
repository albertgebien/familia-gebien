package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.persistencia.CrudDAO;

public class RelacionamentoPessoaDao extends CrudDAO<RelacionamentoPessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RelacionamentoPessoaDao() {
		super(RelacionamentoPessoa.class);
	}

	public List<RelacionamentoPessoa> listar() {
		Query query = getEntityManager().createQuery(
				"from RelacionamentoPessoa");
		return query.getResultList();
	}

	public List<RelacionamentoPessoa> obterRelacionamentosPorIdPessoa(Integer id) {
		String sql = "from RelacionamentoPessoa where id.idPessoa = :idPessoa";
		Query query = getEntityManager().createQuery(sql);
		query.setParameter("idPessoa", id);
		return query.getResultList();
	}
}
