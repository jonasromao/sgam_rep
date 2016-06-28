package br.com.setaprox.sgam.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.setaprox.sgam.constante.Categoria;
import br.com.setaprox.sgam.facade.ContasPagarFacade;
import br.com.setaprox.sgam.facade.ContasReceberFacade;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller	
public class MetricasController {
	
	@Inject
	private Result result;
	
	@Inject
	private ContasReceberFacade contasReceberFacade;
	
	@Inject
	private ContasPagarFacade contasPagarFacade;
	
	public void listagemMetricas(){
		
	}
	
	public void buscaPeriodo(Date dataInicio, Date dataFim, String status){
		if(dataInicio != null && dataFim != null){
			List<ContasReceber> contasReceber = contasReceberFacade.findAllByPeriodo(dataInicio, dataFim, Categoria.ALUGUEL.getCodigo(), status);
			List<ContasReceber> contasReceberAssociados = contasReceberFacade.findAllByPeriodo(dataInicio, dataFim, Categoria.ASSOCIADO.getCodigo(), status);
			List<ContasPagar> contasPagar = contasPagarFacade.findAllByPeriodo(dataInicio, dataFim, status);
			
			double valorTotalAluguel = 0.0;
			double valorTotalAssociado = 0.0;
			double valorContasPagar = 0.0;
			
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
			
			if(contasPagar != null && !contasPagar.isEmpty()){
				for(ContasPagar conta : contasPagar){
					valorContasPagar += conta.getValor();
				}
			}

			result.include("contasReceber", contasReceber);
			result.include("contasPagar", contasPagar);
			result.include("contasReceberAssociados", contasReceberAssociados);
			result.include("dataInicio", dataInicio);
			result.include("dataFim", dataFim);
			result.include("status", status);
			result.include("valorTotalAluguel", valorTotalAluguel);
			result.include("valorTotalAssociado", valorTotalAssociado);
			result.include("valorContasPagar", valorContasPagar);
			result.include("totalGeral", ((valorTotalAssociado + valorTotalAluguel) - valorContasPagar));
		}
		
		result.redirectTo(this).listagemMetricas();
	}
}
