package br.com.setaprox.sgam.constante;

public enum Categoria {
	
	ASSOCIADO("Associado"), COMERCIO("Comércio"), ALUGUEL("Aluguel");
	
	private final String codigo;
	
	Categoria(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}

}
