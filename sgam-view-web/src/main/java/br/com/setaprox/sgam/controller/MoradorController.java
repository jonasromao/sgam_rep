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
import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.model.Morador;


@Controller
public class MoradorController {
	private final Result result;

	private Validator validator;
	@Inject
	private MoradorFacade moradorFacade;
	//private MoradorValidator validator;
	/**
	 * @deprecated CDI eyes only
	 */
	public MoradorController() {
		this(null, null);
	}
	
	@Inject
	public MoradorController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	public void listagemMoradores(){
		List<Morador> moradorList = moradorFacade.findAll();
		
		result.include("moradores", moradorList);
	}

	public void formularioMorador(){
		
	}
	
	@Post("/morador/cadastro")
	public void cadastraMorador(Morador morador){
		morador.setNomeFonetizado(morador.getNome());
		
		validator.validate(morador);
		
		validator.onErrorRedirectTo(this).formularioMorador();
		
		if(morador.getId() != null && morador.getId() > 0){
			moradorFacade.editar(morador);
			result.redirectTo(this).listagemMoradores();	
		}
		else {
			moradorFacade.persist(morador);
			result.redirectTo(this).formularioMorador();
		}
		
	}
	
	@Get("/morador/editar/{id}")
	public void editarMorador(Long id){
		if(id != null && id > 0){
			Morador morador = moradorFacade.find(id);
			result.include(morador);
			result.redirectTo(this).formularioMorador();
			//result.use(Results.json()).from(true, "alteraAba").serialize();
		}
		else {
			//result.use(Results.json()).from(false, "alteraAba").serialize();
		}
	}
	
	@Delete("/morador/{id}")
	public void removeMorador(Long id){
		moradorFacade.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
	
	@Get("/morador/moradoresModal")
	public void moradorModal(){
		List<Morador> moradorList = moradorFacade.findAll();

		result.use(Results.json()).from(moradorList, "moradores").serialize();
	}
}
