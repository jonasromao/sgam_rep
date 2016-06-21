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
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.facade.OcorrenciaFacade;
import br.com.setaprox.sgam.model.Morador;
import br.com.setaprox.sgam.model.Ocorrencia;


@Controller
public class OcorrenciaController {
	private final Result result;

	@Inject
	private MoradorFacade moradorFacade;
	
	@Inject
	private OcorrenciaFacade ocorrenciaFacade;
	
	private Validator validator;
	
	/**
	 * @deprecated CDI eyes only
	 */
	public OcorrenciaController() {
		this(null, null);
	}
	
	@Inject
	public OcorrenciaController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}
	
	public void listagemOcorrencias(){
		List<Ocorrencia> ocorrenciaList = ocorrenciaFacade.findAll();
		result.include("ocorrencias", ocorrenciaList);
	}
	
	public void formularioOcorrencia(){
		//result.include(new Ocorrencia());
	}
	
	@Get("/ocorrencia/fechar/{id}")
	public void fechamentoOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaFacade.find(id);
			result.include(ocorrencia);
		}
	}
	
	@Post("/ocorrencia/cadastro")
	public void cadastraOcorrencia(Ocorrencia ocorrencia){
		validator.validate(ocorrencia);
		validator.onErrorRedirectTo(this).formularioOcorrencia();	
		
		if(ocorrencia.getId() != null && ocorrencia.getId() > 0){
			ocorrenciaFacade.merge(ocorrencia);
			result.redirectTo(this).listagemOcorrencias();
		}
		else {
			ocorrenciaFacade.persist(ocorrencia);
			result.redirectTo(this).formularioOcorrencia();
		}
	}
	
	@Get("/ocorrencia/editar/{id}")
	public void editarOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaFacade.find(id);
			result.include(ocorrencia);
			result.redirectTo(this).formularioOcorrencia();
		}
	}
	
	@Delete("/ocorrencia/excluir/{id}")
	public void removerOcorrencia(Long id){
		ocorrenciaFacade.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
	
	@Get("/ocorrencia/modal/{id}")
	public void abrirModalOcorrencia(Long id){
		if(id != null && id > 0){
			Ocorrencia ocorrencia = ocorrenciaFacade.find(id);
			result.use(Results.json()).from(ocorrencia, "ocorrencia").serialize();
		}
	}
	
	@Post("/ocorrencia/resolver")
	public void resolverOcorrencia(Ocorrencia ocorrencia){
		validator.validate(ocorrencia);
		validator.onErrorRedirectTo(this).fechamentoOcorrencia(ocorrencia.getId());
		
		ocorrenciaFacade.merge(ocorrencia);
		result.redirectTo(this).listagemOcorrencias();
	}
	
}
