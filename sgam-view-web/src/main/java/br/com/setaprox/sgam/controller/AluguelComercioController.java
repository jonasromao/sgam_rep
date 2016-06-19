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
import br.com.setaprox.sgam.facade.AluguelComercioFacade;
import br.com.setaprox.sgam.facade.RecursoFacade;
import br.com.setaprox.sgam.model.AluguelComercio;

@Controller
public class AluguelComercioController {
	private Result result;
	
	@Inject
	private AluguelComercioFacade aluguelComercioFacade;
	
	@Inject
	private RecursoFacade recursoFacade;
	
	private Validator validator;
	
	public AluguelComercioController(){
		this(null, null);
	}
	
	@Inject
	public AluguelComercioController(Result result, Validator validator){
		this.result = result;
		this.validator = validator;		
	}
	
	public void formularioAluguelComercio(){
		result.include("recursos", recursoFacade.findAll());
	}
	
	public void listagemAluguelComercio(){
		List<AluguelComercio> aluguelList = aluguelComercioFacade.findAll();
		result.include("aluguelList", aluguelList);
	}
	
	@Post("aluguelComercio/cadastro")
	public void cadastraAluguelComercio(AluguelComercio aluguelComercio){
		
		validator.validate(aluguelComercio);
		
		validator.onErrorRedirectTo(this).formularioAluguelComercio();

		if(aluguelComercio.getId() != null && aluguelComercio.getId() > 0){
			aluguelComercioFacade.editar(aluguelComercio);
			result.redirectTo(this).listagemAluguelComercio();	
		}
		else {
			aluguelComercioFacade.persist(aluguelComercio);
			result.redirectTo(this).formularioAluguelComercio();
		}
		
	}
	
	@Get("aluguelComercio/editar/{id}")
	public void editarAluguelComercio(Long id){
		if(id != null && id > 0){
			AluguelComercio aluguelComercio = aluguelComercioFacade.find(id);
			result.include(aluguelComercio);
			result.redirectTo(this).formularioAluguelComercio();
		}
	}
	
	@Delete("aluguelComercio/remover/{id}")
	public void removerAluguelComercio(Long id){
		try{
			aluguelComercioFacade.remove(id);
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
