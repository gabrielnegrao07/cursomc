package br.com.gabriel.cursomc.domain.enums;

public enum TipoCliente {
	
	/** 
	 * Implementação básica é simplesmente colocar os valores separados
	 * por virgula.
	 */
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
		
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum(Integer cod) {
		
		if(cod == null) {
			return null;		
		}
		
		/**
		 * Esse "for" percorre todos os valores possível do tipo Enumerable TipoCliente.
		 */
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}

}
