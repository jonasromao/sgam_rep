package br.com.setaprox.sgam.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table( name = "aluguel_comercio" )
public class AluguelComercio extends AbstractEntity<AluguelComercio> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column( name = "id_aluguel_comercio" )
	private Long id;
	
	@Column( name = "nome" )
	private String nome;
	
	@Column( name = "numero_alvara" )
	private String numeroAlvara;
	
	@Column( name = "data_emissao_alvara" )
	private Date dataEmissao;
	
	@Column( name = "data_vencimento_alvara" )
	private Date dataVencimento;
	
	@Column( name = "largura_barraca" )
	private Double larguraBarraca;
	
	@Column( name = "comprimento_barraca" )
	private Double comprimentoBarraca;
	
	@Column( name = "altura_barraca" )
	private Double alturaBarraca;
	
	@Column( name = "quantidade_colaboradores" )
	private int qtdePessoas;
	
	@Column( name = "descricao_equipamentos" )
	private String equipamentos;
	
	@Column( name = "descricao_produtos" )
	private String produtos;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REMOVE}/*, orphanRemoval = true*/ )
    @JoinColumn(name = "id_aluguel")
	private Aluguel aluguel;
	
	@Transient
	private String dataHoraInicio;
	
	@Transient
	private String dataHoraFinal;
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNumeroAlvara() {
		return numeroAlvara;
	}
	
	public void setNumeroAlvara(String numeroAlvara) {
		this.numeroAlvara = numeroAlvara;
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
	
	public Double getLarguraBarraca() {
		return larguraBarraca;
	}
	
	public void setLarguraBarraca(Double larguraBarraca) {
		this.larguraBarraca = larguraBarraca;
	}
	
	public Double getComprimentoBarraca() {
		return comprimentoBarraca;
	}
	
	public void setComprimentoBarraca(Double comprimentoBarraca) {
		this.comprimentoBarraca = comprimentoBarraca;
	}
	
	public Double getAlturaBarraca() {
		return alturaBarraca;
	}
	
	public void setAlturaBarraca(Double alturaBarraca) {
		this.alturaBarraca = alturaBarraca;
	}
	
	public int getQtdePessoas() {
		return qtdePessoas;
	}
	
	public void setQtdePessoas(int qtdePessoas) {
		this.qtdePessoas = qtdePessoas;
	}
	
	public String getEquipamentos() {
		return equipamentos;
	}
	
	public void setEquipamentos(String equipamentos) {
		this.equipamentos = equipamentos;
	}
	
	public String getProdutos() {
		return produtos;
	}
	
	public void setProdutos(String produtos) {
		this.produtos = produtos;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
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
