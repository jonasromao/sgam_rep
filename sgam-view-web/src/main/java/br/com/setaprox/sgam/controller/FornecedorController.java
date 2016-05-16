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
import br.com.setaprox.sgam.facade.FornecedorFacade;
import br.com.setaprox.sgam.model.Fornecedor;


@Controller
public class FornecedorController {
	
	private final Result result;
	
	@Inject
	private FornecedorFacade fornecedorFacade;

	private Validator validator;
	//private FornecedorValidator validator;
	/**
	 * @deprecated CDI eyes only
	 */
	public FornecedorController() {
		this(null, null);
	}
	
	@Inject
	public FornecedorController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	public void listagemFornecedores(){
		List<Fornecedor> fornecedorList = fornecedorFacade.findAll();
		result.include("fornecedores", fornecedorList);
	}

	public void formularioFornecedor(){
		
	}
	
	@Post("/fornecedor/cadastro")
	public void cadastraFornecedor(Fornecedor fornecedor){
		validator.validate(fornecedor);
		
		validator.onErrorRedirectTo(this).formularioFornecedor();
		
		if(fornecedor.getId() != null && fornecedor.getId() > 0){
			fornecedorFacade.editar(fornecedor);
			result.redirectTo(this).listagemFornecedores();	
		}
		else {
			fornecedorFacade.persist(fornecedor);
			result.redirectTo(this).formularioFornecedor();
		}
		
	}
	
	@Get("/fornecedor/editar/{id}")
	public void editarFornecedor(Long id){
		if(id != null && id > 0){
			Fornecedor fornecedor = fornecedorFacade.find(id);
			result.include(fornecedor);
			result.redirectTo(this).formularioFornecedor();
			//result.use(Results.json()).from(true, "alteraAba").serialize();
		}
		else {
			//result.use(Results.json()).from(false, "alteraAba").serialize();
		}
	}
	
	@Delete("/fornecedor/{id}")
	public void removeFornecedor(Long id){
		fornecedorFacade.remove(id);
		result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
	}
	
	@Get("/fornecedor/fornecedoresModal")
	public void fornecedorModal(){
		List<Fornecedor> fornecedorList = fornecedorFacade.findAll();

		result.use(Results.json()).from(fornecedorList, "fornecedores").serialize();
	}
}
