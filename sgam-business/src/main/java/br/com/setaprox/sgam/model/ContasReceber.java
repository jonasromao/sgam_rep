package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table( name = "contas_receber" )
public class ContasReceber extends AbstractEntity<ContasReceber> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_contas_receber" )
	private Long id;
	
	@Column( name = "numero" )
	private String numero;
	
	@Column( name = "digito" )
	private String digito;
	
	@Column( name = "nome" )
	private String nome;
	
	@Column( name = "historico" )
	private String historico;
	
	@Column( name = "data_emissao" )
	private Date dataEmissao;
	
	@Column( name = "data_vencimento" )
	private Date dataVencimento;
	
	@Column( name = "data_pagamento" )
	private Date dataPagamento;
	
	@Column( name = "especie_pagamento" )
	private String especiePagamento;
	
	@Column( name = "valor" )
	private Double valor;
	
	@Column( name = "status" )
	private String status;
	
	@OneToOne(mappedBy = "contaReceber")
	private Aluguel aluguel;
	
	public ContasReceber() {
		
	}
	
	@SuppressWarnings("deprecation")
	public ContasReceber(Aluguel aluguel) {
		
		this.nome = aluguel.getMorador().getNome();
		this.historico = aluguel.getAluguelComercio().getNome();
		this.dataEmissao = new Date();
		this.dataVencimento = aluguel.getDataEmissaoFaturamento();
		this.setValor(aluguel.getRecurso().getValor());
		this.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDate(),dataEmissao.getMonth(),dataEmissao.getYear(), dataEmissao.getHours(), dataEmissao.getMinutes(), dataEmissao.getSeconds()));

		if(this.dataVencimento.compareTo(dataEmissao) <= 0){
			this.setStatus("Recebido");
		}
		else {
			this.setStatus("Aberto");
		}
		
	}
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getDigito() {
		return digito;
	}
	
	public void setDigito(String digito) {
		this.digito = digito;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getHistorico() {
		return historico;
	}
	
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	
	public Date getDataEmissao() {
		return dataEmissao;
	}
	
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public String getEspeciePagamento() {
		return especiePagamento;
	}
	
	public void setEspeciePagamento(String especiePagamento) {
		this.especiePagamento = especiePagamento;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
