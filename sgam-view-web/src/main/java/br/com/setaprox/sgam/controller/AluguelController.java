package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.facade.RecursoFacade;
import br.com.setaprox.sgam.model.Aluguel;

@Controller
public class AluguelController {
	private Result result;
	
	@Inject
	private AluguelFacade aluguelFacade;
	
	@Inject
	private RecursoFacade recursoFacade;
	
	private Validator validator;
	
	public AluguelController(){
		this(null, null);
	}
	
	@Inject
	public AluguelController(Result result, Validator validator){
		this.result = result;
		this.validator = validator;		
	}
	
	public void formularioAluguel(){
		result.include("recursos", recursoFacade.findAll());
	}
	
	public void listagemAluguel(){
		List<Aluguel> aluguelList = aluguelFacade.findAll();
		result.include("aluguelList", aluguelList);
	}
	
	@Post("aluguel/cadastro")
	public void cadastraAluguel(Aluguel aluguel){
		
		validator.validate(aluguel);
		
		validator.onErrorRedirectTo(this).formularioAluguel();

		if(aluguel.getId() != null && aluguel.getId() > 0){
			aluguelFacade.editar(aluguel);
			result.redirectTo(this).listagemAluguel();	
		}
		else {
			aluguelFacade.persist(aluguel);
			result.redirectTo(this).formularioAluguel();
		}
		
	}
	
	@Get("aluguel/editar/{id}")
	public void editarAluguel(Long id){
		if(id != null && id > 0){
			Aluguel aluguel = aluguelFacade.find(id);
			result.include(aluguel);
			result.redirectTo(this).formularioAluguel();
		}
	}
	
	@Delete("aluguel/remover/{id}")
	public void removerAluguel(Long id){
		try{
			aluguelFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover esse aluguel pois existe uma conta vinculado a esse faturamento.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover aluguel. Favor entrar em contato com o suporte.");
			}
		}
	}
}
