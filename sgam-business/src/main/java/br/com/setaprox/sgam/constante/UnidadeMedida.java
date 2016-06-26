package br.com.setaprox.sgam.constante;

public enum UnidadeMedida {
	
	MINUTO("Minuto"), HORA("Hora"), DIA("Dia"), SEMANA("Semana"), MES("Mês"), ANO("Ano");
	
	private final String codigo;
	
	UnidadeMedida(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
}
