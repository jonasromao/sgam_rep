package br.com.setaprox.sgam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class GraficoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<Double> valores = new ArrayList<Double>();
	private List<Date> datas = new ArrayList<Date>();
	private List<String> nomeMeses = new ArrayList<String>();
	private double valorTotal;
	
	public GraficoDTO(){

	}

	public List<Double> getValores() {
		return valores;
	}

	public void setValores(List<Double> valores) {
		this.valores = valores;
	}

	public List<Date> getDatas() {
		return datas;
	}

	public void setDatas(List<Date> datas) {
		this.datas = datas;
	}

	public List<String> getNomeMeses() {
		return nomeMeses;
	}

	public void setNomeMeses(List<String> nomeMeses) {
		this.nomeMeses = nomeMeses;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
