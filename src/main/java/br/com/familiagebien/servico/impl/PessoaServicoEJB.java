package br.com.familiagebien.servico.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.enums.TipoUsuario;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.persistencia.ICrudDAO;
import br.com.familiagebien.persistencia.dao.PessoaDAO;

@Stateless
public class PessoaServicoEJB extends BaseServico<Pessoa>  {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaDAO pessoaDao; 
	
    protected ICrudDAO<Pessoa> getDAO() {
		return this.pessoaDao;
	}
    
    public Pessoa registrar(Pessoa pessoa) throws BaseException{
		if("".equals(pessoa.getNome())){
			throw new BaseException("Nome inválido");
		}
		
		if("".equals(pessoa.getEmail())){
			throw new BaseException("Email inválido");
		}
		
		if("".equals(pessoa.getSenha())){
			throw new BaseException("Senha inválido");
		}
		
		Pessoa pessoaPorEmail = this.pessoaDao.obterPorEmail(pessoa.getEmail());
		if(pessoaPorEmail != null){
			throw new BaseException("ja existe usuario cadastrado com esse email");
		}
		
		pessoa.setCodTipoUsuario(TipoUsuario.COMUM.getCodigo());
		pessoa = this.incluir(pessoa);
    		
    	return pessoa;
    }
}