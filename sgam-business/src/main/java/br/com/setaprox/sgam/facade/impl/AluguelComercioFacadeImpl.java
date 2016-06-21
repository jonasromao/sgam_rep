package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.joda.time.DateTime;

import br.com.setaprox.sgam.facade.AluguelComercioFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.ContasReceber;
import br.com.setaprox.sgam.service.AluguelComercioService;
import br.com.setaprox.sgam.service.ContasReceberService;

@Named
@RequestScoped
public class AluguelComercioFacadeImpl implements AluguelComercioFacade {

	@EJB
	private AluguelComercioService aluguelComercioService;
	
	@EJB
	private ContasReceberService contasReceberService;
	
	
	@Override
	public List<AluguelComercio> findAll() {
		
		return aluguelComercioService.findAll();
		
	}


	@Override
	public void editar(AluguelComercio aluguelComercio) {
		
		aluguelComercioService.editar(aluguelComercio);
		
	}


	@Override
	public AluguelComercio find(Long id) {
		
		return aluguelComercioService.find(id);
		
	}


	@Override
	public void remove(Long id) {
		
		aluguelComercioService.remove(id);
		
	}


	@Override
	public void persist(AluguelComercio aluguelComercio) {
		aluguelComercioService.persist(aluguelComercio);
		
		Aluguel aluguel = aluguelComercio.getAluguel();
		
		DateTime dataEmissao = new DateTime(new Date()); 
		ContasReceber conta = new ContasReceber();
		conta.setNome(aluguel.getMorador().getNome());
		conta.setHistorico(String.format("Comércio informal - Atividade %s", aluguelComercio.getNome()));
		conta.setDataEmissao(dataEmissao.toDate());
		conta.setDataVencimento(aluguel.getDataFinal());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDayOfMonth(),dataEmissao.getMonthOfYear(),dataEmissao.getYear(), dataEmissao.getHourOfDay(), dataEmissao.getMinuteOfHour(), dataEmissao.getSecondOfMinute()));
		conta.setAluguel(aluguel);
		conta.setDataPagamento(aluguel.getDataPagamento());
		conta.setValor(aluguel.getRecurso().getValor());
		
		contasReceberService.persist(conta);
	}

}
