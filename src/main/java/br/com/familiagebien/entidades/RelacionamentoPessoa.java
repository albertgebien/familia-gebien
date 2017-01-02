package br.com.familiagebien.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RELACIONAMENTOPESSOA")
public class RelacionamentoPessoa extends EntidadeBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idRelacionamentoPessoa;
	private Pessoa pessoa;
	private Pessoa pessoaRelacionada;
	private TipoRelacionamento tipoRelacionamento;
	private Date dataInicio;
	private Date dataFim;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdRelacionamentoPessoa() {
		return idRelacionamentoPessoa;
	}
	public void setIdRelacionamentoPessoa(Integer idRelacionamentoPessoa) {
		this.idRelacionamentoPessoa = idRelacionamentoPessoa;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPessoa")
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idPessoaRelacionada")
	public Pessoa getPessoaRelacionada() {
		return pessoaRelacionada;
	}
	public void setPessoaRelacionada(Pessoa pessoaRelacionada) {
		this.pessoaRelacionada = pessoaRelacionada;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idTipoRelacionamento")
	public TipoRelacionamento getTipoRelacionamento() {
		return tipoRelacionamento;
	}
	public void setTipoRelacionamento(TipoRelacionamento tipoRelacionamento) {
		this.tipoRelacionamento = tipoRelacionamento;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
}
