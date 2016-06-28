package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.SegmentoFacade;
import br.com.setaprox.sgam.model.Segmento;

public class SegmentoController {
	
	@Inject
	private Result result;
	
	@Inject
	private SegmentoFacade segmentoFacade;
	
	@Get("/segmento/formulario")
	public void formularioSegmento(){}
	
	@Get("/segmento/listagem")
	public void listagemSegmentos(){
		List<Segmento> segmentos = segmentoFacade.findAll();
		result.include("segmentos", segmentos);
	}
	
	@Post("/segmento/cadastro")
	public void cadastraComercio(Segmento segmento){
		try{
			if(segmento.getId() != null && segmento.getId() > 0){
				segmentoFacade.editar(segmento);
				result.redirectTo(this).listagemSegmentos();
			}
			else {
				segmentoFacade.persist(segmento);
				result.redirectTo(this).formularioSegmento();
			}
		}catch(Exception e){
			result.include(e.getMessage());
			result.use(Results.page()).redirectTo("/jsp/500.jsp");
		}
	}
	
	@Get("/segmento/editar/{id}")
	public void edita(Long id){
		if(id != null && id > 0){
			Segmento segmento = segmentoFacade.find(id);
			result.include(segmento);
			result.redirectTo(this).formularioSegmento();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/segmento/{id}")
	public void remove(Long id){
		try{
			segmentoFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover o cadastro desse segmento pois existem comércios vinculado a esse registro.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
	}
}
