package br.com.setaprox.sgam.autenticacao;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import br.com.setaprox.sgam.DAO.UsuarioDAO;
import br.com.setaprox.sgam.model.Funcao;
import br.com.setaprox.sgam.model.Perfil;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.LookupGenerate;



public class AssociacaoRealm implements Realm, Authorizer {
	
	@Override
	public boolean isPermitted(PrincipalCollection principals, String permission) {		
		try{
			Session sessao = SecurityUtils.getSubject().getSession();
			Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
			
			String[] funcoesTela = permission.split(":");
			
			if(usuario != null){
				if(usuario.getPerfis() != null){
					for(Perfil perfil : usuario.getPerfis()){
						if(perfil.getFuncoes() != null){
							for(Funcao funcao : perfil.getFuncoes()){
								for(String check : funcoesTela){
									if(funcao.getCodigo().contains(check)){
										return true;
									}	
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

	@Override
	public boolean isPermitted(PrincipalCollection subjectPrincipal, Permission permission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection subjectPrincipal, String... permissions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] isPermitted(PrincipalCollection subjectPrincipal, List<Permission> permissions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection subjectPrincipal, String... permissions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPermittedAll(PrincipalCollection subjectPrincipal, Collection<Permission> permissions) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkPermission(PrincipalCollection subjectPrincipal, String permission) throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermission(PrincipalCollection subjectPrincipal, Permission permission)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermissions(PrincipalCollection subjectPrincipal, String... permissions)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPermissions(PrincipalCollection subjectPrincipal, Collection<Permission> permissions)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasRole(PrincipalCollection subjectPrincipal, String roleIdentifier) {
		try{
			Session sessao = SecurityUtils.getSubject().getSession();
			Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
			
			if(usuario != null){
				if(usuario.getPerfis() != null){
					for(Perfil perfil : usuario.getPerfis()){
						if(perfil.getNome().equalsIgnoreCase(roleIdentifier)){
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

	@Override
	public boolean[] hasRoles(PrincipalCollection subjectPrincipal, List<String> roleIdentifiers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAllRoles(PrincipalCollection subjectPrincipal, Collection<String> roleIdentifiers) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkRole(PrincipalCollection subjectPrincipal, String roleIdentifier) throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRoles(PrincipalCollection subjectPrincipal, Collection<String> roleIdentifiers)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkRoles(PrincipalCollection subjectPrincipal, String... roleIdentifiers)
			throws AuthorizationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "AssociacaoWeb";
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		AuthenticationInfo info = null;
		
		try {
			
			UsuarioDAO userDAO = LookupGenerate.getRecource(UsuarioDAO.class);
						
			String login = (String)token.getPrincipal();
			
			Usuario usuario = userDAO.findByLogin(login);
			
			String credencial = usuario.getSenha(); 
			
			if (credencial != null){
				
				info = new SimpleAuthenticationInfo(login, credencial, getName());
	            SimpleCredentialsMatcher cmatcher = new SimpleCredentialsMatcher();
	            
	            boolean credentialsMatch = cmatcher.doCredentialsMatch(token, info);
	            
	            // Credenciais não corresponderam, a autenticação falhou.
	            if(!credentialsMatch) {
	            	System.out.println("Login inválido!");
	            	throw new AuthenticationException("Login inválido!");
	            }

	            Session sessao = SecurityUtils.getSubject().getSession();
	            sessao.setAttribute("usuarioLogado", usuario);		
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new AuthenticationException("Erro durante autenticação: " + ex.getMessage()); 
		}

		return info;
	}

}
