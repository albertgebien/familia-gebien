package br.com.familiagebien.vo;

import java.util.HashMap;
import java.util.Map;

public class RetornoVO {
	
	private boolean sucesso;
	private Map<String, Object> dados = new HashMap<String, Object>();
	private String mensagemErro;
	
	public boolean isSucesso() {
		return sucesso;
	}
	public void setSucesso(boolean sucesso) {
		this.sucesso = sucesso;
	}
	public Map<String, Object> getDados() {
		return dados;
	}
	public void setDados(Map<String, Object> dados) {
		this.dados = dados;
	}
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	

}
