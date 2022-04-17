package br.com.webnext.modulocore.enuns;

public enum ModuloEnum {

	MODULO_LOGIN("modulologin"), MODULO_CORE("modulocore"), MODULO_API("moduloapi");
	
	private String descricao;
	
	ModuloEnum(String descricao) {
		this.descricao = descricao;
	}
	

    public String getDescricao() {
        return descricao;
    }

}
