package br.com.setaprox.sgam.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.setaprox.sgam.facade.PerfilFacade;
import br.com.setaprox.sgam.facade.UsuarioFacade;
import br.com.setaprox.sgam.model.Perfil;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.BusinessException;
import br.com.setaprox.sgam.utils.CipherUtil;

@Controller
public class UsuarioController {
	private Result result;
	
	@Inject
	private UsuarioFacade usuarioFacade;
	
	@Inject 
	PerfilFacade perfilFacade;
	
	private Validator validator;
	
	public UsuarioController(){
		this(null, null);
	}
	
	@Inject
	public UsuarioController(Result result, Validator validator){
		this.result = result;
		this.validator = validator;
	}
	
	public void listagemUsuario(){
		result.include("usuarios", usuarioFacade.findAll());
	}
	
	public void formularioUsuario(){
		List<Perfil> listaPerfis = perfilFacade.findAll();
		result.include("listaPerfis", listaPerfis);
	}
	
	@Post("usuario/novo")
	public void cadastrarUsuario(Usuario usuario) {
		try {
			String senha = null;
			if(usuario.getSenha() != null && !usuario.getSenha().isEmpty()){
				senha = CipherUtil.encodeSHA256(usuario.getSenha());
				usuario.setSenha(senha);
			}
			
			validator.validate(usuario);
			
			validator.onErrorRedirectTo(this).formularioUsuario();
			
			if(usuario.getId() == null || usuario.getId() == 0){
				usuarioFacade.persist(usuario);
				result.redirectTo(this).formularioUsuario();
			}
			else {
				usuarioFacade.merge(usuario);
				result.redirectTo(this).listagemUsuario();
			}
			
		} catch (BusinessException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Get("usuario/editar/{id}")
	public void editarUsuario(Long id){
		try {
			
			if(id != null && id > 0){
				Usuario usuario = usuarioFacade.find(id);
				result.include(usuario);
				result.redirectTo(this).formularioUsuario();
			}
			
		} catch (BusinessException e) {
			
			e.printStackTrace();
			
		}
	}
	
	@Get("usuario/editar/")
	public void editarUsuarioLogado(){
		Session sessao = SecurityUtils.getSubject().getSession();
		Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
		result.include(usuario);
		result.redirectTo(this).formularioUsuario();
		
	}
	
	@Delete("usuario/remover/{id}")
	public void removerUsuario(Long id){
		try {
			
			usuarioFacade.remove(id);
			result.use(Results.json()).from("Excluído com sucesso!", "mensagem").serialize();
			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	public void validar(Usuario usuario){
		Usuario usuarioCadastrado = null;
		
		try{
			usuarioCadastrado = usuarioFacade.find(usuario.getId());	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		validator.validate(usuario);
		
		if(usuarioCadastrado != null && usuarioCadastrado.getId() != usuario.getId()){
			validator.add(new SimpleMessage("login", "Login já existente.", new Object[0]));
		}
		
		if(usuario.getId() == 0 && (usuario.getSenha() == null || usuario.getSenha().isEmpty())){
			validator.add(new SimpleMessage("senha", "Senha deve ser preenchida.", new Object[0]));
		}		
		else if(usuario.getId() > 0 && (usuario.getSenha() == null || usuario.getSenha().isEmpty())){
			try {
				usuario.setSenha(usuarioCadastrado.getSenha());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
