package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table( name = "aluguel" )
public class Aluguel extends AbstractEntity<Aluguel> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_aluguel" )
	private Long id;
	
	@NotNull
	@Column( name = "data_inicial" )
	private Date dataInicial;
	
	@NotNull
	@Column( name = "data_final" )
	private Date dataFinal;
	
	//@NotNull
	@Column( name = "data_emissao_faturamento" )
	private Date dataEmissaoFaturamento;
	
	@Column( name = "data_pagamento" )
	private Date dataPagamento;
	
	@Column( name = "observacao" )
	private String observacao;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_morador")
	private Morador morador;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso")
	private Recurso recurso;
	
	@OneToOne(mappedBy = "aluguel" )
	private AluguelComercio aluguelComercio;
	
	@OneToOne(mappedBy = "aluguel")
	private ContasReceber contaReceber;
	
	@Transient
	private String dataHoraInicio;
	
	@Transient
	private String dataHoraFinal;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Date getDataEmissaoFaturamento() {
		return dataEmissaoFaturamento;
	}

	public void setDataEmissaoFaturamento(Date dataEmissaoFaturamento) {
		this.dataEmissaoFaturamento = dataEmissaoFaturamento;
	}

	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Morador getMorador() {
		return morador;
	}
	
	public void setMorador(Morador morador) {
		this.morador = morador;
	}
	
	public Recurso getRecurso() {
		return recurso;
	}
	
	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}
	
	public AluguelComercio getAluguelComercio() {
		return aluguelComercio;
	}
	
	public void setAluguelComercio(AluguelComercio aluguelComercio) {
		this.aluguelComercio = aluguelComercio;
	}
	
	public ContasReceber getContaReceber() {
		return contaReceber;
	}
	
	public void setContaReceber(ContasReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public String getDataHoraFinal() {
		return dataHoraFinal;
	}

	public void setDataHoraFinal(String dataHoraFinal) {
		this.dataHoraFinal = dataHoraFinal;
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
