package br.com.familiagebien.controller;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.familiagebien.entidades.Pessoa;
import br.com.familiagebien.entidades.RelacionamentoPessoa;
import br.com.familiagebien.entidades.RelacionamentoPessoaPK;
import br.com.familiagebien.entidades.TipoRelacionamentoPessoa;
import br.com.familiagebien.exceptions.BaseException;
import br.com.familiagebien.servico.impl.PessoaServicoEJB;
import br.com.familiagebien.servico.impl.RelacionamentoPessoaServicoEJB;
import br.com.familiagebien.servico.impl.TipoRelacionamentoPessoaServicoEJB;

@Named
@ViewScoped
public class PessoaDialogController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	private Boolean bolFalecida;
	private Integer idTipoRelacionamento;
	private Integer idPessoaPrincipal;
	private Integer idRelacao = 1;
	private Date dataCasamento;
	private Date dataDivorcio;

	@Inject
	private PessoaServicoEJB pessoaService;
	
	@Inject
	private TipoRelacionamentoPessoaServicoEJB tipoRelacionamentoPessoaService;

	@Inject
	private RelacionamentoPessoaServicoEJB relacionamentoPessoaService;
	
	public void adicionarTipoRelacionamento(Integer idTipoRelacionamento,Integer idPessoa){
		this.idPessoaPrincipal = idPessoa;
		this.idTipoRelacionamento = idTipoRelacionamento;
	}
	
	public void incluir() throws BaseException{
		pessoaService.incluir(getPessoa());
		inserirRelacionamento();
		setPessoa(new Pessoa());
	}
	
	 private void inserirRelacionamento() throws BaseException{
		 TipoRelacionamentoPessoa tipoRelacionamento = tipoRelacionamentoPessoaService.obter(idTipoRelacionamento);
		 
		 RelacionamentoPessoa r1 = new RelacionamentoPessoa();
		 RelacionamentoPessoaPK id1 = new RelacionamentoPessoaPK();
		 id1.setIdPessoa(idPessoaPrincipal);
		 id1.setIdPessoaRelacionada(getPessoa().getId());
		 r1.setId(id1);
		 r1.setTipoRelacionamentoPessoa(tipoRelacionamento);
		 preencheDatas(r1);
		 relacionamentoPessoaService.incluir(r1);
		 
		 if(tipoRelacionamento.getTipoRelacionamentoPessoaEspecial() != null){
			 RelacionamentoPessoa r2 = new RelacionamentoPessoa();
			 RelacionamentoPessoaPK id2 = new RelacionamentoPessoaPK();
			 id2.setIdPessoa(getPessoa().getId());
			 id2.setIdPessoaRelacionada(idPessoaPrincipal);
			 r2.setId(id2);
			 r2.setTipoRelacionamentoPessoa(tipoRelacionamento.getTipoRelacionamentoPessoaEspecial());
			 preencheDatas(r2);			 
			 relacionamentoPessoaService.incluir(r2);
		 } else {
			 RelacionamentoPessoa r2 = new RelacionamentoPessoa();
			 RelacionamentoPessoaPK id2 = new RelacionamentoPessoaPK();
			 id2.setIdPessoa(pessoa.getId());
			 id2.setIdPessoaRelacionada(idPessoaPrincipal);
			 r2.setId(id2);
			 r2.setTipoRelacionamentoPessoa(tipoRelacionamento);
			 preencheDatas(r2);	
			 relacionamentoPessoaService.incluir(r2);
		 }
	 }

	private void preencheDatas(RelacionamentoPessoa r1) {
		switch (r1.getTipoRelacionamentoPessoa().getId()) {
		case 1:
			r1.setDataInicio(getDataCasamento());
			break;
		case 2:
			r1.setDataInicio(getDataCasamento());
			r1.setDataFim(getDataDivorcio());
			break;
		default:
			break;
		}
	}


	public Boolean getBolFalecida() {
		return bolFalecida;
	}


	public void setBolFalecida(Boolean bolFalecida) {
		this.bolFalecida = bolFalecida;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Integer getIdRelacao() {
		return idRelacao;
	}

	public void setIdRelacao(Integer idRelacao) {
		this.idRelacao = idRelacao;
	}

	public Date getDataCasamento() {
		return dataCasamento;
	}

	public void setDataCasamento(Date dataCasamento) {
		this.dataCasamento = dataCasamento;
	}

	public Date getDataDivorcio() {
		return dataDivorcio;
	}

	public void setDataDivorcio(Date dataDivorcio) {
		this.dataDivorcio = dataDivorcio;
	}
}
