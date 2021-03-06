package br.com.setaprox.sgam.constante;

public enum Status {

	RECEBIDA("Recebida"), PAGA("Paga"), PENDENTE("Pendente"), ATRASADA("Atrasada"), ABERTA("Aberta"), FECHADA("Fechada"), VENCIDO("Vencido"), ATIVO("Ativo");
	
	private final String codigo;
	
	Status(String codigo){
		this.codigo = codigo;
	}
	
	public String getCodigo(){
		return codigo;
	}
}
