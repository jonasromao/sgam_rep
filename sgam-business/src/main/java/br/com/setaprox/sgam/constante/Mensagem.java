package br.com.setaprox.sgam.constante;

public enum Mensagem {
	SUCESSO(1), ERRO(-1);
	
	private final int codigo;
	
	Mensagem(int codigo){
		this.codigo = codigo;
	}
	
	public int getCodigo(){
		return codigo;
	}
}
