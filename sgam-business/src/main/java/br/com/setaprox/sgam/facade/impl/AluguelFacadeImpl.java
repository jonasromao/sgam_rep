package br.com.setaprox.sgam.facade.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

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

		Date dataEmissao = new Date(); 
		ContasReceber conta = new ContasReceber();
		conta.setNome(aluguel.getMorador().getNome());
		conta.setHistorico(String.format("Aluguel da %s", aluguel.getRecurso().getNome()));
		conta.setDataEmissao(dataEmissao);
		conta.setDataVencimento(aluguel.getDataFinal());
		conta.setNumero(String.format("%d%d%d%d%d%d", dataEmissao.getDate(),dataEmissao.getMonth(),dataEmissao.getYear(), dataEmissao.getHours(), dataEmissao.getMinutes(), dataEmissao.getSeconds()));
		conta.setAluguel(aluguel);
		conta.setDataPagamento(aluguel.getDataPagamento());
		conta.setValor(aluguel.getRecurso().getValor());
		
		contasReceberService.persist(conta);
	}


	@Override
	public List<Aluguel> reservasPorDia(Date data) {
		return aluguelService.reservasPorDia(data);
	}

}
