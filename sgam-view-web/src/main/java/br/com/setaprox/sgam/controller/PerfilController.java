package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.FuncaoFacade;
import br.com.setaprox.sgam.facade.PerfilFacade;
import br.com.setaprox.sgam.model.Funcao;
import br.com.setaprox.sgam.model.Perfil;

@Controller
public class PerfilController {

	@Inject
	private Result result;
	
	@Inject
	private PerfilFacade perfilFacade;
	
	@Inject
	private FuncaoFacade funcaoFacade;
	
	public void listagemPerfis(){
		List<Perfil> perfis = perfilFacade.findAll();
		result.include("perfis", perfis);
	}
	
	public void formularioPerfil(){
		List<Funcao> funcoes = funcaoFacade.findAll();
		result.include("funcoes", funcoes);
	}
	
	public void cadastraPerfil(Perfil perfil){
		try {
			
			if(perfil.getId() == null || perfil.getId() == 0){	
				perfilFacade.persist(perfil);
				result.redirectTo(this).formularioPerfil();
			}
			else {
				perfilFacade.editar(perfil);
				result.redirectTo(this).listagemPerfis();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Get("/perfil/editar/{id}")
	public void editarPerfil(Long id){
		if(id != null && id > 0){
			Perfil perfil = perfilFacade.find(id);
			result.include(perfil);
			result.redirectTo(this).formularioPerfil();
		}
		else {
			result.notFound();
		}
	}
	
	@Delete("/perfil/{id}")
	public void removePerfil(Long id){
		try{
			perfilFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
		}catch(Exception e){
			if(e.getCause().getCause().getMessage().contains("ConstraintViolationException")){
				result.use(Results.http()).sendError(500, "Não foi possível remover o cadastro desse perfil pois existem usuários vinculado a esse registro.");
			}
			else {
				result.use(Results.http()).sendError(500, "Erro ao remover conta. Favor entrar em contato com o suporte.");
			}
		}
	}
	
	
}
