package br.com.setaprox.sgam.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.model.Recurso;
import br.com.setaprox.sgam.service.RecursoService;

@Controller
public class RecursoController {
	
	@Inject
	private RecursoService recursoService;
	
	private Result result;
	private Validator validator;
	
	public RecursoController(){
		this(null, null);
	}
	
	@Inject
	public RecursoController(Result result, Validator validator){
		this.result = result;
		this.validator = validator;
	}
	
	public void cadastraRecurso(Recurso recurso){
		validator.validate(recurso);
		validator.onErrorRedirectTo(this).formularioRecurso();
		
		if(recurso.getId() != null && recurso.getId() > 0){
			recursoService.editar(recurso);
			result.redirectTo(this).listagemRecursos();	
		}
		else {
			recursoService.persist(recurso);
			result.redirectTo(this).formularioRecurso();
		}
	}
	
	public void listagemRecursos(){
		result.include("recursos", recursoService.findAll());
	}
	
	public void formularioRecurso(){
		
	}
	
	@Get("/recurso/editar/{id}")
	public void editar(Long id){
		if(id != null && id > 0){
			Recurso recurso = recursoService.find(id);
			result.include(recurso);
			result.redirectTo(this).formularioRecurso();
			//result.use(Results.json()).from(true, "alteraAba").serialize();
		}
		else {
			//result.use(Results.json()).from(false, "alteraAba").serialize();
		}
	}
	
	@Delete("/recurso/remover/{id}")
	public void remover(Long id){
		recursoService.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
}
