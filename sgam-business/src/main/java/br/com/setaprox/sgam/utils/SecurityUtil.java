package br.com.setaprox.sgam.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import br.com.setaprox.sgam.model.Funcao;
import br.com.setaprox.sgam.model.Perfil;
import br.com.setaprox.sgam.model.Usuario;

public class SecurityUtil {
	public static boolean temPermissao(String nomeFuncao) {
		try{
			Session sessao = SecurityUtils.getSubject().getSession();
			Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
			
			if(usuario != null){
				if(usuario.getPerfis() != null){
					for(Perfil perfil : usuario.getPerfis()){
						if(perfil.getFuncoes() != null){
							for(Funcao funcao : perfil.getFuncoes()){
								if(funcao.getCodigo().contains(nomeFuncao)){
									return true;
								}
							}
						}
					}
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
				
		return false;
	}
	
	public static boolean temPerfil(String nomePerfil){
		try{
			Session sessao = SecurityUtils.getSubject().getSession();
			Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
			
			if(usuario != null){
				if(usuario.getPerfis() != null){
					for(Perfil perfil : usuario.getPerfis()){
						if(perfil.getNome().equalsIgnoreCase(nomePerfil)){
							return true;
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
}
