package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;

import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.AluguelService;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class AluguelFacadeImpl implements AluguelFacade {

	@EJB
	private AluguelService aluguelService;
	
	@EJB
	private ContasReceberService contasReceberService;
	
	
	@Override
	public List<Aluguel> findAll() {
		
		return aluguelService.findAll();
		
	}


	@Override
	public void editar(Aluguel aluguel) {
		
		aluguelService.editar(aluguel);
		
	}


	@Override
	public Aluguel find(Long id) {
		
		return aluguelService.find(id);
		
	}


	@Override
	public void remove(Long id) {
		
		aluguelService.remove(id);
		
	}


	@Override
	public void persist(Aluguel aluguel) {		
		aluguelService.persist(aluguel);

		DateTime dataEmissao = new DateTime(new Date());
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
		conta.setHistorico(String.format("Aluguel da %s", aluguel.getRecurso().getNome()));
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(aluguel.getDataFinal());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setAluguel(aluguel);
		conta.setDataPagamento(aluguel.getDataPagamento());
		conta.setValor(valorAluguel);
		
		contasReceberService.persist(conta);
	}


	@Override
	public List<Aluguel> reservasPorDia(Date data) {
		return aluguelService.reservasPorDia(data);
	}

}
