package br.com.setaprox.sgam.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import br.com.setaprox.sgam.DAO.ContasReceberDAO;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.ContasReceberService;

@Stateless
@LocalBean
public class ContasReceberServiceImpl implements ContasReceberService {

	@EJB
	private ContasReceberDAO contasReceberDAO; 
	
	@Override
	public void persist(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.persist(contaReceber);
	}
	
	@Override
	public void registraContaReceber(Aluguel aluguel){
		String historico = String.format("Aluguel da(o) %s", aluguel.getRecurso().getNome());
		ContasReceber conta = criaContaReceber(aluguel, historico);
		this.persist(conta);
	}
	
	@Override
	public void registraContaReceber(AluguelComercio aluguelComercio){
		Aluguel aluguel = aluguelComercio.getAluguel();
		String historico = String.format("Comércio informal - Atividade %s", aluguelComercio.getNome());
		ContasReceber conta = criaContaReceber(aluguel, historico);
		this.persist(conta);
	}
	
	@Override
	public void merge(ContasReceber contaReceber) {
		analistaStatus(contaReceber);
		contasReceberDAO.editar(contaReceber);
	}
	
	@Override
	public List<ContasReceber> findAll() {
		return contasReceberDAO.findAll();
	}

	@Override
	public ContasReceber find(Long id) {
		return contasReceberDAO.find(id);
	}

	@Override
	public void remove(Long id) throws PersistenceException {
		contasReceberDAO.remove(id);
	}
	
	private void analistaStatus(ContasReceber contaReceber){
		Date atual = new Date();
		
		if(contaReceber.getDataPagamento() != null){
			contaReceber.setStatus(Status.RECEBIDA.getCodigo());
		}	
		else if(contaReceber.getDataVencimento() != null && contaReceber.getDataVencimento().compareTo(atual) < 0){
			contaReceber.setStatus(Status.ATRASADA.getCodigo());
		}
		else{
			contaReceber.setStatus(Status.PENDENTE.getCodigo());
		}
	}
	
	private ContasReceber criaContaReceber(Aluguel aluguel, String historico){
		DateTime dataEmissao = new DateTime();
		DateTime dataInicio = new DateTime(aluguel.getDataInicial());
		DateTime dataFim = new DateTime(aluguel.getDataFinal());
		
		String unidadeMedida = aluguel.getRecurso().getUnidadeMedida(); 
		int qtdeMedida = 0;
		
		switch(unidadeMedida){
			case "Hora":
				qtdeMedida = Hours.hoursBetween(dataInicio, dataFim).getHours();
				break;
			case "Minuto":
				qtdeMedida = Minutes.minutesBetween(dataInicio, dataFim).getMinutes();		
				break;
			case "Dia":
				qtdeMedida = Days.daysBetween(dataInicio.withTimeAtStartOfDay() , dataFim.withTimeAtStartOfDay()).getDays();	
				break;
		}
		
		double valorAluguel = aluguel.getRecurso().getValor() * qtdeMedida;
		
		ContasReceber conta = new ContasReceber();
		conta.setNome(aluguel.getMorador().getNome());
		conta.setHistorico(historico);
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(aluguel.getDataFinal());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setAluguel(aluguel);
		conta.setDataPagamento(aluguel.getDataPagamento());
		conta.setValor(valorAluguel);
		
		return conta;
	}

}
