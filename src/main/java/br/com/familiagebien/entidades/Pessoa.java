package br.com.familiagebien.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PESSOA")
public class Pessoa extends EntidadeBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idPessoa;
	private String nome;
	private String sobrenome;
	private String sobrenomeSolteiro;
	private Date dataNascimento;
	private String email;
	private String senha;
	private Date dataFalecimento;
	private Integer codDataNascimento;
	private Integer codDataFalecimento;
	private String localNascimento;
	private String localFalecimento;
	private String motivoFalecimento;
	private Integer codTipoUsuario;
	private Pessoa pessoaCadastro;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getSobrenomeSolteiro() {
		return sobrenomeSolteiro;
	}
	public void setSobrenomeSolteiro(String sobrenomeSolteiro) {
		this.sobrenomeSolteiro = sobrenomeSolteiro;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDataFalecimento() {
		return dataFalecimento;
	}
	public void setDataFalecimento(Date dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}
	public Integer getCodDataNascimento() {
		return codDataNascimento;
	}
	public void setCodDataNascimento(Integer codDataNascimento) {
		this.codDataNascimento = codDataNascimento;
	}
	public Integer getCodDataFalecimento() {
		return codDataFalecimento;
	}
	public void setCodDataFalecimento(Integer codDataFalecimento) {
		this.codDataFalecimento = codDataFalecimento;
	}
	public String getLocalNascimento() {
		return localNascimento;
	}
	public void setLocalNascimento(String localNascimento) {
		this.localNascimento = localNascimento;
	}
	public String getLocalFalecimento() {
		return localFalecimento;
	}
	public void setLocalFalecimento(String localFalecimento) {
		this.localFalecimento = localFalecimento;
	}
	public String getMotivoFalecimento() {
		return motivoFalecimento;
	}
	public void setMotivoFalecimento(String motivoFalecimento) {
		this.motivoFalecimento = motivoFalecimento;
	}
	public Integer getCodTipoUsuario() {
		return codTipoUsuario;
	}
	public void setCodTipoUsuario(Integer codTipoUsuario) {
		this.codTipoUsuario = codTipoUsuario;
	}
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="idPessoaCadastro",nullable=true,foreignKey=@ForeignKey(name="fkIdPessoa"))
	public Pessoa getPessoaCadastro() {
		return pessoaCadastro;
	}
	public void setPessoaCadastro(Pessoa pessoaCadastro) {
		this.pessoaCadastro = pessoaCadastro;
	}
}
