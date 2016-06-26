package br.com.setaprox.sgam.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.facade.ContasReceberFacade;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller	
public class MetricasController {
	
	@Inject
	private Result result;
	
	@Inject
	private ContasReceberFacade contasReceberFacade;
	
	/*public MetricasController(){
		DateTime data = DateTime.now();
		
		DateTime dataInicio = data.dayOfMonth().withMinimumValue();
		DateTime dataFim = data.dayOfMonth().withMaximumValue();
		
		buscaPeriodo(dataInicio.toDate(), dataFim.toDate());
	}*/
	
	public void listagemMetricas(){
		
	}
	
	public void buscaPeriodo(Date dataInicio, Date dataFim){
		if(dataInicio != null && dataFim != null){
			List<ContasReceber> contasReceber = contasReceberFacade.findAllByPeriodo(dataInicio, dataFim, Categoria.ALUGUEL.getCodigo());
			List<ContasReceber> contasReceberAssociados = contasReceberFacade.findAllByPeriodo(dataInicio, dataFim, Categoria.ASSOCIADO.getCodigo());
			
			double valorTotalAluguel = 0.0;
			double valorTotalAssociado = 0.0;
			
			if(contasReceber != null && !contasReceber.isEmpty()){
				for(ContasReceber conta : contasReceber){
					valorTotalAluguel += conta.getValor();
				}
			}
			
			if(contasReceberAssociados != null && !contasReceberAssociados.isEmpty()){
				for(ContasReceber conta : contasReceberAssociados){
					valorTotalAssociado += conta.getValor();
				}
			}

			result.include("contasReceber", contasReceber);
			result.include("contasReceberAssociados", contasReceberAssociados);
			result.include("dataInicio", dataInicio);
			result.include("dataFim", dataFim);
			result.include("valorTotalAluguel", valorTotalAluguel);
			result.include("valorTotalAssociado", valorTotalAssociado);
		}
		
		result.redirectTo(this).listagemMetricas();
	}
}
