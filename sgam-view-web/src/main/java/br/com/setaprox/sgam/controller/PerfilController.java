package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
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
		
	}
	
	public void editarPerfil(Long id){
		
	}
	
	public void removePerfil(Long id){
		
	}
	
	
}
