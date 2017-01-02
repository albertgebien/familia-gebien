package br.com.familiagebien.enums;

/**
 * O admistrator permite criar e alterar qualquer pessoa. 
 * Usuario comum permite apenas criar e alterar apenas pessoas que ele cadastrou.
 * @author albert
 *
 */
public enum TipoUsuario {
	
	ADMINISTRADOR(1),
	COMUM(2);
	
	TipoUsuario(Integer codigo){
		this.setCodigo(codigo);
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	private Integer codigo;
	
	public static TipoUsuario obterTipoUsuarioPorCodigo(Integer codigo){
		TipoUsuario[] values = TipoUsuario.values();
		for (TipoUsuario tipoUsuario : values) {
			if(tipoUsuario.getCodigo().equals(codigo)){
				return tipoUsuario;
			}
		}
		return null;
	}
}
