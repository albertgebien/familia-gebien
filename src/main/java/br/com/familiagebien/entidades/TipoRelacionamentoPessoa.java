package br.com.familiagebien.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TipoRelacionamentoPessoa")
public class TipoRelacionamentoPessoa extends EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nomeTipoRelacionamento;
    private TipoRelacionamentoPessoa tipoRelacionamentoPessoaEspecial;

    @Id
    @Column(name = "idTipoRelacionamento", precision = 10)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getNomeTipoRelacionamento() {
		return nomeTipoRelacionamento;
	}

	public void setNomeTipoRelacionamento(String nomeTipoRelacionamento) {
		this.nomeTipoRelacionamento = nomeTipoRelacionamento;
	}

	@OneToOne
	@JoinColumn(name="idTipoRelacionamentoEspecial")
	public TipoRelacionamentoPessoa getTipoRelacionamentoPessoaEspecial() {
		return tipoRelacionamentoPessoaEspecial;
	}

	public void setTipoRelacionamentoPessoaEspecial(TipoRelacionamentoPessoa tipoRelacionamentoEspecial) {
		this.tipoRelacionamentoPessoaEspecial = tipoRelacionamentoEspecial;
	}
}