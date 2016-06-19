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

	@Get("/morador/listagem")
	public void listagemMoradores(){
		List<Morador> moradorList = moradorFacade.findAll();
		
		result.include("moradores", moradorList);
	}

	@Get("/morador/formulario")
	public void formularioMorador(){
		System.out.println("teste");
	}
	
	@Post("/morador/cadastro")
	public void cadastraMorador(Morador morador){
		try{
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
		}catch(Exception e){
			result.include(e.getMessage());
			result.use(Results.page()).redirectTo("/jsp/500.jsp");
		}
		
	}
	
	@Get("/morador/editar/{id}")
	public void editarMorador(Long id){
		if(id != null && id > 0){
			Morador morador = moradorFacade.find(id);
			result.include(morador);
			result.redirectTo(this).formularioMorador();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/morador/{id}")
	public void removeMorador(Long id){
		try{
			moradorFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover o cadastro desse morador pois existem faturamentos vinculado a esse registro.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
	}
	
	@Get("/morador/moradoresModal/{nome}")
	public void moradorModal(String nome){
		List<Morador> moradorList = moradorFacade.findByNome(nome);
		result.use(Results.json()).from(moradorList, "moradores").serialize();
	}
	
	@Get("/morador/moradoresModal")
	public void moradorModal(){
		List<Morador> moradorList = moradorFacade.findAll();
		result.use(Results.json()).from(moradorList, "moradores").serialize();
	}
}
