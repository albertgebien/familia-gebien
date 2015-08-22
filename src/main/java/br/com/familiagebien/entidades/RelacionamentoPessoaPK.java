package br.com.familiagebien.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class RelacionamentoPessoaPK extends EntidadeBase implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer idPessoa;
    private Integer idPessoaRelacionada;
    
    @Column(name="idPessoa")
	public Integer getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}
	
	@Column(name="idPessoaRelacionada")
	public Integer getIdPessoaRelacionada() {
		return idPessoaRelacionada;
	}
	public void setIdPessoaRelacionada(Integer idPessoaRelacionada) {
		this.idPessoaRelacionada = idPessoaRelacionada;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPessoa == null) ? 0 : idPessoa.hashCode());
		result = prime
				* result
				+ ((idPessoaRelacionada == null) ? 0 : idPessoaRelacionada
						.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RelacionamentoPessoaPK other = (RelacionamentoPessoaPK) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		if (idPessoaRelacionada == null) {
			if (other.idPessoaRelacionada != null)
				return false;
		} else if (!idPessoaRelacionada.equals(other.idPessoaRelacionada))
			return false;
		return true;
	}
}