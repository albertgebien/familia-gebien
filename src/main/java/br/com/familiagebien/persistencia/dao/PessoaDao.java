package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.persistencia.CrudDAO;

public class PessoaDao extends CrudDAO<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaDao() {
		super(Pessoa.class);
	}

	public List<Pessoa> listar() {
		Query query = getEntityManager().createQuery(
				"from Pessoa order by nome");
		return query.getResultList();
	}
}
