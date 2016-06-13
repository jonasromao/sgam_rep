package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.ContasPagarFacade;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller
public class ContasPagarController {
	
	@Inject
	private Result result;
	
	@Inject
	private ContasPagarFacade contasPagarFacade;
	
	
	public ContasPagarController(){

	}
	
	public void formularioContasPagar(){
		
	}
	
	public void listagemContasPagar(){
		List<ContasPagar> contas = contasPagarFacade.findAll();
		result.include("contas", contas);
	}

	@Post("/contasPagar/novo")
	public void cadastraContasPagar(ContasPagar contaPagar){
		try{
			if(contaPagar.getId() == null || contaPagar.getId() == 0){
				contasPagarFacade.persist(contaPagar);	
				result.redirectTo(this).formularioContasPagar();
			}
			else {
				contasPagarFacade.merge(contaPagar);
				result.redirectTo(this).listagemContasPagar();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Get("/contasPagar/editar/{id}")
	public void editarConta(Long id){
		if(id != null && id > 0){
			ContasPagar conta = contasPagarFacade.find(id);
			result.include("contaPagar", conta);
			result.redirectTo(this).formularioContasPagar();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/contasPagar/{id}")
	public void removeConta(Long id){
		try{
			contasPagarFacade.remove(id);
			result.use(Results.json()).from("Conta removida com sucesso!", "mensagem").serialize();
			
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover a conta pois existe um faturamento vinculado à esse recebimento.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
	}
}
