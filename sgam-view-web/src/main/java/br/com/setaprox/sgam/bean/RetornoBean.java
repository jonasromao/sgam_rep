package br.com.setaprox.sgam.bean;


public class RetornoBean {
	private int status;
	private String mensagem;
	private Object object;
	private int id;
	
	public RetornoBean(){
		
	}
	
	public RetornoBean(int status, String mensagem){
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public RetornoBean(int status, String mensagem, int id){
		this.status = status;
		this.mensagem = mensagem;
		this.id = id;
	}
	
	public RetornoBean(int status, String mensagem, Object object){
		this.status = status;
		this.mensagem = mensagem;
		this.object = object;
	}
	
	public RetornoBean(int status, Object object){
		this.status = status;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
