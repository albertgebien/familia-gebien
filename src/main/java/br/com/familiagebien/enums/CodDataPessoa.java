package br.com.familiagebien.enums;

public enum CodDataPessoa {
	EXATAMENTE(1),
	APROXIMADAMENTE(2);
	
	CodDataPessoa(Integer codigo){
		this.setCodigo(codigo);
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	private Integer codigo;
	
	public static CodDataPessoa obterCodDataPessoaPorCodigo(Integer codigo){
		CodDataPessoa[] values = CodDataPessoa.values();
		for (CodDataPessoa codUsu : values) {
			if(codUsu.getCodigo().equals(codigo)){
				return codUsu;
			}
		}
		return null;
	}
}
