package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.CategoriaContasReceberFacade;
import br.com.setaprox.sgam.model.CategoriaContasReceber;

@Controller
public class CategoriaContasReceberController {
	
	@Inject
	private Result result;
	
	@Inject
	private CategoriaContasReceberFacade categoriaFacade;
	
	public CategoriaContasReceberController(){
		
	}
	
	public void listagemCategoriasContasReceber(){
		List<CategoriaContasReceber> categorias = categoriaFacade.findAll();
		result.include("categorias",categorias);
	}
	
	public void formularioCategoriaContasReceber(){
		
	}
	
	@Post("/categoriaContasReceber/novo")
	public void cadastraCategoriaContasReceber(CategoriaContasReceber categoria){
		try{

			categoriaFacade.editar(categoria);
			result.redirectTo(this).listagemCategoriasContasReceber();
			
		}catch(Exception e){
			result.include(e.getMessage());
			result.use(Results.page()).redirectTo("/jsp/500.jsp");
		}
	}

	@Get("/categoriaContasReceber/editar/{id}")
	public void editar(Long id){
		if(id != null && id > 0){
			CategoriaContasReceber categoria = categoriaFacade.find(id);
			result.include("categoria", categoria);
			result.redirectTo(this).formularioCategoriaContasReceber();
		}
		else {
			result.notFound();
		}
	}
}
