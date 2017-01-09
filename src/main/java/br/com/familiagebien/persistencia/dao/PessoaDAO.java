package br.com.familiagebien.persistencia.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.persistencia.CrudDAO;

public class PessoaDAO extends CrudDAO<Pessoa> {

	private static final long serialVersionUID = 1L;

	public PessoaDAO() {
		super(Pessoa.class);
	}

	@SuppressWarnings("unchecked")
	public List<Pessoa> listar() {
		Query query = getEntityManager().createQuery(
				"from Pessoa order by nome");
		return query.getResultList();
	}

	public Pessoa obterPorEmail(String email) {
		try{
			Query query = getEntityManager().createQuery("from Pessoa where email = :email");
			query.setParameter("email", email);
			return (Pessoa) query.getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
	}
}
