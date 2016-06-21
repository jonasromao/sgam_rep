package br.com.setaprox.sgam.constante;

public enum UnidadeMedida {
	
	HORA("Hora"), MINUTO("Minuto"), DIA("Dia");
	
	private final String codigo;
	
	UnidadeMedida(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
}
