package br.com.familiagebien.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RelacionamentoPessoa")
public class RelacionamentoPessoa extends EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private RelacionamentoPessoaPK id;
    private TipoRelacionamentoPessoa TipoRelacionamentoPessoa;
    private Integer idRelacao;
    private Date dataInicio;
    private Date dataFim;
    private Pessoa pessoa;
    private Pessoa pessoaRelacionada;

    @EmbeddedId
	public RelacionamentoPessoaPK getId() {
		return id;
	}

	public void setId(RelacionamentoPessoaPK id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name="idTipoRelacionamentoPessoa")
	public TipoRelacionamentoPessoa getTipoRelacionamentoPessoa() {
		return TipoRelacionamentoPessoa;
	}

	public void setTipoRelacionamentoPessoa(TipoRelacionamentoPessoa tipoRelacionamentoPessoa) {
		TipoRelacionamentoPessoa = tipoRelacionamentoPessoa;
	}

	@OneToOne
	@JoinColumn(name="idPessoa",insertable=false,updatable=false)
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@OneToOne
	@JoinColumn(name="idPessoaRelacionada",insertable=false,updatable=false)
	public Pessoa getPessoaRelacionada() {
		return pessoaRelacionada;
	}

	public void setPessoaRelacionada(Pessoa pessoaRelacionada) {
		this.pessoaRelacionada = pessoaRelacionada;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getIdRelacao() {
		return idRelacao;
	}

	public void setIdRelacao(Integer idRelacao) {
		this.idRelacao = idRelacao;
	}


}