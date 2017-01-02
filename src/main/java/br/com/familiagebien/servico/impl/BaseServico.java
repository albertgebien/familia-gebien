package br.com.familiagebien.servico.impl;

import java.io.Serializable;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import br.com.familiagebien.entidades.EntidadeBase;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.persistencia.ICrudDAO;

@TransactionAttribute(TransactionAttributeType.REQUIRED)
@TransactionManagement(TransactionManagementType.CONTAINER)
public abstract class BaseServico<T extends EntidadeBase> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5248420317768127958L;

	public T obter(Serializable id) throws BaseException {
		return getDAO().obter(id);
	}

	public void incluir(T t) throws BaseException {
		getDAO().incluir(t);
	}

	public void alterar(T t) throws BaseException {
		getDAO().alterar(t);
	}

	public void excluir(Serializable chave) throws BaseException {
		getDAO().excluir(chave);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> listar() throws BaseException {
		return getDAO().listar();
	}

	protected abstract ICrudDAO<T> getDAO();

}