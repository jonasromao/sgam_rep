package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.ContasReceberFacade;
import br.com.setaprox.sgam.model.ContasReceber;

@Controller
public class ContasReceberController {
	
	@Inject
	private Result result;
	
	@Inject
	private ContasReceberFacade contasReceberFacade;
	
	public ContasReceberController() {
		
	}
	
	public void formularioContasReceber(){
		
	}
	
	public void listagemContasReceber(){
		List<ContasReceber> contas = contasReceberFacade.findAll();
		result.include("contas", contas);
	}
	
	@Post("/contasReceber/novo")
	public void cadastraContasReceber(ContasReceber contaReceber){
		try{
			if(contaReceber.getId() == null || contaReceber.getId() == 0){
				contasReceberFacade.persist(contaReceber);	
			}
			else {
				contasReceberFacade.merge(contaReceber);
			}
			
			result.redirectTo(this).listagemContasReceber();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Get("/contasReceber/editar/{id}")
	public void editarConta(Long id){
		if(id != null && id > 0){
			ContasReceber conta = contasReceberFacade.find(id);
			result.include("contaReceber", conta);
			result.redirectTo(this).formularioContasReceber();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/contasReceber/{id}")
	public void removeConta(Long id){
		try{
			contasReceberFacade.remove(id);
			result.use(Results.json()).from("Conta removida com sucesso!", "mensagem").serialize();
			
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover a conta pois existe um faturamento vinculado a esse recebimento.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
		
	}
}
