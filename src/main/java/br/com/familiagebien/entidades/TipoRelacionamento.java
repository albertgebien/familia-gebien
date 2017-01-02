package br.com.familiagebien.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPORELACIONAMENTO")
public class TipoRelacionamento extends EntidadeBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idTipoRelacionamento;
	private String descricao;

	@Id
	public Integer getIdTipoRelacionamento() {
		return idTipoRelacionamento;
	}
	public void setIdTipoRelacionamento(Integer idTipoRelacionamento) {
		this.idTipoRelacionamento = idTipoRelacionamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idTipoRelacionamento == null) ? 0 : idTipoRelacionamento.hashCode());
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
		TipoRelacionamento other = (TipoRelacionamento) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipoRelacionamento == null) {
			if (other.idTipoRelacionamento != null)
				return false;
		} else if (!idTipoRelacionamento.equals(other.idTipoRelacionamento))
			return false;
		return true;
	}

}
