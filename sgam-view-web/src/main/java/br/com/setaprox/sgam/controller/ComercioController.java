package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.ComercioFacade;
import br.com.setaprox.sgam.facade.SegmentoFacade;
import br.com.setaprox.sgam.model.Comercio;
import br.com.setaprox.sgam.model.Segmento;

@Controller
public class ComercioController {
	
	@Inject
	private Result result;
	
	@Inject
	private ComercioFacade comercioFacade;
	
	@Inject
	private SegmentoFacade segmentoFacade;
	
	@Get("/comercio/formulario")
	public void formularioComercio(){
		List<Segmento> segmentos = segmentoFacade.findAll();
		result.include("segmentos", segmentos);
	}
	
	@Get("/comercio/listagem")
	public void listagemComercio(){
		List<Comercio> comercios = comercioFacade.findAll();
		result.include("comercios", comercios);
	}
	
	@Post("/comercio/cadastro")
	public void cadastraComercio(Comercio comercio){
		try{
			if(comercio.getId() != null && comercio.getId() > 0){
				comercioFacade.editar(comercio);
				result.redirectTo(this).listagemComercio();
			}
			else {
				comercioFacade.persist(comercio);
				result.redirectTo(this).formularioComercio();
			}
		}catch(Exception e){
			result.include(e.getMessage());
			result.use(Results.page()).redirectTo("/jsp/500.jsp");
		}
	}
	
	@Get("/comercio/editar/{id}")
	public void edita(Long id){
		if(id != null && id > 0){
			Comercio comercio = comercioFacade.find(id);
			result.include(comercio);
			result.redirectTo(this).formularioComercio();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/comercio/{id}")
	public void remove(Long id){
		try{
			comercioFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover o cadastro desse comércio pois existem faturamentos vinculado a esse registro.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
	}
}
